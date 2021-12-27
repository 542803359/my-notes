package com.xiaowenxing.demoobserver.springboot.aware;

import lombok.Getter;
import lombok.ToString;
import org.springframework.context.ApplicationContext;
import org.springframework.context.event.ApplicationContextEvent;

/**
 * @author xiaowx
 * @date 2021/12/27 15:10
 **/
@Getter
@ToString
public class TestAwareEvent extends ApplicationContextEvent {

    private String result;

    public TestAwareEvent(ApplicationContext source, String result) {
        super(source);
        this.result = result;
    }
}
