package org.shuize.blogtypemanage.type.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.shuize.blogtypemanage.type.mapper.TTypeMapper;
import org.shuize.blogtypemanage.type.pojo.TType;
import org.shuize.blogtypemanage.type.service.TTypeService;
import org.springframework.stereotype.Service;

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
public class TTypeServiceImpl extends ServiceImpl<TTypeMapper, TType> implements TTypeService {
    @Override
    public List<TType> getByLimit(long current, long limit) {
        Page<TType> page = new Page<>(current, limit);
        this.page(page);
        return page.getRecords();
    }
}
