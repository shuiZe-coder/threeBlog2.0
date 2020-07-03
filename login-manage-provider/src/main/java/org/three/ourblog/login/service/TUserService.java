package org.three.ourblog.login.service;

import org.shuize.commonapi.RespUtil;
import org.three.ourblog.login.pojo.TUser;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author shuize
 * @since 2020-07-03
 */
public interface TUserService extends IService<TUser> {

    boolean verify(TUser user);
}
