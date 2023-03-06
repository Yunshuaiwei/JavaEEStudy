package com.study.producer;

import com.rabbitmq.client.Channel;
import com.study.utils.RabbitMqUtils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * 交换机
 *
 * @author yunshuaiwei
 * @version 1.0
 * @date 2023/3/1 23:36
 */
public class ProducerWorker03 {
    private static final String EXCHANGE_NAME = "exchange01";

    public static void main(String[] args) throws IOException, InterruptedException {
        Channel channel = RabbitMqUtils.getChannel();
        channel.exchangeDeclare(EXCHANGE_NAME, "fanout");
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String mess = scanner.next();
            channel.basicPublish(EXCHANGE_NAME, "", null, mess.getBytes(StandardCharsets.UTF_8));
            System.out.println("发送消息：" + mess);
        }
    }
}
