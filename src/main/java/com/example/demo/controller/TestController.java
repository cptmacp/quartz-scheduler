package com.example.demo.controller;


import com.cronutils.builder.CronBuilder;
import com.cronutils.mapper.CronMapper;
import com.cronutils.model.Cron;
import com.cronutils.model.definition.CronDefinition;
import com.cronutils.model.definition.CronDefinitionBuilder;
import com.cronutils.model.time.ExecutionTime;
import com.example.demo.components.BaseTask;
import com.example.demo.models.SimpleJob;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.*;
import java.util.concurrent.CompletableFuture;

import static com.cronutils.model.field.expression.FieldExpressionFactory.always;
import static com.cronutils.model.field.expression.FieldExpressionFactory.on;
import static org.quartz.TriggerBuilder.newTrigger;

@RepositoryRestController
@Slf4j
public class TestController {

//    @Autowired
//    private Scheduler scheduler;


    @Autowired
    private SchedulerFactoryBean schedulerFactoryBean;

//    Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
//
//    public TestController() throws SchedulerException {
//
//        scheduler.start();
//    }

    // and start it off


    @PostMapping("/temp/all")
    public ResponseEntity<Object> deleteAll(@RequestBody Map<String, Object> periodicInterval) throws ParseException, SchedulerException {


        String crone = "0/5 * * * * ?";


        CronExpression cron = new CronExpression(crone);


        Date today = new Date();


        String minute = periodicInterval.get("minute").toString();

        String hour = periodicInterval.get("hour").toString();

        String dayOfMonth = periodicInterval.get("dayOfMonth").toString();

        String month = periodicInterval.get("month").toString();

        String dayOfWeek = periodicInterval.get("dayOfWeek").toString();


        CronDefinition cronDefinition =
                CronDefinitionBuilder.defineCron()
                        .withMinutes().and()
                        .withHours().and()
                        .withDayOfMonth().and()
                        .withMonth().and()
                        .withDayOfWeek().and()
                        .instance();


        Cron crosn = CronBuilder.cron(cronDefinition)
                .withMinute(minute.equals("*") ? always() : on(Integer.parseInt(minute)))
                .withHour(hour.equals("*") ? always() : on(Integer.parseInt(hour)))
                .withDoM(dayOfMonth.equals("*") ? always() : on(Integer.parseInt(dayOfMonth)))
                .withMonth(month.equals("*") ? always() : on(Integer.parseInt(month)))
                .withDoW(dayOfWeek.equals("*") ? always() : on(Integer.parseInt(dayOfWeek)))
                .instance();


        CronMapper cronMapper = CronMapper.sameCron(cronDefinition);

        Cron converted = cronMapper.map(crosn);

        System.out.print("\n\n localdattime" + converted);


        String cronAsString = crosn.asString();

        System.out.print("\n\n localdattime" + cronAsString);

        // Get date for last execution
        ZonedDateTime now = ZonedDateTime.now();

        ExecutionTime executionTime = ExecutionTime.forCron(crosn);


        Optional<ZonedDateTime> lastExecution = executionTime.lastExecution(now);

// Get date for next execution
        Optional<ZonedDateTime> nextExecution = executionTime.nextExecution(now);


        Map<String, Object> bb = new java.util.HashMap<>();

        bb.put("cron", cronAsString);

        bb.put("lastExecution", lastExecution.get());

        //  components.submitJob();

        // compoentsss.start();

        //  componentss.onStartup();

        return ResponseEntity.ok(bb);


    }


    @GetMapping("/temp/all2")
    @Transactional
    public ResponseEntity<Object> daaa() throws ParseException, SchedulerException {

        Scheduler scheduler = schedulerFactoryBean.getScheduler();


        JobDetail job = JobBuilder.newJob(SimpleJob.class)
                .withIdentity("SimpleJob", "group1")
                .usingJobData("param", "value") // add a parameter
                // .withIdentity("SimpleJob", "group1")
                .build();

        Date afterFiveSeconds = Date.from(LocalDateTime.now().plusSeconds(5)
                .atZone(ZoneId.systemDefault()).toInstant());

        Trigger trigger = newTrigger()
                .withIdentity("trigger1", "group1")
                //.startAt(afterFiveSeconds)
                .startNow()
                .build();


        JobKey jobKey = JobKey.jobKey("myNewJob", "myJobGroup");

        JobDetail job2 = JobBuilder.newJob(SimpleJob.class).withIdentity(jobKey)

                .storeDurably().build();


        if (scheduler.checkExists(job2.getKey())) {

            //  log.info("Job exist , skip");

        } else {


            // log.info("Scheduling the Job!");

            //schedulerFactoryBean.getScheduler().scheduleJob(job2, trigger);


            //  scheduler.start();

        }


        scheduler.addJob(job2, true);

        // schedulerFactoryBean.getScheduler().scheduleJob(job2, trigger);

        System.out.print("n\n Add job");


        //schedulerFactoryBean.getScheduler().triggerJob(jobKey);

        return ResponseEntity.ok(jobKey);


    }


    @GetMapping("/temp/all3")
    public ResponseEntity<Object> dassaa() throws ParseException, SchedulerException {

        Scheduler scheduler = schedulerFactoryBean.getScheduler();

        JobKey jobKey = JobKey.jobKey("myNewJob", "myJobGroup");


        System.out.print("n\n trigger job");

        scheduler.triggerJob(jobKey);


        return ResponseEntity.ok("");
    }

    @GetMapping("/temp/all4")
    public ResponseEntity<Object> dassa3a() throws ParseException, SchedulerException {


//        Scheduler scheduler = schedulerFactoryBean.getScheduler();
//
//        for (String groupName : scheduler.getJobGroupNames()) {
//
//            for (JobKey jobKey : scheduler.getJobKeys(GroupMatcher.jobGroupEquals(groupName))) {
//
//                String jobName = jobKey.getName();
//                String jobGroup = jobKey.getGroup();
//
//                //get job's trigger
//                List<Trigger> triggers = (List<Trigger>) scheduler.getTriggersOfJob(jobKey);
//                Date nextFireTime = triggers.get(0).getNextFireTime();
//
//                System.out.println("[jobName] : " + jobName + " [groupName] : "
//                        + jobGroup + " - " + nextFireTime);
//
//            }
//
//
//        }


        return ResponseEntity.ok("");
    }


    @GetMapping("/temp/all4")
    public ResponseEntity<Object> dassaaa() throws ParseException, SchedulerException {

        BaseTask baseTask = null;


        CompletableFuture<List<String>> a = CompletableFuture.supplyAsync(() -> {

            return baseTask.perform2("aa");


        });

        List<String> aa = new ArrayList<>();

        a.complete(aa);


        return ResponseEntity.ok("");
    }

}
