package com.xiaowenxing.demoemqx.controller;

import com.xiaowenxing.demoemqx.mqtt.MqttPushClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


/**
 * mqtt控制器
 *
 * @author xiaowx
 * @date 2022/09/06 17:27:35
 */
@Slf4j
@RestController("/mqtt")
public class MqttController {


    @Resource
    private MqttPushClient mqttPushClient;

    @RequestMapping("/sendMqtt")
    public String sendMqtt() {
        String topicOne = "test-test1";
        String msg = "{'gender':'man','hobby':'girl'}";
        log.info("    本机主题:" + topicOne + " 发送数据为:" + msg);
        mqttPushClient.publish(topicOne, msg);
        log.info("     发送结束");
        return "发送结束";
    }

    @RequestMapping("/subscriptionMqtt")
    public String subscriptionMqtt() {
        int qos = 1;
        String topicOne = "test-test1";
        mqttPushClient.subscribe(topicOne, qos);
        return "订阅主题";
    }
}