package com.example.demo.dev1.service;

import com.example.demo.dev1.mapper.UserMapper;
import com.example.demo.pojo.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
public class UserServiceTest1 {

    @Autowired
    private UserMapper userMapper;

    public Integer addUser(User user) {
        log.info("add user start");
        return 1;
    }



    public User findByName(String name) {
        User user = userMapper.findByName(name);
        return user;
    }

    @Transactional(transactionManager = "test1TransactionManager")
    public int insertUser(String name, String sex) {
        log.info("insert user "+name+", "+sex);
        int i = userMapper.insertUser(name, sex);
        return i;
    }
}
