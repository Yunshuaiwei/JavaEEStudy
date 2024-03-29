package com.example.config;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yunshuaiwei
 * @version 1.0
 * @date 2023/3/6 10:45
 */
@Configuration
public class TtlQueueConfig {
    private static final String X_EXCHANGE = "X";

    private static final String Y_DEAD_LETTER_EXCHANGE = "Y";

    public static final String QUEUE_A = "QA";

    public static final String QUEUE_B = "QB";

    public static final String DEAD_LETTER_QUEUE = "QD";

    @Bean("xExchange")
    public DirectExchange xExchange() {
        return new DirectExchange(X_EXCHANGE);
    }

    @Bean("yExchange")
    public DirectExchange yExchange() {
        return new DirectExchange(Y_DEAD_LETTER_EXCHANGE);
    }


    @Bean("queueA")
    public Queue aQueue() {
        Map<String, Object> arguments = new HashMap<>(2);
        //设置死信交换机
        arguments.put("x-dead-letter-exchange", Y_DEAD_LETTER_EXCHANGE);
        arguments.put("x-dead-letter-routing-key", "YD");
        return QueueBuilder
                .durable(QUEUE_A)
                .ttl(10000)
                .withArguments(arguments).build();
    }

    @Bean("queueB")
    public Queue bQueue() {
        Map<String, Object> arguments = new HashMap<>(2);
        //设置死信交换机
        arguments.put("x-dead-letter-exchange", Y_DEAD_LETTER_EXCHANGE);
        arguments.put("x-dead-letter-routing-key", "YD");
        return QueueBuilder
                .durable(QUEUE_B)
                .ttl(40000)
                .withArguments(arguments).build();
    }

    @Bean("queueD")
    public Queue dQueue() {
        return QueueBuilder.durable(DEAD_LETTER_QUEUE).build();
    }

    @Bean
    public Binding queueABindingX(@Qualifier("queueA") Queue queueA,
                                  @Qualifier("xExchange") DirectExchange xExchange) {
        return BindingBuilder.bind(queueA).to(xExchange).with("XA");
    }

    @Bean
    public Binding queueBBindingX(@Qualifier("queueB") Queue queueB,
                                  @Qualifier("xExchange") DirectExchange xExchange) {
        return BindingBuilder.bind(queueB).to(xExchange).with("XB");
    }

    @Bean
    public Binding queueDBindingY(@Qualifier("queueD") Queue queueD,
                                  @Qualifier("yExchange") DirectExchange yExchange) {
        return BindingBuilder.bind(queueD).to(yExchange).with("YD");
    }
}
