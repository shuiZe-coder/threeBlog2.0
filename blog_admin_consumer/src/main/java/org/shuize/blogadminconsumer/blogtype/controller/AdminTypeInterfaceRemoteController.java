package org.shuize.blogadminconsumer.blogtype.controller;

import org.shuize.blogadminconsumer.blogtype.service.BlogTypeService;
import org.shuize.blogtypemanage.type.pojo.TType;
import org.shuize.commonapi.RespUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AdminTypeInterfaceRemoteController {

    @Autowired
    private BlogTypeService blogTypeService;

    @GetMapping("/type")
    public RespUtil getAllBlogType(){
        return blogTypeService.getAllBlogType();
    }

    @GetMapping("/type/{current}/{limit}")
    public RespUtil getLimitBlogType(@PathVariable("current") long current, @PathVariable("limit") long limit){
        return blogTypeService.getLimitBlogType(current, limit);
    };

    @GetMapping("/type/{id}")
    public RespUtil getTypeById(@PathVariable("id") long id){
        return blogTypeService.getTypeById(id);
    };

    @GetMapping("/type/all")
    public List<TType> all(){
        return blogTypeService.all();
    };

    @PostMapping("/type")
    public RespUtil addBlogType(@RequestBody TType type){
        return blogTypeService.addBlogType(type);
    };

    @PutMapping("/type")
    public RespUtil updateBlogType(@RequestBody TType type){
        return blogTypeService.updateBlogType(type);
    };

    @DeleteMapping("/type/{id}")
    public RespUtil deleteBlogTypeById(@PathVariable("id") Long id){
        return blogTypeService.deleteBlogTypeById(id);
    }
}