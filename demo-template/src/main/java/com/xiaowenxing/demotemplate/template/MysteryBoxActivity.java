package com.xiaowenxing.demotemplate.template;

import com.xiaowenxing.demotemplate.dto.ActivityDto;
import org.springframework.stereotype.Service;

/**
 * 盲盒活动
 *
 * @author XWX
 * @date 2021/6/17 18:13
 * @since 3.6
 **/
@Service("mysteryBoxActivity")
public class MysteryBoxActivity extends ActivityTemplate {


    @Override
    public void handleData(Integer activityId, ActivityDto activityDto) {

        System.out.println("盲盒活动  处理数据: " + activityId);
    }


}
