package com.xiaowenxing.demotemplate.template;

import com.xiaowenxing.demotemplate.dto.ActivityDto;

/**
 * 零元购活动
 *
 * @author XWX
 * @date 2021/6/17 18:20
 * @since 3.6
 **/
public class ZeroBuyActivity extends ActivityTemplate{

    @Override
    void handleData(Integer activityId, ActivityDto activityDto) {
        System.out.println("零元购活动  处理数据: " + activityId);
    }
}
