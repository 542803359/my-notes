package com.xiaowenxing.demoobserver.springboot.test;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * @author XWX
 * @date 2021/6/7 16:42
 * @since 3.6
 **/
@Component
public class TestEventListener {


    @EventListener(classes = {
            EventOne.class,
            EventTwo.class
    })
    public void test() {
        System.out.println("监听到了");
    }
}
