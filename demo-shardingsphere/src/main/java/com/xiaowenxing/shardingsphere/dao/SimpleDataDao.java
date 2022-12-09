package com.xiaowenxing.shardingsphere.dao;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiaowenxing.shardingsphere.dao.mapper.SimpleDataMapper;
import com.xiaowenxing.shardingsphere.domin.SimpleData;
import org.springframework.stereotype.Component;


/**
 * 简单表 数据库连接层
 *
 * @author xiaowx
 * @date 2022/12/07 17:24:08
 */
@Component
public class SimpleDataDao extends ServiceImpl<SimpleDataMapper, SimpleData> {
}
