package com.example.controller;

import cn.hutool.core.date.DateUtil;
import com.example.config.DelayedQueueConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yunshuaiwei
 * @version 1.0
 * @date 2023/3/6 11:03
 */
@RestController
@RequestMapping("/ttl")
@Slf4j
public class SendMsg {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @GetMapping("/sendMsg/{message}")
    public void sendMsg(@PathVariable String message) {
        log.info("当前时间：{}，发送一条消息给两个TTL队列:{}", DateUtil.now(), message);
        //发送消息
        rabbitTemplate.convertAndSend("X", "XA", "消息来自ttl为10s的队列：" + message);
        rabbitTemplate.convertAndSend("X", "XB", "消息来自ttl为40s的队列：" + message);
    }

    @GetMapping("/sendMsg/{message}/{delayTime}")
    public void sendDelayedMsg(@PathVariable("message") String message, @PathVariable("delayTime") Integer delayTime) {
        log.info("当前时间：{}，发送一条时长为{}毫秒的信息给延时队列delayed.queue：{}", DateUtil.now(), delayTime, message);
        rabbitTemplate.convertAndSend(DelayedQueueConfig.DELAYED_EXCHANGE_NAME, "delayed.routingKey", message, msg -> {
            //设置延时时间
            msg.getMessageProperties().setDelay(delayTime);
            return msg;
        });
    }
}
