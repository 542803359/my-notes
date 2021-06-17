package com.xiaowenxing.demotemplate.dto;

import lombok.Data;

import java.util.Date;

/**
 * 活动参数传输类
 *
 * @author XWX
 * @date 2021/6/17 17:38
 * @since 3.6
 **/
@Data
public class ActivityDto {

    private String activityName;

    private Date startTime;
}
