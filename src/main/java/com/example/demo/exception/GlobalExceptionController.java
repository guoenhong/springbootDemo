package com.example.demo.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionController {
    private static final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionController.class);


    @ExceptionHandler(RuntimeException.class)
    //@ResponseBody
    public Object exceptionTest(Exception ex){
        LOGGER.error("ERROR Message : ",ex);

        Map<String,Object> errorMsg = new HashMap<String, Object>();
        errorMsg.put("Code",500);
        errorMsg.put("Msg","系统错误,请联系管理员!");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addAllObjects(errorMsg);
        modelAndView.setViewName("errorMsg");
        return modelAndView;
    }
}
