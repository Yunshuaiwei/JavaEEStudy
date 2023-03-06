package com.study.consumer;

import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.study.utils.RabbitMqUtils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

/**
 * 死信队列 消费者01
 *
 * @author yunshuaiwei
 * @version 1.0
 * @date 2023/3/1 23:44
 */
public class ConsumerWorker07 {

    private static final String NORMAL_EXCHANGE = "normal_exchange";
    private static final String DEAD_EXCHANGE = "dead_exchange";
    private static final String NORMAL_QUEUE = "normal_queue";
    private static final String DEAD_QUEUE = "dead_queue";

    public static void main(String[] args) {
        Channel channel = RabbitMqUtils.getChannel();

        try {
            //声明交换机
            channel.exchangeDeclare(NORMAL_EXCHANGE, BuiltinExchangeType.DIRECT);
            channel.exchangeDeclare(DEAD_EXCHANGE, BuiltinExchangeType.DIRECT);
            //声明队列
            Map<String, Object> map = new HashMap<>();
            //正常队列设置死信交换机
            map.put("x-dead-letter-exchange", DEAD_EXCHANGE);
            //设置路由RoutingKey
            map.put("x-dead-letter-routing-key", "lisi");
            channel.queueDeclare(NORMAL_QUEUE, false, false, false, map);
            channel.queueDeclare(DEAD_QUEUE, false, false, false, null);
            //队列和交换机进行绑定
            channel.queueBind(NORMAL_QUEUE,NORMAL_EXCHANGE,"ZhangSan");
            channel.queueBind(DEAD_QUEUE,DEAD_EXCHANGE,"lisi");
            //发送消息
            System.out.println("等待接收消息......");
            channel.basicConsume(NORMAL_QUEUE, true, (consumerTag, mess) -> {
                System.out.println("Consumer01接收到消息："+new String(mess.getBody(), StandardCharsets.UTF_8));
            }, consumerTag -> {
                System.out.println("消息接收失败：" + consumerTag);
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
