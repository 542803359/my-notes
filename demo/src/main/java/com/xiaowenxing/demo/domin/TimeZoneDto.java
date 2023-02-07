package com.xiaowenxing.demo.domin;

import lombok.Data;

/**
 * 时区
 *
 * @author xiaowx
 * @date 2023/02/06 11:13:07
 */
@Data
public class TimeZoneDto {

    private String en;
    private String zh;
    private String shorthand;
    private String code;
    private String timeOffset;
    private String hours;
    private String minute;

}
