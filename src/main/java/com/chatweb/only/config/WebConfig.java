package com.chatweb.only.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 拦截器
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {
    /**
     * 加载拦截器
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new UploadWebConfigurer()).addPathPatterns("/test/**");
    }

    public class UploadWebConfigurer implements HandlerInterceptor {
        /**
         * 请求处理前调用
         */
        @Override
        public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
            System.out.println("处理前");
            return true;
        }

        /**
         * 请求处理后，渲染视图前被调用
         */
        @Override
        public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
            System.out.println("处理后");
        }

        /**
         * 在整个请求结束之后被调用
         */
        @Override
        public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
            System.out.println("结束后");
        }
    }
}