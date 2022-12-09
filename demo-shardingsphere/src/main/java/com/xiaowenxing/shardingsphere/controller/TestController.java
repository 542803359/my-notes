package com.xiaowenxing.shardingsphere.controller;

import com.xiaowenxing.shardingsphere.domin.ShardUser;
import com.xiaowenxing.shardingsphere.domin.SimpleData;
import com.xiaowenxing.shardingsphere.service.ShardUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 测试控制器
 * <p>
 * 该控制器模仿日常开发,有些表需要分表处理,有些正常操作
 *
 * @author xiaowx
 * @date 2022/12/07 18:08:16
 */
@RestController
@RequestMapping("/shard/test")
@Slf4j
public class TestController {

    @Resource
    private ShardUserService shardUserService;

    /**
     * ShardUser 进行了分表处理,此处为一个库里面的分表. 分表策略见配置文件
     */

    @GetMapping("/getShardUser")
    public List<ShardUser> getShardUser(@RequestParam(required = false) Long id) {
        return shardUserService.getShardUser(id);
    }

    @PostMapping("/saveShardUser")
    public void saveShardUser(@RequestBody ShardUser shardUser) {
        shardUserService.saveShardUser(shardUser);
    }


    @PostMapping("/updateShardUser")
    public void updateShardUser(@RequestBody ShardUser shardUser) {
        shardUserService.updateShardUser(shardUser);
    }


    /**
     * 简单表处理,不进行分表操作
     */

    @GetMapping("/getSimpleData")
    public List<SimpleData> getSimpleData(@RequestParam(required = false) Long id) {
        return shardUserService.getSimpleData(id);
    }

    @PostMapping("/saveSimpleData")
    public void saveSimpleData() {
        shardUserService.saveSimpleData();
    }
}
