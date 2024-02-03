package com.xiaowenxing.demostate.statemachine.config;


import com.xiaowenxing.demostate.statemachine.enums.OrderStatusChangeEventEnum;
import com.xiaowenxing.demostate.statemachine.enums.OrderStatusEnum;
import org.springframework.context.annotation.Configuration;
import org.springframework.statemachine.config.EnableStateMachine;
import org.springframework.statemachine.config.StateMachineConfigurerAdapter;
import org.springframework.statemachine.config.builders.StateMachineStateConfigurer;
import org.springframework.statemachine.config.builders.StateMachineTransitionConfigurer;


import java.util.EnumSet;

/**
 * 订单状态机
 *
 * @author xiaowx
 * @date 2024/02/02 15:52:01
 */
@Configuration
@EnableStateMachine
public class OrderStatusMachineConfig extends StateMachineConfigurerAdapter<OrderStatusEnum, OrderStatusChangeEventEnum> {


    /**
     * 配置状态
     */
    @Override
    public void configure(StateMachineStateConfigurer<OrderStatusEnum, OrderStatusChangeEventEnum> states) throws Exception {
        states.withStates()
                .initial(OrderStatusEnum.WAIT_PAYMENT)
                .end(OrderStatusEnum.FINISH)
                .states(EnumSet.allOf(OrderStatusEnum.class));
    }

    /**
     * 配置状态转换事件关系
     */
    @Override
    public void configure(StateMachineTransitionConfigurer<OrderStatusEnum, OrderStatusChangeEventEnum> transitions) throws Exception {
        transitions
                .withExternal().source(OrderStatusEnum.WAIT_PAYMENT).target(OrderStatusEnum.WAIT_DELIVER)
                .event(OrderStatusChangeEventEnum.PAYED)
                .and()
                .withExternal().source(OrderStatusEnum.WAIT_DELIVER).target(OrderStatusEnum.WAIT_RECEIVE)
                .event(OrderStatusChangeEventEnum.DELIVERY)
                .and()
                .withExternal().source(OrderStatusEnum.WAIT_RECEIVE).target(OrderStatusEnum.FINISH)
                .event(OrderStatusChangeEventEnum.RECEIVED);
    }


}
