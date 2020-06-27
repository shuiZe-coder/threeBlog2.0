package org.shuize.blogmanage.user.service;


import com.baomidou.mybatisplus.extension.service.IService;
import org.shuize.blogmanage.user.pojo.TUser;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author shuize
 * @since 2020-06-17
 */
public interface TUserService extends IService<TUser> {

    boolean verifyUser(TUser user);
}
