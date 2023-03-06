package com.study.test;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author yunshuaiwei
 * @version 1.0
 * @date 2023/3/1 10:37
 */
public class Producer {

    private static final String QUEUE_NAME = "hello";

    public static void main(String[] args) throws IOException, TimeoutException {
        //创建连接工厂
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("192.168.40.128");
        factory.setUsername("admin");
        factory.setPassword("admin");
        Connection connection = factory.newConnection();
        System.out.println("开始发送消息......");
        //获取信道
        Channel channel = connection.createChannel();
        //创建队列
        //1. param1：队列名称
        //2. param2：是否持久化
        //3. param3：是否只供一个消费者消费，及消息共享
        //4. param4：是否自动删除 最后一个消费者断开连接后，该队列是否自动删除
        channel.queueDeclare(QUEUE_NAME, true, false, false, null);
        // 1. param1：发送大哪个交换机
        // 2. param2：路由的Key值
        // 3. param3：其他参数信息
        // 4. param4：发送消息的消息体
        channel.basicPublish("", QUEUE_NAME, null, "hello world".getBytes());
        System.out.println("发送消息结束......");
    }
}
