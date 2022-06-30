/**
 * xiyakj.com
 * Copyright (C) 2013-2022 All Rights Reserved.
 */
package com.xiaowenxing.utils.rabbitmqDelayed;

import com.alibaba.fastjson.JSON;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;


/**
 * 延迟消息工具类
 *
 * @author xiaowx
 * @date 2022/06/30 16:31:44
 */
@Component
public class PluginDelayedMessageUtil {

    @Resource
    private AmqpTemplate amqpTemplate;

    public void sendDelayMessage(String exchangeKey, String routeKey, Object message, Long time) {
        sendDelayMessage(exchangeKey, routeKey, message, time, TimeUnit.MILLISECONDS);
    }

    public void sendDelayMessage(String exchangeKey, String routeKey, Object message, Long time, TimeUnit timeUnit) {
        long millis = timeUnit.toMillis(time);
        amqpTemplate.convertAndSend(exchangeKey, routeKey, JSON.toJSONString(message), (msg) -> {
            msg.getMessageProperties().setHeader("x-delay", millis);
            return msg;
        });
    }

}