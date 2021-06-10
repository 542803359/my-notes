package com.xiaowenxing.demoproxy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
//开启Aop注解
@EnableAspectJAutoProxy(proxyTargetClass = true)
@ComponentScan("com.xiaowenxing.demoproxy.**")
public class DemoProxyApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoProxyApplication.class, args);
	}

}
