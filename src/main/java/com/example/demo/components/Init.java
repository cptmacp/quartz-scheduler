package com.example.demo.components;

import lombok.extern.slf4j.Slf4j;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.scheduling.quartz.SpringBeanJobFactory;
import org.springframework.stereotype.Component;

import java.util.Properties;


@Component
@Slf4j
public class Init {

//    @Autowired
//    private ApplicationContext applicationContext;
//
//
//
//    @Bean
//    public SpringBeanJobFactory springBeanJobFactory() {
//        AutoWiringSpringBeanJobFactory jobFactory = new AutoWiringSpringBeanJobFactory();
//        log.debug("Configuring Job factory");
//
//        jobFactory.setApplicationContext(applicationContext);
//        return jobFactory;
//    }
//
//
//    @Bean
//    public SchedulerFactoryBean scheduler() throws SchedulerException {
//
//     //   SchedulerFactoryBean factory = new SchedulerFactoryBean();
//
//
//        SchedulerFactoryBean schedulerFactory  = new SchedulerFactoryBean();
//
//
//      //  scheduler.setApplicationContextSchedulerContextKey("applicationContext");
//
//        //scheduler.setDataSource(dataSource);
//        //scheduler.setAutoStartup(true);
//       // scheduler.setWaitForJobsToCompleteOnShutdown(true);
//
////        Properties p = new Properties();
////        p.put("org.quartz.scheduler.instanceName", "Scheduler_test");
////        p.put("org.quartz.threadPool.threadCount", "2");
////
////        scheduler.setQuartzProperties(p);
//
//    //    schedulerFactory.setJobFactory(springBeanJobFactory());
//
//        return schedulerFactory ;
//    }


}