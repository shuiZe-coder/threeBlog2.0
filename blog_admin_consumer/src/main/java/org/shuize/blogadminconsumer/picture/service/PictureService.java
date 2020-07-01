package org.shuize.blogadminconsumer.picture.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import feign.form.spring.SpringFormEncoder;
import org.shuize.blogadminconsumer.config.feign.FeignConfig;
import org.shuize.commonapi.RespUtil;
import org.shuize.picturemanage.picture.pojo.TPicture;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

//@Service
@FeignClient(value = "BLOG-PICTURE-MANAGE-SERVICE-PROVIDER", configuration = FeignConfig.class)
public interface PictureService {

    @PostMapping(value = "/picture/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public RespUtil upload(@RequestPart(value = "images") MultipartFile[] files);


    @GetMapping("/picture/{current}/{limit}")
    public RespUtil getPictureInfoByPage(@PathVariable("current") Long current, @PathVariable("limit") Long limit);

    @DeleteMapping("/picture/{id}")
    public RespUtil deletePictureById(@PathVariable("id") Long id);

}