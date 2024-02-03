package com.xiaowenxing.demostate.statemachine.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 订单状态
 *
 * @author xiaowx
 * @date 2024/02/02 15:43:30
 */
@Getter
@AllArgsConstructor
public enum OrderStatusEnum {

    // 待支付
    WAIT_PAYMENT,
    // 待发货
    WAIT_DELIVER,
    // 待收货
    WAIT_RECEIVE,
    // 完成
    FINISH;

}
