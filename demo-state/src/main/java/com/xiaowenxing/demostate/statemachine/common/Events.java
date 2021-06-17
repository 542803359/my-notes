package com.xiaowenxing.demostate.statemachine.common;

/**
 * 事件枚举
 *
 * @author xwx
 * @date 2021/6/10 16:49
 */
public enum Events {
    /**
     * 支付(状态从: 待支付->待收货)
     */
    PAY,

    /**
     * 收货(状态从: 待收货->结束)
     */
    RECEIVE
}
