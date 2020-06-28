package org.shuize.blogmanage.blog.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.shuize.blogmanage.blog.pojo.TBlog;
import org.shuize.blogmanage.blog.pojo.vo.BlogDescription;
import org.shuize.blogmanage.blog.pojo.vo.BlogInfoVo;
import org.shuize.blogmanage.blog.service.TBlogService;
import org.shuize.commonapi.RespUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
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
@RequestMapping("/blog")
public class TBlogController {
    @Autowired
    private TBlogService blogService;

    @GetMapping("/all")
    public RespUtil all(){
        List<BlogDescription> blogs = blogService.selBlogDescription(null);
        return RespUtil.ok().data("data", blogs);
    }

    @GetMapping("/{current}/{limit}")
    public RespUtil blogByPage(@PathVariable("current") long current, @PathVariable("limit") long limit){
        Page<TBlog> page = new Page<>(current, limit);
        QueryWrapper<TBlog> wrapper = new QueryWrapper<>();
        wrapper.orderByDesc("update_time");
        blogService.page(page, wrapper);
        List<BlogDescription> bds = blogService.selBlogDescription(page.getRecords());
        return RespUtil.ok().data("data", bds);
    }

    @PostMapping("/{current}/{limit}")
    public RespUtil selectByInfo(@PathVariable("current") long current, @PathVariable("limit") long limit,
                                 @RequestBody(required = false) BlogInfoVo blogInfoVo){
        Page page = blogService.selectByInfo(blogInfoVo, current, limit);
        List<TBlog> blogs = page.getRecords();
        List<BlogDescription> bds = blogService.selBlogDescription(blogs);
        return RespUtil.ok().data("data", bds).data("total", page.getTotal());
    }

    @DeleteMapping("/{id}")
    @Transactional
    public RespUtil delBlog(@PathVariable("id") Long id){
        boolean isTrue = blogService.removeById(id);
        if (isTrue){
            return RespUtil.ok().message("删除博客成功");
        }else{
            return RespUtil.error().message("删除博客失败");
        }
    }

    @GetMapping("/{id}")
    @Transactional
    public RespUtil getBlog(@PathVariable("id") Long id){
        TBlog blog = blogService.getById(id);
        if (blog != null){
            return RespUtil.ok().message("查询博客成功").data("data", blog);
        }else{
            return RespUtil.error().message("查询博客为空");
        }
    }

    @PostMapping
    @Transactional
    public RespUtil addBlog(@RequestBody TBlog blog){
        boolean save = blogService.save(blog);
        if (save){
            return RespUtil.ok().message("添加博客成功");
        }else{
            return RespUtil.error().message("添加博客失败");
        }
    }

    @PutMapping
    @Transactional
    public RespUtil updateBlog(@RequestBody TBlog blog){
        boolean update = blogService.updateById(blog);
        if (update){
            return RespUtil.ok().message("修改博客成功");
        }else{
            return RespUtil.error().message("修改博客失败");
        }
    }

    @PostMapping("/content")
    public RespUtil content(TBlog blog){
        return RespUtil.ok().data("data", blog);
    }
}

