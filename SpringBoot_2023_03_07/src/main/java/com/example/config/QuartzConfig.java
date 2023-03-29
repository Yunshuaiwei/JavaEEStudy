package com.example.config;

import com.example.task.MyQuartz;
import org.quartz.*;
import org.springframework.context.annotation.Bean;

/**
 * @author yunshuaiwei
 * @version 1.0
 * @date 2023/3/27 10:56
 */
//@Configuration
public class QuartzConfig {

    @Bean
    public JobDetail printJobDetail() {
        //绑定具体的工作
        return JobBuilder.newJob(MyQuartz.class).storeDurably().build();
    }

    @Bean
    public Trigger printJovTrigger() {
        ScheduleBuilder schedBuilder = CronScheduleBuilder.cronSchedule("0/5 * * * * ?");
        //绑定工作明细
        return TriggerBuilder.newTrigger().forJob(printJobDetail()).withSchedule(schedBuilder).build();
    }
}
