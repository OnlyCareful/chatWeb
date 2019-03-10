package com.chatweb.only.config;

import com.chatweb.only.bean.Result;
import com.chatweb.only.bean.ResultCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * 异常处理器，全局异常统一处理
 *
 * @author InnerConce
 * @date 2019/01/20
 */
@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    /**
     * 捕获RuntimeException类及其子类异常
     */
    @ExceptionHandler(RuntimeException.class)
    public String handleException(HttpServletRequest request) {
        // 设置返回状态码
        request.setAttribute("javax.servlet.error.status_code", ResultCode.CUSTOM.getCode());
        // 返回数据
        Result result = new Result(ResultCode.SUCCEED);
        // 返回数据存入request域中
        request.setAttribute("result", result);
        return "forward:/error";
    }
}

@Component
class CarryErrorAttributes extends DefaultErrorAttributes {

    @Override
    public Map<String, Object> getErrorAttributes(WebRequest webRequest, boolean includeStackTrace) {
        Map<String, Object> errorAttributes = super.getErrorAttributes(webRequest, includeStackTrace);
        // 从request域中获取自定义返回数据
        Result result = (Result) webRequest.getAttribute("result", WebRequest.SCOPE_REQUEST);
        errorAttributes.put("result", result);
        return errorAttributes;
    }
}
