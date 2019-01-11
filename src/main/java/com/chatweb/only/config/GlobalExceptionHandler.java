package com.chatweb.only.config;

import com.chatweb.only.bean.Result;
import com.chatweb.only.bean.ResultCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * 全局异常统一处理
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    // 捕获RuntimeException类及其子类异常
    @ExceptionHandler(RuntimeException.class)
    public Result handleException(){
        Result result = new Result(ResultCode.SUCCEED);
        return result;
    }


}
