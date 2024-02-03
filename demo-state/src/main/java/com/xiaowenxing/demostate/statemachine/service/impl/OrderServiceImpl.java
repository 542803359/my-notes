package com.xiaowenxing.demostate.statemachine.service.impl;


import com.xiaowenxing.demostate.statemachine.domin.Order;
import com.xiaowenxing.demostate.statemachine.enums.OrderStatusChangeEventEnum;
import com.xiaowenxing.demostate.statemachine.enums.OrderStatusEnum;
import com.xiaowenxing.demostate.statemachine.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.statemachine.StateMachine;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
@Service
public class OrderServiceImpl implements OrderService {

    @Resource
    private StateMachine<OrderStatusEnum, OrderStatusChangeEventEnum> orderStateMachine;

    private Map<Long, Order> orders = new ConcurrentHashMap<Long, Order>();

    private long id = 1L;

    @Override
    public Order create() {
        Order order = new Order();
        order.setOrderStatus(OrderStatusEnum.WAIT_PAYMENT);
        order.setOrderId(id++);
        orders.put(order.getOrderId(), order);
        log.info("订单创建成功:{}", order);
        return order;
    }

    @Override
    public Order pay(long id) {
        Order order = orders.get(id);
        log.info(" 尝试支付，订单号：{}", id);
        Message<OrderStatusChangeEventEnum> message = MessageBuilder
                .withPayload(OrderStatusChangeEventEnum.PAYED).setHeader("order", order).build();
        boolean sendEventFlag = sendEvent(message);
        if (!sendEventFlag) {
            log.info(" 支付失败，状态异常，订单号：{}", id);
            return null;
        }
        return orders.get(id);
    }

    @Override
    public Order deliver(long id) {
        Order order = orders.get(id);
        log.info(" 尝试发货，订单号：{}", id);
        Message<OrderStatusChangeEventEnum> message = MessageBuilder
                .withPayload(OrderStatusChangeEventEnum.DELIVERY).setHeader("order", order).build();
        boolean sendEventFlag = sendEvent(message);
        if (!sendEventFlag) {
            log.info(" 收货发败，状态异常，订单号：{}", id);
            return null;
        }
        return orders.get(id);
    }

    @Override
    public Order receive(long id) {
        Order order = orders.get(id);
        log.info(" 尝试收货，订单号：{}", id);
        Message<OrderStatusChangeEventEnum> message = MessageBuilder
                .withPayload(OrderStatusChangeEventEnum.RECEIVED).setHeader("order", order).build();
        boolean sendEventFlag = sendEvent(message);
        if (!sendEventFlag) {
            log.info(" 收货失败，状态异常，订单号：{}", id);
            return null;
        }
        return orders.get(id);
    }

    @Override
    public Map<Long, Order> getOrders() {
        return orders;
    }


    private synchronized boolean sendEvent(Message<OrderStatusChangeEventEnum> message) {
        boolean result = false;
        try {
            orderStateMachine.start();
            result = orderStateMachine.sendEvent(message);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (Objects.nonNull(message)) {
                Order order = (Order) message.getHeaders().get("order");
                if (Objects.nonNull(order) && Objects.equals(order.getOrderStatus(), OrderStatusEnum.FINISH)) {
                    orderStateMachine.stop();
                }
            }
        }
        return result;
    }


}
