package com.xiaowenxing.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author XWX
 * @date 2021/4/30 14:03
 * @since 3.2
 **/
@RestController
@RequestMapping("/test")
public class DockerTestController {

    @GetMapping("/helloDocker")
    public String helloDocker() {
        return "hello docker";
    }

}
