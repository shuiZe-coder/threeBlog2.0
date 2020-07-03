package org.shuize.blogmanage.blog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.swagger.models.auth.In;
import javassist.NotFoundException;
import org.commonmark.node.Link;
import org.shuize.blogmanage.blog.mapper.TBlogMapper;
import org.shuize.blogmanage.blog.pojo.TBlog;
import org.shuize.blogmanage.blog.pojo.vo.*;
import org.shuize.blogmanage.blog.service.TBlogService;
import org.shuize.blogmanage.blog.service.TypeRemoteCallerService;
import org.shuize.blogmanage.util.MarkdownUtils;
import org.shuize.blogtypemanage.type.pojo.TType;
import org.shuize.blogtypemanage.type.service.TTypeService;
import org.shuize.commonapi.RespUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;


import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.LinkedHashMap;
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

    @Override
    public List<BlogAndType> getLastestRecommended(Long current, Long limit, Integer isRecommend) {
        Page<TBlog> page = new Page<>(current, limit);
        QueryWrapper<TBlog> queryWrapper = new QueryWrapper<TBlog>();
        queryWrapper.orderByDesc("update_time");
        if (isRecommend == 1) {
            queryWrapper.eq("recommend", 1);
        }
        queryWrapper.eq("published", 1);
        List<BlogAndType> result = new ArrayList<>();
        this.page(page, queryWrapper);
        for (TBlog blog: page.getRecords()){
            BlogAndType blogAndType = new BlogAndType();
            BeanUtils.copyProperties(blog, blogAndType);
            LinkedHashMap<Object, String> data = (LinkedHashMap<Object, String>)typeRemoteCallerService.getTypeById(blog.getTypeId()).getData().get("data");
            String typeName = data.get("name");
            blogAndType.setTypeName(typeName);
            result.add(blogAndType);
        }
        return result;
    }

    @Override
    public List<TypeAndBlogCount> getBlogCountByType() {
        List<TType> allType = typeRemoteCallerService.getAllType();
        List<TypeAndBlogCount> result = new ArrayList<>();
        for (TType type : allType){
            long size = this.selectByInfo(new BlogInfoVo(null, type.getId()), 1, Integer.MAX_VALUE).getRecords().size();
            result.add(new TypeAndBlogCount(type.getId(), type.getName(), size));
        }
        return result;
    }

    @Override
    public BlogDetail getBlogDetailById(Long id) throws NotFoundException {
        TBlog byId = this.getById(id);
        BlogDetail result = new BlogDetail();
        if (result == null){
            throw new NotFoundException("该博客不存在");
        }
        BeanUtils.copyProperties(byId, result);
        String typeName = (String)typeRemoteCallerService.getTypeById(byId.getTypeId()).getData().get("name");
        String content = result.getContent();
        result.setContent(MarkdownUtils.markdownToHtmlExtensions(content));
        result.setTypeName(typeName);
        return result;
    }


}
