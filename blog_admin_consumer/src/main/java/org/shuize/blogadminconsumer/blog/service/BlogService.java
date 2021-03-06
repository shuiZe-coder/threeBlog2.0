package org.shuize.blogadminconsumer.blog.service;


import org.shuize.blogmanage.blog.pojo.TBlog;
import org.shuize.blogmanage.blog.pojo.vo.BlogInfoVo;
import org.shuize.commonapi.RespUtil;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@Service
@FeignClient("BLOG-MANAGE-SERVICE-PROVIDER")
public interface BlogService {

    @GetMapping("/blog/count")
    public RespUtil getBlogCountByType();

    @GetMapping("/blog/all")
    public RespUtil all();

    @GetMapping("/blog/{current}/{limit}")
    public RespUtil blogByPage(@PathVariable("current") long current, @PathVariable("limit") long limit);

    @RequestMapping(value = "/blog/{current}/{limit}", method = RequestMethod.POST)
    public RespUtil selectByInfo(@PathVariable("current") long current, @PathVariable("limit") long limit,
                                 @RequestBody BlogInfoVo blogInfoVo);

    @DeleteMapping(value = "/blog/{id}")
    public RespUtil delBlog(@PathVariable("id") Long id);

    @GetMapping("/blog/{id}")
    public RespUtil getBlog(@PathVariable("id") Long id);

    @PostMapping("/blog")
    public RespUtil addBlog(@RequestBody TBlog blog);

    @PutMapping("/blog")
    public RespUtil updateBlog(@RequestBody TBlog blog);

    @GetMapping("/blog/latestRecommended/{current}/{limit}")
    public RespUtil getLastestRecommended(
            @PathVariable("current") Long current,
            @PathVariable("limit") Long limit,
            @RequestParam(value = "isRecommend", required = false) Integer isRecommend);

    @GetMapping("/blog/detail/{id}")
    public RespUtil getBlogDetailById(@PathVariable("id") Long id);


}
