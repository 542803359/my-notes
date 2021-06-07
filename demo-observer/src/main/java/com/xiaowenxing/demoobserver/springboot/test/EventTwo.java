package com.xiaowenxing.demoobserver.springboot.test;

import org.springframework.context.ApplicationEvent;

/**
 * ces
 *
 * @author XWX
 * @date 2021/6/7 16:39
 * @since 3.6
 **/
public class EventTwo extends ApplicationEvent {
    public EventTwo(Object source) {
        super(source);
    }
}
