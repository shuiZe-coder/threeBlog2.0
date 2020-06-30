package org.shuize.blogmanage.blog.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import javassist.NotFoundException;
import org.shuize.blogmanage.blog.pojo.TBlog;
import org.shuize.blogmanage.blog.pojo.vo.BlogAndType;
import org.shuize.blogmanage.blog.pojo.vo.BlogDescription;
import org.shuize.blogmanage.blog.pojo.vo.BlogDetail;
import org.shuize.blogmanage.blog.pojo.vo.BlogInfoVo;


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
}
