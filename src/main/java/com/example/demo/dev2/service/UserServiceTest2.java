package com.example.demo.dev2.service;

import com.example.demo.dev2.mapper.UserMapper2;
import com.example.demo.pojo.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
public class UserServiceTest2 {

    @Autowired
    private UserMapper2 userMapper2;

    public Integer addUser(User user) {
        log.info("add user start");
        return 1;
    }

   

    public User findByName(String name) {
        User user = userMapper2.findByName(name);
        return user;
    }

    @Transactional(transactionManager = "test2TransactionManager")
    public int insertUser(String name, String sex) {
        log.info("insert user "+name+", "+sex);
        int i = userMapper2.insertUser(name, sex);
        return i;
    }
}
