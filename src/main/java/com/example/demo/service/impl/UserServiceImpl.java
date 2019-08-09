package com.example.demo.service.impl;

import com.example.demo.pojo.User;
import com.example.demo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserServiceImpl implements UserService {


    @Override
    public Integer addUser(User user) {
        log.info("add user start");
        return 1;
    }
}
