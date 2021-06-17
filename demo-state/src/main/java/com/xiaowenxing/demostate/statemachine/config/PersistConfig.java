package com.xiaowenxing.demostate.statemachine.config;

import com.xiaowenxing.demostate.statemachine.common.Events;
import com.xiaowenxing.demostate.statemachine.common.States;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.statemachine.persist.DefaultStateMachinePersister;
import org.springframework.statemachine.persist.StateMachinePersister;

/**
 * @author XWX
 * @date 2021/6/11 15:14
 * @since 3.6
 **/
@Configuration
public class PersistConfig {

    @Autowired
    private OrderStateMachinePersist orderStateMachinePersist;


    @Bean(name = "orderMemoryPersister")
    public StateMachinePersister<States, Events, String> getPersister() {
        return new DefaultStateMachinePersister<>(orderStateMachinePersist);
    }
}
