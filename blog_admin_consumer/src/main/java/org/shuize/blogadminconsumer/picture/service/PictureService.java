package org.shuize.blogadminconsumer.picture.service;

import feign.form.spring.SpringFormEncoder;
import org.shuize.blogadminconsumer.config.feign.FeignConfig;
import org.shuize.commonapi.RespUtil;
import org.shuize.picturemanage.picture.pojo.TPicture;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

//@Service
@FeignClient(value = "BLOG-PICTURE-MANAGE-SERVICE-PROVIDER", configuration = FeignConfig.class)
public interface PictureService {

    @PostMapping(value = "/picture/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public RespUtil upload(@RequestPart(value = "images") MultipartFile[] files);
}