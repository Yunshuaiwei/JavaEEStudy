package com.study.producer;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.MessageProperties;
import com.study.utils.RabbitMqUtils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;

/**
 * 交换机 Topics类型
 *
 * @author yunshuaiwei
 * @version 1.0
 * @date 2023/3/1 23:36
 */
public class ProducerWorker04 {
    private static final String EXCHANGE_NAME = "exchange01";

    public static void main(String[] args) throws IOException, InterruptedException {
        Channel channel = RabbitMqUtils.getChannel();
        channel.exchangeDeclare(EXCHANGE_NAME, "topic");
        //测试代码
        HashMap<String, String> map = new HashMap<>();
        map.put("quick.orange.rabbit", "队列Q1 Q2接收");
        map.put("lazy.orange.elephant", "队列Q1 Q2接收");
        map.put("quick.orange.fox", "队列Q1接收");
        map.put("lazy.brown.fox", "队列Q2接收");
        map.put("lazy.pink.rabbit", "满足两个绑定，但是只被Q2接收一次");
        map.put("quick.brown.fox", "不匹配任何绑定不会被接收");
        for (String key : map.keySet()) {
            channel.basicPublish(EXCHANGE_NAME, key, MessageProperties.PERSISTENT_TEXT_PLAIN, map.get(key).getBytes(StandardCharsets.UTF_8));
            System.out.println("生产者发出消息：" + map.get(key));
        }
    }
}
