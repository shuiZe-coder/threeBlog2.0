package org.shuize.blogmanage.blog.service;

import org.shuize.blogtypemanage.type.pojo.TType;
import org.shuize.commonapi.RespUtil;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/*
远程调用 type-manage模块获取博客所有分类信息
 */
@Service
@FeignClient("BLOG-TYPE-MANAGE-SERVICE-PROVIDER")
public interface TypeRemoteCallerService {

    @GetMapping("/type/all")
    public List<TType> getAllType();

    @GetMapping("/type")
    public RespUtil getAllBlogType();

    @GetMapping("/type/{current}/{limit}")
    public RespUtil getLimitBlogType(@PathVariable long current, @PathVariable long limit);

    @GetMapping("/type/{id}")
    public RespUtil getTypeById(@PathVariable("id") long id);



}
