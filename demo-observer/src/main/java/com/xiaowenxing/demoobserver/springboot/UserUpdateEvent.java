package com.xiaowenxing.demoobserver.springboot;

import lombok.Getter;
import lombok.ToString;
import org.springframework.context.ApplicationEvent;

/**
 * 用户更新事件
 *
 * @author XWX
 * @date 2021/6/7 15:55
 * @since 3.6
 **/
@Getter
@ToString
public class UserUpdateEvent extends ApplicationEvent {

    private String userName;

    public UserUpdateEvent(Object source, String userName) {
        super(source);
        this.userName = userName;
    }
}
