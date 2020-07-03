package org.three.ourblog.login.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.shuize.commonapi.RespUtil;
import org.three.ourblog.login.pojo.TUser;
import org.three.ourblog.login.mapper.TUserMapper;
import org.three.ourblog.login.service.TUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author shuize
 * @since 2020-07-03
 */
@Service
public class TUserServiceImpl extends ServiceImpl<TUserMapper, TUser> implements TUserService {

    @Override
    public boolean verify(TUser user) {
        QueryWrapper<TUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", user.getUsername());
        queryWrapper.eq("password", user.getPassword());
        TUser res = this.getOne(queryWrapper);
        if (res != null){
            return true;
        }
        return false;
    }
}
