package com.study.producer;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.study.utils.RabbitMqUtils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * 死信队列
 *
 * @author yunshuaiwei
 * @version 1.0
 * @date 2023/3/1 23:36
 */
public class ProducerWorker05 {
    private static final String NORMAL_EXCHANGE = "normal_exchange";

    public static void main(String[] args) {
        Channel channel = RabbitMqUtils.getChannel();
        AMQP.BasicProperties properties = new AMQP.BasicProperties().builder().expiration("10000").build();
        for (int i = 0; i < 10; i++) {
            String mess = "info" + i;
            try {
                channel.basicPublish(NORMAL_EXCHANGE, "ZhangSan", properties, mess.getBytes(StandardCharsets.UTF_8));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
