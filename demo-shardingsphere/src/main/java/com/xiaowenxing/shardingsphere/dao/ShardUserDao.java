package com.xiaowenxing.shardingsphere.dao;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiaowenxing.shardingsphere.domin.ShardUser;
import com.xiaowenxing.shardingsphere.dao.mapper.ShardUserMapper;
import org.springframework.stereotype.Component;


/**
 * 用户 数据库连接层
 *
 * @author xiaowx
 * @date 2022/12/07 17:24:08
 */
@Component
public class ShardUserDao extends ServiceImpl<ShardUserMapper, ShardUser> {
}
