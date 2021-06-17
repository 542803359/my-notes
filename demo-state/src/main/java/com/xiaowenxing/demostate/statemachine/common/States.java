package com.xiaowenxing.demostate.statemachine.common;

/**
 * 状态枚举
 *
 * @author xwx
 * @date 2021/6/10 16:49
 */
public enum States {

    /**
     * 待支付
     */
    UNPAID,

    /**
     * 待收货
     */
    WAITING_FOR_RECEIVE,

    /**
     * 结束
     */
    DONE

}
