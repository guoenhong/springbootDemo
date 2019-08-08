package com.example.demo.controller;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
public class IndexController {


    @RequestMapping("/hello")
    public String hello() {
        return "helloword";
    }

    @RequestMapping("/index")
    public String index(Integer userId) {
        String user= "zhangsan";
        if(userId!=null){
            int i = 1/userId;
            user="wangwu";
        }

        return "456"+user;
    }

}
