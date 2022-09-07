package com.xiaowenxing.demoemqx.config;

import com.xiaowenxing.demoemqx.mqtt.MqttPushClient;
import lombok.Data;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * mqtt配置
 *
 * @author xiaowx
 * @date 2022/09/06 14:06:29
 */
@Data
@Component
@ConfigurationProperties(prefix = "spring.mqtt")
public class MqttConfiguration {

    private String host;

    private String clientId;

    private String username;

    private String password;

    private int timeout;

    private int keepAlive;

    private String topics;

    private int qos;


    @Bean
    public MqttPushClient getMqttPushClient() {
        MqttPushClient mqttPushClient = new MqttPushClient();
        mqttPushClient.connect(this);
        return mqttPushClient;
    }


}
