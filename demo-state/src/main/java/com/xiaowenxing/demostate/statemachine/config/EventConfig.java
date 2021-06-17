package com.xiaowenxing.demostate.statemachine.config;

import com.xiaowenxing.demostate.statemachine.common.Events;
import com.xiaowenxing.demostate.statemachine.domin.Order;
import org.springframework.messaging.Message;
import org.springframework.statemachine.annotation.OnTransition;
import org.springframework.statemachine.annotation.OnTransitionEnd;
import org.springframework.statemachine.annotation.OnTransitionStart;
import org.springframework.statemachine.annotation.WithStateMachine;

/**
 * 该配置实现了StateMachineConfig类中定义的状态机监听器实现
 *
 * @author XWX
 * @date 2021/6/10 17:24
 **/

@WithStateMachine(id = "testMachine")
public class EventConfig {

    @OnTransition(target = "UNPAID")
    public void create() {
        System.out.println("-------订单创建，待支付");
    }

    @OnTransition(source = "UNPAID", target = "WAITING_FOR_RECEIVE")
    public void pay(Message<Events> message) {
        Order order = message.getHeaders().get("order", Order.class);
        System.out.println("---------用户完成支付，待收货,orderId: " + order.getId());
    }


    @OnTransitionStart(source = "UNPAID", target = "WAITING_FOR_RECEIVE")
    public void payStart() {
        System.out.println("用户完成支付，待收货: start");
    }

    @OnTransitionEnd(source = "UNPAID", target = "WAITING_FOR_RECEIVE")
    public void payEnd() {
        System.out.println("用户完成支付，待收货: end");
    }



    @OnTransition(source = "WAITING_FOR_RECEIVE", target = "DONE")
    public void receive() {
        System.out.println("---------用户已收货，订单完成");
    }


}
