package com.example.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author yunshuaiwei
 * @version 1.0
 * @date 2023/3/27 11:11
 */
@Component
public class MySpringTask {

    @Scheduled(cron = "0/5 * * * * ?")
    public void springTaskTest() {
        System.out.println("spring task run......");
    }
}
