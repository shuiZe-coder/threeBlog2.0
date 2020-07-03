package org.shuize.blogadminconsumer.login.controller;

import org.shuize.blogadminconsumer.login.service.LoginRemoteService;
import org.shuize.commonapi.RespUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.three.ourblog.login.pojo.TUser;

import javax.servlet.http.HttpSession;

@Controller
@CrossOrigin
@RequestMapping("/admin")
public class LoginPageController {

    @Autowired
    private LoginRemoteService loginRemoteService;

    @GetMapping("/login")
    public String login(){
        return "admin/login";
    }

    @PostMapping("/verify")
    @ResponseBody
    public RespUtil verify(HttpSession session,  @RequestBody TUser user){
        RespUtil result = loginRemoteService.verify(user);
        if (result.getCode() == 200){
            session.setAttribute("user", user.getNickname());
        }
        return result;
    }
}
