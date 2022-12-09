package com.xiaowenxing.shardingsphere;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.xiaowenxing.shardingsphere.dao.**")
public class DemoShardingsphereApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoShardingsphereApplication.class, args);
    }

}
