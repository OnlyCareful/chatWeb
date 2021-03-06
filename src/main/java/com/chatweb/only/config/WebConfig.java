package com.chatweb.only.config;

import com.chatweb.only.bean.Result;
import com.chatweb.only.bean.ResultCode;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 拦截器配置
 * @author InnerConce
 * @date 2019/01/20
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    private static final String OS_NAME = "win";

    /**
     * 加载拦截器（拦截器的执行是会根据 registry 注入的先后顺序执行）
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new WebInterceptor())
                .addPathPatterns("/test/**");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        String os = System.getProperty("os.name");
        if (os.toLowerCase().startsWith(OS_NAME)){
            // windows系统设置文件
            registry.addResourceHandler("/intercept/**").addResourceLocations("file:E:/intercept/");
        } else {
            // linux系统设置文件
            registry.addResourceHandler("/intercept/**").addResourceLocations("file:/intercept/");
        }
    }

    /**
     * 拦截器
     */
    private class WebInterceptor implements HandlerInterceptor {
        /**
         * 请求处理前拦截
         */
        @Override
        public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
            System.out.println("请求处理前拦截");
            return false;
        }

        /**
         * 请求处理后，视图渲染前
         */
        @Override
        public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
            System.out.println("请求处理后，视图渲染前");
        }

        /**
         * 整个请求结束后
         */
        @Override
        public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
            System.out.println("整个请求结束后");
        }
    }
}

/**
 * 返回值格式统一处理配置
 */
@ControllerAdvice
class ReturnedFormatConfig implements ResponseBodyAdvice<Object> {
    /**
     * 过滤（true则执行beforeBodyWrite方法，false则不执行）
     */
    @Override
    public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> aClass) {
        // 判断处理请求的方法返回值类型是否为Result，是否报错
        boolean isResponseEntity = !methodParameter.getMethod().getReturnType().isAssignableFrom(ResponseEntity.class);
        boolean isResult = !methodParameter.getMethod().getReturnType().isAssignableFrom(Result.class);
        return isResponseEntity && isResult;
    }

    /**
     * 处理返回值
     */
    @Override
    public Result beforeBodyWrite(Object returnValue, MethodParameter methodParameter, MediaType mediaType,
                                  Class<? extends HttpMessageConverter<?>> aClass,
                                  ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        return new Result<>(ResultCode.SUCCEED,returnValue);
    }
}
