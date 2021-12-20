package com.xiaowenxing.demoobserver.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author XWX
 * @date 2021/6/7 16:09
 * @since 3.6
 **/
@RestController
@RequestMapping("/event")
public class Client {

    @Autowired
    private ApplicationContext applicationContext;


    @GetMapping("/test")
    public void doSomething(){
        applicationContext.publishEvent(new UserUpdateEvent(this, "张三"));
        System.out.println(123);
    }
}
