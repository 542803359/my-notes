package com.xiaowenxing.demoobserver.springboot;

import com.xiaowenxing.demoobserver.springboot.aware.TestSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

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
    public void doSomething() {
        applicationContext.publishEvent(new UserUpdateEvent(this, "张三"));
        System.out.println(123);
    }


    @Resource
    private TestSender testSender;

    @GetMapping("/testAware")
    public void testAware() {
        testSender.awareTestSend("hello word");
        System.out.println("123456");
    }

}
