package com.xiaowenxing.demostate.statemachine.config;

import com.xiaowenxing.demostate.statemachine.common.Events;
import com.xiaowenxing.demostate.statemachine.common.States;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.statemachine.config.EnableStateMachine;
import org.springframework.statemachine.config.EnumStateMachineConfigurerAdapter;
import org.springframework.statemachine.config.builders.StateMachineStateConfigurer;
import org.springframework.statemachine.config.builders.StateMachineTransitionConfigurer;

import java.util.EnumSet;

/**
 * 状态机配置类
 *
 * @author XWX
 * @date 2021/6/10 16:57
 *
 * <p>
 * @EnableStateMachine: 注解用来启用Spring StateMachine状态机功能
 * </p>
 **/
@Configuration
@EnableStateMachine(name = "testMachine")
@Slf4j
public class StateMachineConfig extends EnumStateMachineConfigurerAdapter<States, Events> {


    /**
     * 方法用来初始化当前状态机拥有哪些状态
     */
    @Override
    public void configure(StateMachineStateConfigurer<States, Events> states) throws Exception {

        states.withStates()
                //定义了初始状态
                .initial(States.UNPAID)
                //指定枚举类States为该状态机的状态定义
                .states(EnumSet.allOf(States.class));
    }

    /**
     * 用来初始化当前状态机有哪些状态迁移动作，其中命名中我们很容易理解每一个迁移动作.
     * 都有来源状态"source"，目标状态"target"以及触发事件"event"
     */
    @Override
    public void configure(StateMachineTransitionConfigurer<States, Events> transitions) throws Exception {

        transitions
                .withExternal()
                .source(States.UNPAID).target(States.WAITING_FOR_RECEIVE)
                .event(Events.PAY)
                .and()
                .withExternal()
                .source(States.WAITING_FOR_RECEIVE).target(States.DONE)
                .event(Events.RECEIVE);
    }


}
