package com.xiaowenxing.demotemplate;

import com.xiaowenxing.demotemplate.dto.ActivityDto;
import com.xiaowenxing.demotemplate.template.ActivityTemplate;
import com.xiaowenxing.demotemplate.template.MysteryBoxActivity;
import com.xiaowenxing.demotemplate.template.ZeroBuyActivity;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * 测试类
 *
 * @author XWX
 * @date 2021/6/17 18:25
 * @since 3.6
 **/
@RestController
@RequestMapping("/temple")
@AllArgsConstructor
public class Client {


    public static void main(String[] args) throws InterruptedException {
        ActivityDto activityDto = new ActivityDto();
        activityDto.setActivityName("0元购");
        activityDto.setStartTime(new Date());
        ActivityTemplate zeroBuyActivity = new ZeroBuyActivity();
        zeroBuyActivity.create(activityDto);

        Thread.sleep(3000);


      /*  System.out.println("===============================");
        ActivityDto activityDto2 = new ActivityDto();
        activityDto2.setActivityName("盲盒活动");
        activityDto2.setStartTime(new Date());
        ActivityTemplate mysteryBoxActivity = new MysteryBoxActivity();
        mysteryBoxActivity.create(activityDto2);*/
    }


    /**
     * 使用spring @Autowired注解时。需要注意，
     * 当前使用这个注解的类要么是可实例化的，要么子类是可实例化的。
     * 并且这个类需要向上被注入引用（服务被调用时进行托管），或者直接注入容器（交由AOC容器托管）。
     * 只有在Spring容器中，spring机制才能进行托管，对实例之间的引用进行管理
     */
    @Autowired
    private MysteryBoxActivity mysteryBoxActivity;


    @GetMapping("/test")
    public void test() {

        ActivityDto activityDto2 = new ActivityDto();
        activityDto2.setActivityName("盲盒活动");
        activityDto2.setStartTime(new Date());
        mysteryBoxActivity.create(activityDto2);


    }

}
