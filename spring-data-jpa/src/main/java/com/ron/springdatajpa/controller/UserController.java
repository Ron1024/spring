package com.ron.springdatajpa.controller;


import com.ron.springdatajpa.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {

    @Autowired
    UserDao userDao;

    @RequestMapping("/getUserByEmail")
    @ResponseBody
    public String getUserByEmail(@RequestParam("email")String email){
        return userDao.findUserByEmail(email).toString();
    }
}
