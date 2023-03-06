package com.study.consumer;

import com.rabbitmq.client.CancelCallback;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DeliverCallback;
import com.study.utils.RabbitMqUtils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * 测试手动应答：处理消息模拟需要10s
 *
 * @author yunshuaiwei
 * @version 1.0
 * @date 2023/3/1 23:44
 */
public class ConsumerWorker03 {

    private static final String QUEUE_NAME = "queue_ack";

    public static void main(String[] args) throws IOException {
        Channel channel = RabbitMqUtils.getChannel();
        //改为不公平分发
        channel.basicQos(5);
        System.out.println("C2等待接收消息，处理时间为10s");
        DeliverCallback deliverCallback = (tag, mess) -> {
            try {
                //模拟该消息需要处理10s
                Thread.sleep(20000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("接收到的消息：" + new String(mess.getBody(), StandardCharsets.UTF_8));
            //手动应答
            //1. param1：消息标记tag
            //2. param2：是否批量应答
            channel.basicAck(mess.getEnvelope().getDeliveryTag(), false);
        };

        CancelCallback cancelCallback = tag -> {
            System.out.println(tag + "接收消息被取消！");
        };
        // 采用手动应答
        channel.basicConsume(QUEUE_NAME, false, deliverCallback, cancelCallback);
    }
}
