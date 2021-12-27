package com.xiaowenxing.demoobserver.springboot.aware;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * @author xiaowx
 * @date 2021/12/27 15:12
 **/
@Component
public class TestAwareListener {

    @EventListener
    public void awareListener(TestAwareEvent awareEvent){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String result = awareEvent.getResult();
        System.out.println(result);
        System.out.println(Thread.currentThread());
    }
}
