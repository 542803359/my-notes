package com.xiaowenxing.demoproxy.aspect;

import com.xiaowenxing.demoproxy.annotation.AccessLimit;
import com.xiaowenxing.demoproxy.domin.UserVO;
import com.xiaowenxing.demoproxy.proxy.service.Work;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

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


    /**
     * 需求:
     * 获取传入参数的值,进行处理
     *
     * @param mobile: 电话号码
     * @throws InterruptedException
     */
    @AccessLimit(
            className = "com.xiaowenxing.demoproxy.aspect.ParamUtil",
            methodName = "getParam")
    @GetMapping("/getVcode")
    public void getVcode(@RequestParam String mobile) throws InterruptedException {

        Thread.sleep(3000);
        System.out.println("获取验证码: " + mobile);
    }


    /**
     * 需求;
     * 拦截加了ParamHandle注解的方法,对方法返回类中加了ParamMark字段进行处理
     */
    @Resource
    private Work work;

    @GetMapping("/work")
    public UserVO work() {
        return work.doWork();
    }

}
