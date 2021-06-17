package com.xiaowenxing.demostate.statemachine.domin;

import lombok.Data;

/**
 * @author XWX
 * @date 2021/6/11 10:39
 * @since 3.6
 **/
@Data
public class Order {

    /**
     * 订单ID
     */
    private String id;

    /**
     * 用户ID
     */
    private String userId;

    /**
     * 订单收货地址
     */
    private String address;

    /**
     * 订单手机号
     */
    private String phoneNum;

    /**
     * 订单状态
     */
    private String state;
}
