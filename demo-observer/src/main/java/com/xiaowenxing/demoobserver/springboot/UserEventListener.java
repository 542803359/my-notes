package com.xiaowenxing.demoobserver.springboot;

import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * 事件监听
 *
 * @author XWX
 * @date 2021/6/7 16:05
 * @since 3.6
 **/
@Component
public class UserEventListener {

    @Async
    @EventListener
    public void updateUser(UserUpdateEvent userUpdateEvent){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("名字变更为: "+userUpdateEvent.getUserName());
    }
}
