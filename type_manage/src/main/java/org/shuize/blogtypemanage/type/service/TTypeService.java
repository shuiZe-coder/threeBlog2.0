package org.shuize.blogtypemanage.type.service;


import com.baomidou.mybatisplus.extension.service.IService;
import org.shuize.blogtypemanage.type.pojo.TType;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author shuize
 * @since 2020-06-18
 */
public interface TTypeService extends IService<TType> {

    List<TType> getByLimit(long current, long limit);
}
