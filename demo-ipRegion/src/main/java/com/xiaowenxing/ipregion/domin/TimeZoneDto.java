package com.xiaowenxing.ipregion.domin;

import lombok.Data;

/**
 * 时区
 *
 * @author xiaowx
 * @date 2023/02/06 11:13:07
 */
@Data
public class TimeZoneDto {

    /**
     * 国家英文名
     */
    private String en;
    /**
     * 国家中文名
     */
    private String zh;
    /**
     * 国家简写
     */
    private String shorthand;
    /**
     * 国家代码
     */
    private String code;
    /**
     * 时区
     */
    private String timeOffset;
    /**
     * 小时偏移量
     */
    private String hours;
    /**
     * 分钟偏移量
     */
    private String minute;

}
