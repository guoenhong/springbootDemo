package com.example.demo.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionController {
    private static final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionController.class);


    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    public String exceptionTest(Exception ex){
        /*Map<Object,Object> errorMsg = new HashMap<Object, Object>();
        errorMsg.put("errorCode",500);
        errorMsg.put("errorMsg","系统错误,请联系管理员!");*/

        LOGGER.debug("我是debug");
        LOGGER.info("我是info");
        LOGGER.error("我是error,我的错误信息 : ",ex);

        return "系统错误,请联系管理员!";
    }
}
