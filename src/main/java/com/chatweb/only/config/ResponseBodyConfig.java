package com.chatweb.only.config;

import com.chatweb.only.bean.Result;
import com.chatweb.only.bean.ResultCode;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * 返回值格式统一处理
 */
@ControllerAdvice
public class ResponseBodyConfig implements ResponseBodyAdvice {

    @Override
    public boolean supports(MethodParameter methodParameter, Class aClass) {
        return !methodParameter.getMethod().getReturnType().isInstance(Result.class);
    }

    @Override
    public Object beforeBodyWrite(Object returnValue, MethodParameter methodParameter, MediaType mediaType,
                                  Class aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        System.out.println("返回值拦截");
        return new Result<>(ResultCode.SUCCEED,returnValue);
    }
}
