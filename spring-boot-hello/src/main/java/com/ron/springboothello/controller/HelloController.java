package com.ron.springboothello.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @RequestMapping(name = "/hello")
    @ResponseBody
    public String hello(){
        return "Hello Spring Boot";
    }
}
