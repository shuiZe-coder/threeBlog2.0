package org.shuize.blogadminconsumer.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BlogPrePageController {
    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("/about")
    public String about(){
        return "about";
    }

    @GetMapping("/archives")
    public String archives(){
        return "archives";
    }

    @GetMapping("/bg/{id}")
    public String bg(){
        return "blog";
    }

    @GetMapping("/message")
    public String message(){
        return "message";
    }

    @GetMapping("/music")
    public String music(){
        return "music";
    }

    @GetMapping("/picture")
    public String picture(){
        return "picture";
    }

    @GetMapping("/search")
    public String search(){
        return "search";
    }

    @GetMapping("/types")
    public String type(){
        return "types";
    }


}
