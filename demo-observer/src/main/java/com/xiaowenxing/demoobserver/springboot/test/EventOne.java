package com.xiaowenxing.demoobserver.springboot.test;

import org.springframework.context.ApplicationEvent;

/**
 * 测试
 *
 * @author XWX
 * @date 2021/6/7 16:38
 * @since 3.6
 **/
public class EventOne extends ApplicationEvent {
    public EventOne(Object source) {
        super(source);
    }
}
