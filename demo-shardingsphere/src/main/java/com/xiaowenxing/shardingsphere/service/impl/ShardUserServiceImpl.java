package com.xiaowenxing.shardingsphere.service.impl;

import cn.hutool.core.util.RandomUtil;
import com.xiaowenxing.shardingsphere.dao.ShardUserDao;
import com.xiaowenxing.shardingsphere.dao.SimpleDataDao;
import com.xiaowenxing.shardingsphere.domin.ShardUser;
import com.xiaowenxing.shardingsphere.domin.SimpleData;
import com.xiaowenxing.shardingsphere.service.ShardUserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@AllArgsConstructor
public class ShardUserServiceImpl implements ShardUserService {


    private final ShardUserDao shardUserDao;
    private final SimpleDataDao simpleDataDao;


    @Override
    public List<ShardUser> getShardUser(Long id) {
        if (Objects.nonNull(id)) {
            List<ShardUser> list = new ArrayList<>();
            ShardUser byId = shardUserDao.getById(id);
            list.add(byId);
            return list;
        }
        return shardUserDao.list();
    }

    @Override
    public void saveShardUser(ShardUser shardUser) {
        shardUserDao.save(shardUser);
    }

    @Override
    public void updateShardUser(ShardUser shardUser) {
        ShardUser byId = shardUserDao.getById(shardUser.getId());
        byId.setUserName(shardUser.getUserName());
        byId.setPwd(shardUser.getPwd());
        shardUserDao.updateById(byId);
    }

    @Override
    public List<SimpleData> getSimpleData(Long id) {
        if (Objects.nonNull(id)) {
            List<SimpleData> list = new ArrayList<>();
            SimpleData byId = simpleDataDao.getById(id);
            list.add(byId);
            return list;
        }
        return simpleDataDao.list();
    }

    @Override
    public void saveSimpleData() {
        SimpleData simpleData = new SimpleData();
        simpleData.setUserId(RandomUtil.randomLong(100000,999999));
        simpleDataDao.save(simpleData);
    }
}
