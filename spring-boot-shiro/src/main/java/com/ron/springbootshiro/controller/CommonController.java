package com.ron.springbootshiro.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/common")
public class CommonController {

    @RequestMapping("/gotoMainPage")
    public String gotoMainPage() {
        return "common/main";
    }

    @RequestMapping("/getLeftSide")
    public String getLeftSide() {
        return "common/leftSide";
    }

    @RequestMapping("footer")
    public String footer() {
        return "common/footer";
    }

    @RequestMapping("dashboardEcommerce")
    public String dashboardEcommerce(){
        return "common/dashboard";
    }

}
