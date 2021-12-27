package com.xiaowenxing.demoobserver.springboot.aware;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @author xiaowx
 * @date 2021/12/27 15:07
 **/
@Component
public class TestSender implements ApplicationContextAware {

    private volatile ApplicationContext ctx;

    @Override
    public void setApplicationContext(ApplicationContext ctx) {
        this.ctx = ctx;
    }

    public void awareTestSend(String result) {
        TestAwareEvent testAwareEvent = new TestAwareEvent(ctx, result);
        ctx.publishEvent(testAwareEvent);
    }
}
