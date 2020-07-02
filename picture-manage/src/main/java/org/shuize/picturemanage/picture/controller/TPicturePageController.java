package org.shuize.picturemanage.picture.controller;

import org.shuize.commonapi.RespUtil;
import org.shuize.picturemanage.picture.service.TPictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
@RequestMapping("/admin/picture")
public class TPicturePageController {

    @Autowired
    private TPictureService pictureService;

    @GetMapping("/manage")
    public String manage(){
        return "admin/pictures";
    }

    @GetMapping("/add")
    public String add(){
        return "admin/pictures-input";
    }


}
