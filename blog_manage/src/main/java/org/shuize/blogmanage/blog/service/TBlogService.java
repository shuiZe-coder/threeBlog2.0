package org.shuize.blogmanage.blog.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import javassist.NotFoundException;
import org.shuize.blogmanage.blog.pojo.TBlog;
import org.shuize.blogmanage.blog.pojo.vo.*;
import org.shuize.commonapi.RespUtil;
import org.springframework.web.bind.annotation.GetMapping;


import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author shuize
 * @since 2020-06-18
 */
public interface TBlogService extends IService<TBlog> {

    Page selectByInfo(BlogInfoVo blogInfoVo, long current, long limit);

    List<BlogDescription> selBlogDescription(List<TBlog> blogs);


    List<BlogAndType> getLastestRecommended(Long current, Long limit, Integer isRecommend);

    BlogDetail getBlogDetailById(Long id) throws NotFoundException;


    List<TypeAndBlogCount> getBlogCountByType();
}
