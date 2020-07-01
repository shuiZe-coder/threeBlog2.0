package org.shuize.blogadminconsumer.picture.controller;

import org.shuize.blogadminconsumer.picture.service.PictureService;
import org.shuize.commonapi.RespUtil;
import org.shuize.picturemanage.picture.pojo.TPicture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class PictureRemoteController {

    @Autowired
    private PictureService pictureService;

    @PostMapping("/picture/upload")
    public RespUtil uploda(@RequestPart(value = "images", required = false) MultipartFile[] files){
        return pictureService.upload(files);
    }
}
