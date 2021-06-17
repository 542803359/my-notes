package com.xiaowenxing.demostate.statemachine.config;

import com.xiaowenxing.demostate.statemachine.common.Events;
import com.xiaowenxing.demostate.statemachine.common.States;
import org.springframework.statemachine.StateMachineContext;
import org.springframework.statemachine.StateMachinePersist;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @author XWX
 * @date 2021/6/11 10:36
 * @since 3.6
 **/
@Component
public class OrderStateMachinePersist implements StateMachinePersist<States, Events, String> {

    private Map<String, StateMachineContext<States, Events>> map = new HashMap<>();

    @Override
    public void write(StateMachineContext<States, Events> stateMachineContext, String contextObj) throws Exception {
        map.put(contextObj, stateMachineContext);
    }

    @Override
    public StateMachineContext<States, Events> read(String contextObj) throws Exception {

        return map.get(contextObj);

    }
}
