package com.xiaowenxing.demoemqx;

import com.xiaowenxing.demoemqx.config.MqttConfiguration;
import com.xiaowenxing.demoemqx.mqtt.MqttPushClient;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.Resource;

/**
 * emqx演示应用程序
 *
 * @author xiaowx
 * @date 2022/09/06 11:55:36
 */
@SpringBootApplication
public class DemoEmqxApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoEmqxApplication.class, args);
    }

}
