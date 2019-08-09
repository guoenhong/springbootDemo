package com.example.demo.controller;

import com.example.demo.pojo.User;
import com.example.demo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
@EnableAutoConfiguration
public class IndexController {

    @Autowired
    private User user;
    @Autowired
    private UserService userService;

    @RequestMapping("/hello")
    public String hello() {
        return "helloword";
    }

    @RequestMapping("/index")
    public Map index(Integer userId) {
        Map<String, Object> result = new HashMap<String, Object>();
        if(userId!=null){
            int i = 1/userId;
            user.setId(userId);
            result.put("id",user.getId());
        }
        log.info("set user");
        user.setAge(10);
        user.setName("zhangsan");
        user.setSex("female");

        Integer addFlag = userService.addUser(user);
        if(addFlag==1){

            log.info("add user successfully");
        }
        result.put("name",user.getName());
        result.put("sex",user.getSex());
        return result;
    }

}
