package org.shuize.blogadminconsumer.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class BlogPageController {

    @GetMapping("/article/manage")
    public String manage(){
        return "/admin/blogs";
    }

    @GetMapping
    public String index(){
        return "admin/index";
    }

    @GetMapping("/article/add")
    public String add(){
        return "/admin/blogs-input";
    }

    @GetMapping("/article/update/{id}")
    public String update(){
        return "/admin/blogs-update";
    }
}
