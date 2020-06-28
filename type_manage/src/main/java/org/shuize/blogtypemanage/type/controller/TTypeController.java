package org.shuize.blogtypemanage.type.controller;


import org.shuize.blogtypemanage.type.pojo.TType;
import org.shuize.blogtypemanage.type.service.TTypeService;
import org.shuize.commonapi.RespUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author shuize
 * @since 2020-06-18
 */
@RestController
@RequestMapping("/type")
public class TTypeController {

    @Autowired
    private TTypeService typeService;

    @GetMapping
    public RespUtil getAllBlogType(){
//        System.out.println("远程调用");
        List<TType> types = typeService.list(null);
        return RespUtil.ok().data("data", types);
    }

    @GetMapping("/{current}/{limit}")
    public RespUtil getLimitBlogType(@PathVariable("current") long current, @PathVariable("limit") long limit){
        List<TType> types = typeService.getByLimit(current, limit);
        return RespUtil.ok().data("data", types);
    }

    @GetMapping("/{id}")
    public RespUtil getTypeById(@PathVariable("id") long id){
        TType byId = typeService.getById(id);
        return RespUtil.ok().data("data", byId);
    }

    @GetMapping("/all")
    public List<TType> all(){
        return typeService.list();
    }

    @PostMapping
    public RespUtil addBlogType(@RequestBody TType type){
        boolean save = typeService.save(type);
        if (save){
            return RespUtil.ok().data("data", "博客类型添加成功");
        }else{
            return RespUtil.error().data("data", "博客类型添加失败");
        }
    }

    @PutMapping
    public RespUtil updateBlogType(@RequestBody TType type){
        boolean save = typeService.updateById(type);
        if (save){
            return RespUtil.ok().data("data", "博客类型修改成功");
        }else{
            return RespUtil.error().data("data", "博客类型修改失败");
        }
    }
}

