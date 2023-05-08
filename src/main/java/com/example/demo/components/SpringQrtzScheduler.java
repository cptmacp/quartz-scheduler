package com.example.demo.components;

//
//import javax.sql.DataSource;
//
//import com.example.demo.models.SimpleJob;
//
//import jakarta.annotation.PostConstruct;
//import lombok.extern.slf4j.Slf4j;
//import org.quartz.JobDetail;
//import org.quartz.SimpleTrigger;
//import org.quartz.Trigger;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
//import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
//import org.springframework.boot.autoconfigure.quartz.QuartzDataSource;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.boot.jdbc.DataSourceBuilder;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.io.ClassPathResource;
//import org.springframework.scheduling.quartz.JobDetailFactoryBean;
//import org.springframework.scheduling.quartz.SchedulerFactoryBean;
//import org.springframework.scheduling.quartz.SimpleTriggerFactoryBean;
//import org.springframework.scheduling.quartz.SpringBeanJobFactory;
//
//import java.util.Properties;
//
//@Configuration
//@EnableAutoConfiguration
//@Slf4j
//public class SpringQrtzScheduler {
//
//    @Autowired
//    private ApplicationContext applicationContext;
//
//    @PostConstruct
//    public void init() {
//        log.info("Hello world from Spring...");
//    }
//
////    @Bean
////    public SpringBeanJobFactory springBeanJobFactory() {
////        AutoWiringSpringBeanJobFactory jobFactory = new AutoWiringSpringBeanJobFactory();
////        log.debug("Configuring Job factory");
////
////        jobFactory.setApplicationContext(applicationContext);
////        return jobFactory;
////    }
//
//    @Bean
//    public SchedulerFactoryBean scheduler() {
//
//        SchedulerFactoryBean schedulerFactory = new SchedulerFactoryBean();
//
//      //  schedulerFactory.setConfigLocation(new ClassPathResource("quartz.properties"));
//
//       // logger.debug("Setting the Scheduler up");
//      //  schedulerFactory.setJobFactory(springBeanJobFactory());
//      //  schedulerFactory.setJobDetails(job);
//      //  schedulerFactory.setTriggers(trigger);
//
//        // Comment the following line to use the default Quartz job store.
//        //schedulerFactory.setDataSource(quartzDataSource);
//
//
////                Properties p = new Properties();
////        p.put("org.quartz.scheduler.instanceName", "Scheduler_test");
////        p.put("org.quartz.threadPool.threadCount", "2");
//
//     //   scheduler.setQuartzProperties(p);
//
//        return schedulerFactory;
//    }
//
//
//}