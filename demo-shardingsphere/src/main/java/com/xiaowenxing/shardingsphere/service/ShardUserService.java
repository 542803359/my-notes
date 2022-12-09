package com.xiaowenxing.shardingsphere.service;

import com.xiaowenxing.shardingsphere.domin.ShardUser;
import com.xiaowenxing.shardingsphere.domin.SimpleData;

import java.util.List;

public interface ShardUserService {

    List<ShardUser> getShardUser(Long id);

    void saveShardUser(ShardUser shardUser);

    void updateShardUser(ShardUser shardUser);

    List<SimpleData> getSimpleData(Long id);

    void saveSimpleData();


}
