package com.study.consumer;

import com.rabbitmq.client.Channel;
import com.study.utils.RabbitMqUtils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * 交换机 Topics类型 消费者02
 *
 * @author yunshuaiwei
 * @version 1.0
 * @date 2023/3/1 23:44
 */
public class ConsumerWorker06 {

    private static final String EXCHANGE_NAME = "exchange01";

    public static void main(String[] args) throws IOException {
        Channel channel = RabbitMqUtils.getChannel();
        //param1：交换机名称 param2：交换机类型--扇出
        channel.exchangeDeclare(EXCHANGE_NAME, "topic");
        //获取一个临时队列
        String queue = channel.queueDeclare().getQueue();
        //param1：队列名称 param2：交换机名称 param3：routingKey
        channel.queueBind(queue, EXCHANGE_NAME, "*.*.rabbit");
        channel.queueBind(queue, EXCHANGE_NAME, "lazy.#");
        System.out.println("等待接收消息......");
        channel.basicConsume(queue, true, (tag, mess) -> {
            System.out.println("接收到消息：" + new String(mess.getBody(), StandardCharsets.UTF_8));
            System.out.println("接收队列：Q2，绑定键：" + mess.getEnvelope().getRoutingKey());
        }, tag -> {
            System.out.println("消息接收失败！");
        });
    }
}
