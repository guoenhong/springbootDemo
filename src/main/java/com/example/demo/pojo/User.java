package com.example.demo.pojo;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Data
@Slf4j
@Component
public class User {

    private Integer id;
    private String name;
    private String sex;
    private Integer age;


}
