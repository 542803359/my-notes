package com.xiaowenxing.utils.rabbitmqDelayed;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * 演示
 *
 * @author xiaowx
 * @date 2022/06/30 16:34:17
 */
@Component
@Slf4j
@RestController
public class Demo {

    @Resource
    private PluginDelayedMessageUtil delayedMessageUtil;


    /**
     * 发送
     *
     * @author xiaowx
     * @date 2022/06/30 16:36:40
     */
    @GetMapping("test")
    public void sendTest() {
        delayedMessageUtil.sendDelayMessage(
                QueueConstant.USER_LOG_OUT_DELAYED_EXCHANGE,
                QueueConstant.USER_LOG_OUT_DELAYED_ROUTE_KEY,
                "userId",
                10L, TimeUnit.SECONDS);
    }

    /**
     * 延迟消费
     *
     * @author xiaowx
     * @date 2022/06/30 16:38:54
     */
    @RabbitListener(queuesToDeclare = @Queue(QueueConstant.USER_LOG_OUT_DELAYED_QUEUE))
    public void delay(String msg) {
        log.info("msg:{}", msg);
        try {
            log.info("消费数据:{}", msg);
        } catch (Exception e) {
            log.error("延迟队列处理消费异常,msg:{}", e.getMessage(), e);
        }
    }


}
