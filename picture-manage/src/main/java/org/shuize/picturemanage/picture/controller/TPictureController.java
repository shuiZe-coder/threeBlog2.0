package org.shuize.picturemanage.picture.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.shuize.commonapi.RespUtil;
import org.shuize.picturemanage.picture.pojo.TPicture;
import org.shuize.picturemanage.picture.service.TPictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author shuize
 * @since 2020-06-28
 */
@RestController

public class TPictureController {

    @Autowired
    private TPictureService pictureService;

    @PostMapping("/picture/upload")
//    @ResponseBody
    public RespUtil upload(@RequestPart(value = "images", required = false) MultipartFile[] files){
        if (files == null ||files.length==0){
            return RespUtil.error().data("data", "上传的文件为空或不存在");
        }else {
            List<String> path = pictureService.uploadFile(files);
            return RespUtil.ok().data("data", path);
        }
    }

    @GetMapping("/picture/{current}/{limit}")
    public RespUtil getPictureInfoByPage(@PathVariable("current") Long current, @PathVariable("limit") Long limit){
        Page<TPicture> tPicturePage = new Page<>(current, limit);
        pictureService.page(tPicturePage);
        return RespUtil.ok().data("data", tPicturePage.getRecords());
    }

    @DeleteMapping("/picture/{id}")
    public RespUtil deletePictureById(@PathVariable("id") Long id){
        boolean b = pictureService.removeById(id);
        if (b) {
            return RespUtil.ok().data("data", "删除图片成功");
        }else{
            return RespUtil.error().data("data", "删除图片失败");
        }
    }




}

