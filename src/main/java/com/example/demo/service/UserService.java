package com.example.demo.service;

import com.example.demo.pojo.User;

public interface UserService {

    public Integer addUser(User user);
    public void testAsync();
    User findByName(String name);
    int insertUser(String name,String sex);
}
