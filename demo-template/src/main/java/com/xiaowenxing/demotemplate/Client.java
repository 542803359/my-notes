package com.xiaowenxing.demotemplate;

import com.xiaowenxing.demotemplate.dto.ActivityDto;
import com.xiaowenxing.demotemplate.template.ActivityTemplate;
import com.xiaowenxing.demotemplate.template.MysteryBoxActivity;
import com.xiaowenxing.demotemplate.template.ZeroBuyActivity;

import java.util.Date;

/**
 * 测试类
 *
 * @author XWX
 * @date 2021/6/17 18:25
 * @since 3.6
 **/
public class Client {


    public static void main(String[] args) throws InterruptedException {
        ActivityDto activityDto = new ActivityDto();
        activityDto.setActivityName("0元购");
        activityDto.setStartTime(new Date());
        ActivityTemplate zeroBuyActivity = new ZeroBuyActivity();
        zeroBuyActivity.create(activityDto);

        Thread.sleep(3000);


        System.out.println("===============================");
        ActivityDto activityDto2 = new ActivityDto();
        activityDto2.setActivityName("盲盒活动");
        activityDto2.setStartTime(new Date());
        ActivityTemplate mysteryBoxActivity = new MysteryBoxActivity();
        mysteryBoxActivity.create(activityDto2);
    }

}
