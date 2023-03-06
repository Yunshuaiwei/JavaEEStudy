package com.study.consumer;

import com.rabbitmq.client.CancelCallback;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DeliverCallback;
import com.study.utils.RabbitMqUtils;

import java.io.IOException;

/**
 * @author yunshuaiwei
 * @version 1.0
 * @date 2023/3/1 11:24
 */
public class ConsumerWorker01 {
    private static final String QUEUE_NAME = "hello";

    public static void main(String[] args) {
        Channel channel = RabbitMqUtils.getChannel();
        DeliverCallback deliverCallback = (consumerTag, message) -> {
            System.out.println("接收到的消息：" + new String(message.getBody()));
        };

        CancelCallback cancelCallback = consumerTag -> {
            System.out.println(consumerTag + "接收消息被取消！");
        };

        try {
            System.out.println("C1等待接收消息......");
            channel.basicConsume(QUEUE_NAME, true, deliverCallback, cancelCallback);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
