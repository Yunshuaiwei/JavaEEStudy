package com.study.test;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author yunshuaiwei
 * @version 1.0
 * @date 2023/3/1 10:49
 */
public class Consumer {
    private static final String QUEUE_NAME="hello";

    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("192.168.40.128");
        factory.setUsername("admin");
        factory.setPassword("admin");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        //声明 接收消息
        DeliverCallback deliverCallback=(consumerTag,message)->{
            System.out.println(new String(message.getBody()));
        };

        //取消消息时的回调
        CancelCallback cancelCallback=consumerTag->{
            System.out.println("消费消息被中断");
        };
        //消费者消费消息
        //1. param1：消费哪个队列
        //2. param2：消费成功之后是否自动应答
        //3. param3：消费者接收消息的回调
        //4. param4：消费者取消消息时的回调
        channel.basicConsume(QUEUE_NAME,true,deliverCallback,cancelCallback);
    }
}
