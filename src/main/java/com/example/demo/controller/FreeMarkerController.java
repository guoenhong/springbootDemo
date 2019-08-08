package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
public class FreeMarkerController {

    @RequestMapping("/ftlTest")
    public String ftlIndex(Map<Object,Object> map){
        map.put("name","zhangsan");
        map.put("age",20);
        map.put("sex","男");
        map.put("score",200);
        map.put("hobby","sport");
        return "ftlIndex";
    }
}
