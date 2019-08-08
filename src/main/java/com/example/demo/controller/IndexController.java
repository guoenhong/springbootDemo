package com.example.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
public class IndexController {

    private static final Logger LOGGER = LoggerFactory.getLogger(IndexController.class);

    @RequestMapping("/hello")
    public String hello() {
        return "helloword";
    }

    @RequestMapping("/index")
    public String index(Integer userId) {
        LOGGER.info("我是info");
        String user= "zhangsan";
        if(userId!=null){
            int i = 1/userId;
            user="wangwu";
        }

        return "456"+user;
    }

}
