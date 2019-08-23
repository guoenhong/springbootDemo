package com.example.demo.controller;

import com.example.demo.pojo.User;
import com.example.demo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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

    @RequestMapping("/insertUser")
    public int index(Integer userId) {
        Map<String, Object> result = new HashMap<String, Object>();
        log.info("set user");
        //Integer addFlag = userService.addUser(user);
        int i = userService.insertUser("wangwu", "female");
        if(i==1){

            log.info("add user successfully");
            return i;
        }else{
            log.error("insert user failed");
            return 0;
        }
    }

    @RequestMapping("/async")
    public void testAsync(){
        log.info("this is 1 steps");
        userService.testAsync();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("this is 4 step");
    }

    @Value("${name}")
    private String name;

    @RequestMapping("/getName")
    public String getName(){
        return name;
    }

    @RequestMapping("/findByName")
    public Map find(String name) {
        Map<String, Object> result = new HashMap<String, Object>();

        User user = userService.findByName(name);

        result.put("name",user.getName());
        result.put("sex",user.getSex());
        return result;
    }
}
