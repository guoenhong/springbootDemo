package com.example.demo.service.impl;

import com.example.demo.mapping.UserMapper;
import com.example.demo.pojo.User;
import com.example.demo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public Integer addUser(User user) {
        log.info("add user start");
        return 1;
    }

    @Override
    @Async
    public void testAsync() {
        log.info("this is 2 step");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("this is 3 step");
    }

    @Override
    public User findByName(String name) {
        User user = userMapper.findByName(name);
        return user;
    }

    @Override
    @Transactional
    public int insertUser(String name, String sex) {
        log.info("insert user "+name+", "+sex);
        int i = userMapper.insertUser(name, sex);
        return i;
    }
}
