package org.shuize.blogadminconsumer.blog.controller;

import io.swagger.models.auth.In;
import org.shuize.blogadminconsumer.blog.service.BlogService;
import org.shuize.blogmanage.blog.pojo.TBlog;
import org.shuize.blogmanage.blog.pojo.vo.BlogInfoVo;
import org.shuize.commonapi.RespUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BlogRemoteController {

    @Autowired
    private BlogService blogService;

    @GetMapping("/blog/count")
    public RespUtil getBlogCountByType(){
        return blogService.getBlogCountByType();
    };

    @GetMapping("/blog/all")
    public RespUtil all(){
        return blogService.all();
    };

    @GetMapping("/blog/{current}/{limit}")
    public RespUtil blogByPage(@PathVariable("current") long current, @PathVariable("limit") long limit){
        return blogService.blogByPage(current, limit);
    }

    @PostMapping("/blog/{current}/{limit}")
    public RespUtil selectByInfo(@PathVariable("current") long current, @PathVariable("limit") long limit,
                                 @RequestBody(required = false) BlogInfoVo blogInfoVo){
        return blogService.selectByInfo(current, limit, blogInfoVo);
    }

    @DeleteMapping("/blog/{id}")
    public RespUtil delBlog(@PathVariable("id") Long id){
        return blogService.delBlog(id);
    };

    @GetMapping("/blog/{id}")
    public RespUtil getBlog(@PathVariable("id") Long id){
        return blogService.getBlog(id);
    };

    @PostMapping("/blog")
    public RespUtil addBlog(@RequestBody TBlog blog){
        return blogService.addBlog(blog);
    };

    @PutMapping("/blog")
    public RespUtil updateBlog(@RequestBody TBlog blog){
        return blogService.updateBlog(blog);
    };

    @GetMapping("/blog/latestRecommended/{current}/{limit}")
    public RespUtil lastestRecommended(
            @PathVariable("current") Long current,
            @PathVariable("limit") Long limit,
            @RequestParam(value = "isRecommend", required = false) Integer isRecommend){
        return blogService.getLastestRecommended(current, limit, isRecommend);
    }

    @GetMapping("/blog/detail/{id}")
    public RespUtil getBlogDetailById(@PathVariable("id") Long id){
        return blogService.getBlogDetailById(id);
    };


}
