package com.xiaowenxing.demoobserver.springboot.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author XWX
 * @date 2021/6/7 16:41
 * @since 3.6
 **/
@RestController
@RequestMapping("/test/event")
public class TestClient {


    @Autowired
    private ApplicationContext applicationContext;


    @GetMapping("/test1")
    public void doSomething(){
        applicationContext.publishEvent(new EventOne(this));
    }

    @GetMapping("/test2")
    public void doSomething2(){
        applicationContext.publishEvent(new EventTwo(this));
    }
}
