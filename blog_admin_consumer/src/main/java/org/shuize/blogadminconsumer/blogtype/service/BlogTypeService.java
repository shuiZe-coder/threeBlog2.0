package org.shuize.blogadminconsumer.blogtype.service;

import org.shuize.blogtypemanage.type.pojo.TType;
import org.shuize.commonapi.RespUtil;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient("BLOG-TYPE-MANAGE-SERVICE-PROVIDER")
public interface BlogTypeService {

    @GetMapping("/type")
    public RespUtil getAllBlogType();

    @GetMapping("/type/{current}/{limit}")
    public RespUtil getLimitBlogType(@PathVariable("current") long current, @PathVariable("limit") long limit);

    @GetMapping("/type/{id}")
    public RespUtil getTypeById(@PathVariable("id") long id);

    @GetMapping("/type/all")
    public List<TType> all();

    @PostMapping("/type")
    public RespUtil addBlogType(@RequestBody TType type);

    @PutMapping("/type")
    public RespUtil updateBlogType(@RequestBody TType type);

    @DeleteMapping("/type/{id}")
    RespUtil deleteBlogTypeById(@PathVariable("id") Long id);


}