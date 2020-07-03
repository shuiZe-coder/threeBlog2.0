package org.three.ourblog.login.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.three.ourblog.login.pojo.TUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author shuize
 * @since 2020-07-03
 */
@Mapper
public interface TUserMapper extends BaseMapper<TUser> {

}
