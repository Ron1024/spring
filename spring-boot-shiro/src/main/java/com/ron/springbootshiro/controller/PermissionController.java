package com.ron.springbootshiro.controller;

import com.alibaba.fastjson.JSON;
import com.ron.springbootshiro.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/permission")
public class PermissionController {

    @Autowired
    PermissionService permissionService;

    @RequestMapping("/getPermissionsByUserName")
    @ResponseBody
    public String getPermissionByUserName(String userName){
        String perssionJson = JSON.toJSONString(permissionService.getPermissionsByUserName(userName));
        return perssionJson;
    }
}
