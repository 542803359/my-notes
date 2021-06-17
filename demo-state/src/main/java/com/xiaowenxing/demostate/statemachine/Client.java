package com.xiaowenxing.demostate.statemachine;

import com.xiaowenxing.demostate.statemachine.common.Events;
import com.xiaowenxing.demostate.statemachine.common.States;
import com.xiaowenxing.demostate.statemachine.config.OrderMachineBuilder;
import com.xiaowenxing.demostate.statemachine.config.OrderStateMachinePersist;
import com.xiaowenxing.demostate.statemachine.domin.Order;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.statemachine.StateMachine;
import org.springframework.statemachine.persist.StateMachinePersister;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 客户端类
 *
 * @author XWX
 * @date 2021/6/10 16:47
 * @since 3.6
 **/
@RestController
@RequestMapping("/state")
public class Client {

    @Autowired
    private OrderMachineBuilder orderMachineBuilder;

    @Autowired
    private BeanFactory beanFactory;

    @Autowired
    private OrderStateMachinePersist orderStateMachinePersist;

    @Resource(name = "orderMemoryPersister")
    private StateMachinePersister<States, Events, String> stateMachinePersister;


    @GetMapping("/testMachineBuild")
    public void testMachineBuild(String orderId) throws Exception {
        Order order = new Order();
        order.setId(orderId);
        StateMachine<States, Events> build = orderMachineBuilder.build(beanFactory);

        build.start();

        Message<Events> message = MessageBuilder
                .withPayload(Events.PAY).setHeader("order", order).build();
        build.sendEvent(message);

        stateMachinePersister.persist(build, orderId);

        //   build.sendEvent(Events.RECEIVE);

        // 获取最终状态
        System.out.println("当前状态：" + build.getState().getId());
    }


    @GetMapping("/testMemoryPersisterRestore")
    public void testMemoryRestore(String orderId) throws Exception {
        StateMachine<States, Events> stateMachine = orderMachineBuilder.build(beanFactory);

        stateMachinePersister.restore(stateMachine, orderId);
        System.out.println("恢复状态机后的状态为：" + stateMachine.getState().getId());

        stateMachine.sendEvent(Events.RECEIVE);


        // 获取最终状态
        System.out.println("当前状态：" + stateMachine.getState().getId());

    }
}
