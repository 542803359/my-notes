package com.xiaowenxing.demostate.statemachine.domin;


import com.xiaowenxing.demostate.statemachine.enums.OrderStatusEnum;
import lombok.Data;

@Data
public class Order {

    private Long orderId;
    private OrderStatusEnum orderStatus;

}
