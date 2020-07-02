package org.shuize.blogadminconsumer.picture.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/picture")
public class PicturePageController {

    @GetMapping("/manage")
    public String manage(){
        return "admin/pictures";
    }

    @GetMapping("/add")
    public String add(){
        return "admin/pictures-input";
    }

}
