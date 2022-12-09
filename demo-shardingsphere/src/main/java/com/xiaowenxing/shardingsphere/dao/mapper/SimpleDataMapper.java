package com.xiaowenxing.shardingsphere.dao.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import com.xiaowenxing.shardingsphere.domin.SimpleData;
import org.apache.ibatis.annotations.Mapper;


/**
 * 简单表 映射器
 *
 * @author xiaowx
 * @date 2022/12/07 17:22:17
 */
@Mapper
public interface SimpleDataMapper extends BaseMapper<SimpleData> {
}
