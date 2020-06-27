package org.shuize.blogmanage.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/admin/article")
public class ArticleController {

    @GetMapping("/manage")
    public String manage(){
        return "/admin/blogs";
    }

    @GetMapping("/add")
    public String add(){
        return "/admin/blogs-input";
    }

    @GetMapping("/update/{id}")
    public String update(){
        return "/admin/blogs-update";
    }
}