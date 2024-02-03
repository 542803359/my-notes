package com.xiaowenxing.demostate.statemachine.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 订单状态转换行为
 *
 * @author xiaowx
 * @date 2024/02/02 15:43:18
 */
@Getter
@AllArgsConstructor
public enum OrderStatusChangeEventEnum {

    //支付
    PAYED,
    //发货
    DELIVERY,
    //收货
    RECEIVED;

}
