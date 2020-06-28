package org.shuize.blogmanage.blog.controller;

import com.netflix.discovery.converters.Auto;
import org.shuize.blogmanage.blog.service.TypeRemoteCallerService;
import org.shuize.blogtypemanage.type.pojo.TType;
import org.shuize.commonapi.RespUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TTypeController {

    @Autowired
    private TypeRemoteCallerService typeRemoteCallerService;

    @GetMapping("/type/all")
    public List<TType> getAllType(){
        return typeRemoteCallerService.getAllType();
    };

    @GetMapping("/type")
    public RespUtil getAllBlogType(){
        return typeRemoteCallerService.getAllBlogType();
    };

    @GetMapping("/type/{current}/{limit}")
    public RespUtil getLimitBlogType(@PathVariable("current") long current, @PathVariable("limit") long limit){
        return typeRemoteCallerService.getLimitBlogType(current, limit);
    };

    @GetMapping("/type/{id}")
    public RespUtil getTypeById(@PathVariable("id") long id){
        return typeRemoteCallerService.getTypeById(id);
    };
}
