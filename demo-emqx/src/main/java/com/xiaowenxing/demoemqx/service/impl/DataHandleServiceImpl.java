package com.xiaowenxing.demoemqx.service.impl;

import com.xiaowenxing.demoemqx.service.DataHandleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * 数据处理服务 实现类
 *
 * @author xiaowx
 * @date 2022/09/06 18:07:59
 */
@Service
@Slf4j
public class DataHandleServiceImpl implements DataHandleService {

    @Override
    public void saveToMysql(String msg) {
        log.info("存入MySQL: {}", msg);
    }

}
