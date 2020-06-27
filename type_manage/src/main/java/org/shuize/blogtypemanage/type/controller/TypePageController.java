package org.shuize.blogtypemanage.type.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/type")
public class TypePageController {

    @GetMapping
    public String showTypePage(){
        return "admin/types";
    }

    @GetMapping("/add")
    public String showTypeInputPage(){
        return "admin/types-input";
    }
}
