package com.example.demo;

import com.example.demo.models.SimpleJob;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;


@Component
public class Componentss {


   // @Bean
    public void onStartup() throws SchedulerException {

        System.out.print("\n\n\\n aaaaaaaaaaa");
        JobDetail job = JobBuilder.newJob(SimpleJob.class)
                .usingJobData("param", "value") // add a parameter
                .build();

        Date afterFiveSeconds = Date.from(LocalDateTime.now().plusSeconds(5)
                .atZone(ZoneId.systemDefault()).toInstant());

        Trigger trigger = TriggerBuilder.newTrigger()
                .startAt(afterFiveSeconds)
                .build();

        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
        Scheduler scheduler = schedulerFactory.getScheduler();
        scheduler.start();
        scheduler.scheduleJob(job, trigger);
    }
}
