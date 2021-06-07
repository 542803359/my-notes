package com.example.demostrategy.strategy.context;

import com.example.demostrategy.strategy.UserLogin;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 第二种实现:通过spring自动注入,根据方法名取对应的实体类
 *
 * @author XWX
 * @date 2021/5/14 16:53
 * @since 3.2
 **/
@Service
public class StrategyContext {

    private final Map<String, UserLogin> strategyMap = new ConcurrentHashMap<>();

    public StrategyContext(Map<String, UserLogin> strategyMap) {
        this.strategyMap.clear();
        strategyMap.forEach(this.strategyMap::put);
    }

    public void login(String memberLevel) {
        strategyMap.get(memberLevel).login();
    }
}
