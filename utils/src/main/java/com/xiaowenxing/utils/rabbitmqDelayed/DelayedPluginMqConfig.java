package com.xiaowenxing.utils.rabbitmqDelayed;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.CustomExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;


/**
 * 插件实现rabbitMq延迟队列配置类
 *
 * @author xiaowx
 * @date 2022/06/30 17:06:45
 */
@Configuration
public class DelayedPluginMqConfig {


    /**
     * 交换机类型
     */
    public static final String EXCHANGE_TYPE = "x-delayed-message";

    /**
     * 延迟消息必传参数
     */
    public static Map<String, Object> DELAYED_ARGUMENTS = new HashMap<String, Object>(1) {{
        put("x-delayed-type", "direct");
    }};


    /**
     * 数美延迟审核相关配置
     */
    @Bean
    public Queue delayedQueue() {
        return new Queue(
                QueueConstant.USER_LOG_OUT_DELAYED_QUEUE,
                true,
                false,
                false);
    }

    @Bean
    public CustomExchange delayedExchange() {
        return new CustomExchange(
                QueueConstant.USER_LOG_OUT_DELAYED_EXCHANGE,
                EXCHANGE_TYPE,
                true,
                false,
                DELAYED_ARGUMENTS);
    }

    @Bean
    public Binding delayedBinding() {
        return BindingBuilder
                .bind(delayedQueue())
                .to(delayedExchange())
                .with(QueueConstant.USER_LOG_OUT_DELAYED_ROUTE_KEY)
                .noargs();
    }


}
