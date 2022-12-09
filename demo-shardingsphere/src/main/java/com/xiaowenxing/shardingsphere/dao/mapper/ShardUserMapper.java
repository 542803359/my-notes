package com.xiaowenxing.shardingsphere.dao.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xiaowenxing.shardingsphere.domin.ShardUser;
import org.apache.ibatis.annotations.Mapper;


/**
 * 用户映射器
 *
 * @author xiaowx
 * @date 2022/12/07 17:22:17
 */
@Mapper
public interface ShardUserMapper extends BaseMapper<ShardUser> {
}
