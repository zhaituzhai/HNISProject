package com.zhaojm.util;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value=Exception.class)
    @ResponseBody
    public String defaultErrorHandler(){
        System.out.println("-------------default error");
        return "系统错误，请联系管理员";
    }

}
