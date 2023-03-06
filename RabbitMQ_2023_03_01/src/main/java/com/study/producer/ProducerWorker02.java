package com.study.producer;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.ConfirmCallback;
import com.rabbitmq.client.MessageProperties;
import com.study.utils.RabbitMqUtils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;

/**
 * 测试手动应答
 *
 * @author yunshuaiwei
 * @version 1.0
 * @date 2023/3/1 23:36
 */
public class ProducerWorker02 {
    private static final String QUEUE_NAME = "queue_ack";

    public static void main(String[] args) throws IOException, InterruptedException {
        Channel channel = RabbitMqUtils.getChannel();
        //开启发布确认
        channel.confirmSelect();
        //创建队列
        channel.queueDeclare(QUEUE_NAME, true, false, false, null);
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String message = scanner.next();
            channel.basicPublish("", QUEUE_NAME, MessageProperties.PERSISTENT_TEXT_PLAIN, message.getBytes(StandardCharsets.UTF_8));
            boolean b = channel.waitForConfirms();
            if (b) {
                System.out.println("生产者发送消息成功：" + message);
            }
        }
    }


    /**
     * 异步发布确认
     *
     * @author yunshuaiwei
     * @date 2023/3/2 10:31
     **/
    public static void publishMessageAsync() throws Exception {
        Channel channel = RabbitMqUtils.getChannel();
        //开启发布确认
        channel.confirmSelect();
        //创建队列
        channel.queueDeclare(QUEUE_NAME, true, false, false, null);
        //开启发布确认
        channel.confirmSelect();
        //线程安全有序的哈希表
        //可以将序号和消息进行关联，可以批量删除消息条目，且支持高并发
        ConcurrentSkipListMap<Long, Object> map = new ConcurrentSkipListMap<>();
        //消息确认成功后的回调
        ConfirmCallback confirmCallback = (tag, multiple) -> {
            //删除已经确认的消息
            if (multiple){//批量
                ConcurrentNavigableMap<Long, Object> confirmed = map.headMap(tag);
                confirmed.clear();
            }else{
                map.remove(tag);
            }
            System.out.println("确认成功的消息：" + tag);
        };
        //消息确认失败后的回调
        ConfirmCallback nackCallback = (tag, multiple) -> {
            Object o = map.get(tag);
            System.out.println("未确认的消息：" + o.toString());
        };
        //消息监听器
        channel.addConfirmListener(confirmCallback, nackCallback);
        for (int i = 0; i < 1000; i++) {
            String mess = i + "";
            channel.basicPublish("", QUEUE_NAME, MessageProperties.PERSISTENT_TEXT_PLAIN, mess.getBytes(StandardCharsets.UTF_8));
            //1.记录所有要发送的消息
            map.put(channel.getNextPublishSeqNo(),mess);
        }
    }
}
