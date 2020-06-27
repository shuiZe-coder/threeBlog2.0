package org.shuize.blogmanage.user.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.shuize.blogmanage.user.mapper.TUserMapper;
import org.shuize.blogmanage.user.pojo.TUser;
import org.shuize.blogmanage.user.service.TUserService;
import org.shuize.commonapi.MD5Util;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author shuize
 * @since 2020-06-17
 */
@Service
public class TUserServiceImpl extends ServiceImpl<TUserMapper, TUser> implements TUserService {
    @Override
    public boolean verifyUser(TUser user) {
        QueryWrapper<TUser> wrapper = new QueryWrapper<>();
        wrapper.eq("username", user.getUsername());
        wrapper.eq("password", MD5Util.encrypt(user.getPassword()));
        TUser one = this.getOne(wrapper);
        if (one != null){
            return true;
        }
        return false;
    }
}
