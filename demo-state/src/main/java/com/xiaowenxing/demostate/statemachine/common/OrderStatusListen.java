package com.xiaowenxing.demostate.statemachine.common;


import com.xiaowenxing.demostate.statemachine.domin.Order;
import com.xiaowenxing.demostate.statemachine.enums.OrderStatusEnum;
import org.springframework.messaging.Message;
import org.springframework.statemachine.annotation.OnTransition;
import org.springframework.statemachine.annotation.WithStateMachine;
import org.springframework.stereotype.Component;

/**
 * 状态监听
 *
 * @author xiaowx
 * @date 2024/02/02 16:16:50
 */
@Component
@WithStateMachine
public class OrderStatusListen {

    @OnTransition(source = "WAIT_PAYMENT", target = "WAIT_DELIVER")
    public boolean payTransition(Message message) {
        Order order = (Order) message.getHeaders().get("order");
        assert order != null;
        order.setOrderStatus(OrderStatusEnum.WAIT_DELIVER);
        System.out.println("支付，状态机反馈信息：" + message.getHeaders());
        return true;
    }

    @OnTransition(source = "WAIT_DELIVER", target = "WAIT_RECEIVE")
    public boolean deliverTransition(Message message) {
        Order order = (Order) message.getHeaders().get("order");
        assert order != null;
        order.setOrderStatus(OrderStatusEnum.WAIT_RECEIVE);
        System.out.println("发货，状态机反馈信息：" + message.getHeaders());
        return true;
    }

    @OnTransition(source = "WAIT_RECEIVE", target = "FINISH")
    public boolean receiveTransition(Message message) {
        Order order = (Order) message.getHeaders().get("order");
        assert order != null;
        order.setOrderStatus(OrderStatusEnum.FINISH);
        System.out.println("收货，状态机反馈信息：" + message.getHeaders());
        return true;
    }

}
