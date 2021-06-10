package com.xiaowenxing.demoproxy.aspect;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author XWX
 * @date 2021/6/9 16:36
 * @since 3.6
 **/
@RestController
@RequestMapping("/eat")
public class EatController {

    @GetMapping("/test")
    public void test() {
        System.out.println("开始吃饭");
    }


    @GetMapping("/drinkWater")
    public void drinkWater() {
        System.out.println("直接喝水");
    }


    @AccessLimit(
            className = "com.xiaowenxing.demoproxy.aspect.ParamUtil",
            methodName = "getParam")
    @GetMapping("/getVcode")
    public void getVcode(@RequestParam String mobile) throws InterruptedException {

        Thread.sleep(3000);
        System.out.println("获取验证码: " + mobile);
    }

}
