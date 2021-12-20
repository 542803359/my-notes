package com.xiaowenxing.demoobserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class DemoObserverApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoObserverApplication.class, args);
	}

}
