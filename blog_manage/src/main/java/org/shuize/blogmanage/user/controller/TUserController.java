package org.shuize.blogmanage.user.controller;


import org.shuize.blogmanage.user.service.TUserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author shuize
 * @since 2020-06-17
 */
@Controller
@RequestMapping("/admin")
public class TUserController {

    @Resource
    private TUserService userService;

    @GetMapping
    public String index(){
        return "/admin/index";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.removeAttribute("user");
        return "redirect:/admin/login";
    }

}