package com.example.demo.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@ControllerAdvice
public class GlobalExceptionController {


    @ExceptionHandler(RuntimeException.class)
    //@ResponseBody
    public Object exceptionTest(Exception ex){
        log.error("ERROR Message : ",ex);

        Map<String,Object> errorMsg = new HashMap<String, Object>();
        errorMsg.put("Code",500);
        errorMsg.put("Msg","System Error,please contact Administrator!");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addAllObjects(errorMsg);
        modelAndView.setViewName("errorMsg");
        return modelAndView;
    }
}
