package com.xiaowenxing.demostate.statemachine.service;


import com.xiaowenxing.demostate.statemachine.domin.Order;

import java.util.Map;

public interface OrderService {


    public Order create();

    public Order pay(long id);

    public Order deliver(long id);

    public Order receive(long id);

    public Map<Long, Order> getOrders();

}
