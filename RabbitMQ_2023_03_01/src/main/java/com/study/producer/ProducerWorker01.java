package com.study.producer;

import com.rabbitmq.client.Channel;
import com.study.utils.RabbitMqUtils;

import java.io.IOException;
import java.util.Scanner;

/**
 * @author yunshuaiwei
 * @version 1.0
 * @date 2023/3/1 11:34
 */
public class ProducerWorker01 {
    private static final String QUEUE_NAME = "hello";

    public static void main(String[] args) throws IOException {
        Channel channel = RabbitMqUtils.getChannel();
        channel.queueDeclare(QUEUE_NAME, true, false, false, null);
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String message = scanner.next();
            channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
            System.out.println("发送消息完成：" + message);
        }
    }
}
