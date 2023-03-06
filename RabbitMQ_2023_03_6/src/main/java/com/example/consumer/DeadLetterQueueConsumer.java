package com.example.consumer;

import cn.hutool.core.date.DateUtil;
import com.example.config.DelayedQueueConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import static java.nio.charset.StandardCharsets.UTF_8;

/**
 * @author yunshuaiwei
 * @version 1.0
 * @date 2023/3/6 11:09
 */
@Slf4j
@Component
public class DeadLetterQueueConsumer {
    @RabbitListener(queues = "QD")
    public void receiveQueueD(Message message) {
        String msg = new String(message.getBody(), UTF_8);
        log.info("当前时间：{},收到死信队列的消息：{}", DateUtil.now(), msg);
    }

    @RabbitListener(queues = DelayedQueueConfig.DELAYED_QUEUE_NAME)
    public void receiveQueueDelayed(Message message){
        String msg=new String(message.getBody(), UTF_8);
        log.info("当前时间：{},收到延时消息：{}", DateUtil.now(), msg);
    }
}
