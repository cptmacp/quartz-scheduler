package com.example.demo.components;


import com.example.demo.models.SimpleJob;
import lombok.extern.slf4j.Slf4j;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

@Component
@EnableScheduling
@Slf4j
public class Components {

//    @Bean()
//    public Scheduler scheduler(SchedulerFactoryBean factory) throws SchedulerException {
//        Scheduler scheduler = factory.getScheduler();
//        scheduler.start();
//        return scheduler;
//    }




//    @Bean
//    public void startQuartzScheduler() throws SchedulerException {
//
//        // Init Quartz scheduler
//
//        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
//
//        Scheduler scheduler = schedulerFactory.getScheduler();
//
//
//        scheduler.start();
//
//    }


//    @Bean
//    public CommandLineRunner run(Scheduler scheduler) {
//        return (String[] args) -> {
//            JobDetail job = JobBuilder.newJob(SimpleJob.class)
//                    .usingJobData("param", "value") // add a parameter
//                    .build();
//
//            Date afterFiveSeconds = Date.from(LocalDateTime.now().plusSeconds(5)
//                    .atZone(ZoneId.systemDefault()).toInstant());
//
//
//           // System.out.print("\n\n localdattime" + LocalDateTime.now());
//
//            String crone = "0/1 * * * * ?";
//
//
//            CronExpression cron = new CronExpression(crone);
//
//
//            Date today = new Date();
//
//            Date previousExecution = cron.getTimeBefore(today);
//
//
//            Trigger trigger = TriggerBuilder.newTrigger()
//                   // .startAt(afterFiveSeconds)
//                    .startNow()
//                    .withSchedule(CronScheduleBuilder.cronSchedule(crone))
//                    .build();
//
//            scheduler.scheduleJob(job, trigger);
//        };
//    }

    public void submitJob()   {

        try {


            JobDetail job = JobBuilder.newJob(SimpleJob.class)
                    .usingJobData("param", "value") // add a parameter
                    .build();

            Date afterFiveSeconds = Date.from(LocalDateTime.now().plusSeconds(5)
                    .atZone(ZoneId.systemDefault()).toInstant());


            // System.out.print("\n\n localdattime" + LocalDateTime.now());

            String crone = "0/1 * * * * ?";


            CronExpression cron = new CronExpression(crone);


            Date today = new Date();

            Date previousExecution = cron.getTimeBefore(today);


            Trigger trigger = TriggerBuilder.newTrigger()
                    // .startAt(afterFiveSeconds)
                    .startNow()
                    .withSchedule(CronScheduleBuilder.cronSchedule(crone))
                    .build();

         //   schedulerFactoryBean.getScheduler().scheduleJob(job, trigger);


        } catch (Exception e) {

            log.error("Error in submitJob", e);

        }

    }


}
