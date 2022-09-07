package com.xiaowenxing.demoemqx.mqtt;

import com.xiaowenxing.demoemqx.config.MqttConfiguration;
import com.xiaowenxing.demoemqx.service.DataHandleService;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * mqtt回调
 *
 * @author xiaowx
 * @date 2022/09/06 11:07:28
 */
@Slf4j
@Component
public class PushCallback implements MqttCallback {

    private MqttPushClient client;
    private MqttConfiguration mqttConfiguration;


    public PushCallback(MqttPushClient client ,MqttConfiguration mqttConfiguration) {
        this.client = client;
        this.mqttConfiguration = mqttConfiguration;
    }


    @Override
    public void connectionLost(Throwable throwable) {
        if(client != null) {
            while (true) {
                try {
                    log.info("==============》》》[MQTT] 连接断开，5S之后尝试重连...");
                    Thread.sleep(5000);
                    MqttPushClient mqttPushClient = new MqttPushClient();
                    mqttPushClient.connect(mqttConfiguration);
                    if(MqttPushClient.getClient().isConnected()){
                        log.info("=============>>重连成功");
                    }
                    break;
                } catch (Exception e) {
                    log.error("=============>>>[MQTT] 连接断开，重连失败！<<=============");
                    continue;
                }
            }
        }
    }

    @Override
    public void messageArrived(String topic, MqttMessage message) throws Exception {
        // subscribe后得到的消息会执行到这里面
        String Payload = new String(message.getPayload());

        log.info("============》》接收消息主题 : " + topic);
        log.info("============》》接收消息Qos : " + message.getQos());
        log.info("============》》接收消息内容 : " + Payload);
        log.info("============》》接收ID : " + message.getId());
        log.info("接收数据结束 下面可以执行数据处理操作");


    }

    @Override
    public void deliveryComplete(IMqttDeliveryToken iMqttDeliveryToken) {
        //publish后会执行到这里
        log.info("publish后会执行到这里");
        log.info("pushComplete==============>>>" + iMqttDeliveryToken.isComplete());
    }
}
