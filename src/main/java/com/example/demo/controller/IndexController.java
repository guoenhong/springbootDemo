package com.example.demo.controller;

import com.example.demo.dev1.service.UserServiceTest1;
import com.example.demo.dev2.service.UserServiceTest2;
import com.example.demo.pojo.User;
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
    private UserServiceTest1 userServiceTest1;
    @Autowired
    private UserServiceTest2 userServiceTest2;


    @RequestMapping("/hello")
    public String hello() {
        return "helloword";
    }

    @RequestMapping("/insertUser")
    public int index(Integer userId) {
        Map<String, Object> result = new HashMap<String, Object>();
        log.info("set user");
        //Integer addFlag = userService.addUser(user);
        int i = userServiceTest1.insertUser("wangwu", "female");
        if(i==1){

            log.info("add user successfully");
            return i;
        }else{
            log.error("insert user failed");
            return 0;
        }
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

        User user = userServiceTest1.findByName(name);

        result.put("name",user.getName());
        result.put("sex",user.getSex());
        return result;
    }

    @RequestMapping("/insertUser1")
    public int insertUser1(Integer userId) {
        Map<String, Object> result = new HashMap<String, Object>();
        log.info("set user1");
        int i = userServiceTest1.insertUser("user1", "male");
        if(i==1){

            log.info("add user1 successfully");
            return i;
        }else{
            log.error("insert user1 failed");
            return 0;
        }
    }

    @RequestMapping("/insertUser2")
    public int insertUser2(Integer userId) {
        Map<String, Object> result = new HashMap<String, Object>();
        log.info("set user1");
        int i = userServiceTest2.insertUser("user2", "female");
        if(i==1){
            log.info("add user1 successfully");
            return i;
        }else{
            log.error("insert user1 failed");
            return 0;
        }
    }

}
