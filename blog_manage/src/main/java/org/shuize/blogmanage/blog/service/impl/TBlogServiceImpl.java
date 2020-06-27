package org.shuize.blogmanage.blog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.shuize.blogmanage.blog.mapper.TBlogMapper;
import org.shuize.blogmanage.blog.pojo.TBlog;
import org.shuize.blogmanage.blog.pojo.vo.BlogDescription;
import org.shuize.blogmanage.blog.pojo.vo.BlogInfoVo;
import org.shuize.blogmanage.blog.service.TBlogService;
import org.shuize.blogmanage.blog.service.TypeRemoteCallerService;
import org.shuize.blogtypemanage.type.pojo.TType;
import org.shuize.blogtypemanage.type.service.TTypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;


import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author shuize
 * @since 2020-06-18
 */

@Service
public class TBlogServiceImpl extends ServiceImpl<TBlogMapper, TBlog> implements TBlogService {

    @Autowired
    private TypeRemoteCallerService typeRemoteCallerService;

    @Override
    public Page selectByInfo(BlogInfoVo blogInfoVo, long current, long limit) {
        Page<TBlog> page = new Page<>(current, limit);
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.orderByDesc("update_time");
        if (!StringUtils.isEmpty(blogInfoVo.getTitle())){
            wrapper.like("title", blogInfoVo.getTitle());
        }
        if (blogInfoVo.getTypeId() != null){
            wrapper.eq("type_id", blogInfoVo.getTypeId());
        }
        this.page(page, wrapper);
        return page;
    }

    @Override
    public List<BlogDescription> selBlogDescription(List<TBlog> blogs) {
        if (blogs == null) {
            blogs = this.list(null);
        }
        List<BlogDescription> res = new ArrayList<BlogDescription>();
        List<TType> types = typeRemoteCallerService.getAllType();
        for (TBlog blog: blogs){
            BlogDescription bd = new BlogDescription();
            BeanUtils.copyProperties(blog, bd);
            for (TType blogType: types){
                if (blog.getTypeId() == blogType.getId()){
                    bd.setType(blogType.getName());
                    break;
                }
            }
            res.add(bd);
        }
        return res;
    }


}
