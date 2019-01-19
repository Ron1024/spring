package com.ron.springbootshiro.controller;

import com.ron.springbootshiro.common.domain.ResponsePo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
public class HomeController {

    @RequestMapping({"/", "/index"})
    public String gotoMain() {
        return "login";
    }

    @RequestMapping("/403")
    public String unauthorized() {
        return "403";
    }

    @RequestMapping("/ajaxLogin")
    @ResponseBody
    public ResponsePo ajaxLogin(HttpServletRequest httpServletRequest, Map<String, Object> map) {
        String msg = "";
        String userName = httpServletRequest.getParameter("userName");
        String password = httpServletRequest.getParameter("password");
        boolean rememberMe = Boolean.parseBoolean(httpServletRequest.getParameter("rememberMe"));
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(userName, password, rememberMe);
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(usernamePasswordToken);
            return  ResponsePo.success("登陆成功，即将为您跳转");
        } catch (UnknownAccountException e) {
            return  ResponsePo.error("账号不存在");
        } catch (IncorrectCredentialsException e) {
            return  ResponsePo.error("密码不正确");
        }
    }

    @RequestMapping("logout")
    public String logout(){
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return "login";
    }

}
