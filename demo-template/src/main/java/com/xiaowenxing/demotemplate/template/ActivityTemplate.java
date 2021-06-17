package com.xiaowenxing.demotemplate.template;

import com.xiaowenxing.demotemplate.dto.ActivityDto;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 活动模板类
 *
 * @author XWX
 * @date 2021/6/17 17:33
 * @since 3.6
 **/
public abstract class ActivityTemplate {


    /**
     * 创建活动
     *
     * @param activityDto: 活动开始时间
     */
    //TODO:此处需要加上事务注解
    public void create(ActivityDto activityDto) {
        if (!decideActivityTime(activityDto.getStartTime())) {
            System.out.println("活动时间冲突");
            return;
        }
        Integer activityId = createActivity(activityDto);

        handleData(activityId, activityDto);

    }


    /**
     * 检查活动时间是否存在冲突
     *
     * @param startTime: 活动开始时间
     * @return
     */
    final boolean decideActivityTime(Date startTime) {

        //检查活动时间是否存在冲突
        System.out.println(new SimpleDateFormat("yyyy-MM-dd KK:mm:ss").format(startTime));

        return true;

    }

    /**
     * 创建活动
     *
     * @param activityDto: 活动参数传输类
     * @return
     */
    final Integer createActivity(ActivityDto activityDto) {

        //将activityDto存库,返回id
        System.out.println("创建活动 " + activityDto.getActivityName());
        return 1;
    }

    /**
     * 处理数据,不同活动数据处理方式不一样,需要子类实现
     *
     * @param activityDto: 活动参数传输类
     */
    abstract void handleData(Integer activityId, ActivityDto activityDto);


}
