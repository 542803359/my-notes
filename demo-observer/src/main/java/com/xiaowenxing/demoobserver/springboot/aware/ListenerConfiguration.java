package com.xiaowenxing.demoobserver.springboot.aware;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.SimpleApplicationEventMulticaster;

import java.util.concurrent.Executor;

/**
 * 监听器配置
 *
 * @author lingyuwang
 * @date 2020-01-14 10:50
 * @since 1.0.4
 */
@Configuration
@Slf4j
public class ListenerConfiguration {

    /**
     * 覆盖默认事件广播器，复用 @EnableAsync 的任务线程池
     * @param taskExecutor
     * @return
     */
    @Bean
    public SimpleApplicationEventMulticaster applicationEventMulticaster(Executor taskExecutor) {
        SimpleApplicationEventMulticaster applicationEventMulticaster = new SimpleApplicationEventMulticaster();
        applicationEventMulticaster.setTaskExecutor(taskExecutor);
        return applicationEventMulticaster;
    }

}
