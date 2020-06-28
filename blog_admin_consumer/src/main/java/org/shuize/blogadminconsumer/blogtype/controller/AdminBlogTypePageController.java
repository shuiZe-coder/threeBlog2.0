package org.shuize.blogadminconsumer.blogtype.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/type")
public class AdminBlogTypePageController {

    @GetMapping("/manage")
    public String showTypePage(){
        return "admin/types";
    }

    @GetMapping("/add")
    public String showTypeInputPage(){
        return "admin/types-input";
    }
}
