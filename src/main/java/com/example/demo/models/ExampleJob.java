package com.example.demo.models;

//import org.quartz.JobDataMap;
//import org.quartz.JobExecutionContext;
//import org.quartz.JobExecutionException;
//import org.springframework.scheduling.quartz.QuartzJobBean;
//
//import java.text.MessageFormat;
//
//public class ExampleJob extends QuartzJobBean {
//
//    private int timeout;
//
//    /**
//     * Setter called after the ExampleJob is instantiated
//     * with the value from the JobDetailFactoryBean (5)
//     */
//    public void setTimeout(int timeout) {
//        this.timeout = timeout;
//    }
//
//    protected void executeInternal(JobExecutionContext ctx) throws JobExecutionException {
//
//        JobDataMap dataMap = ctx.getJobDetail().getJobDataMap();
//        String param = dataMap.getString("param");
//
//        System.out.println("ExampleJob start: " + ctx.getFireTime() + " param: " + param);
//        System.out.println(MessageFormat.format("Job: {0}; Param: {1}; Thread: {2}",
//                getClass(), param, Thread.currentThread().getName()));
//
//
//        // do the actual work
//    }
//
//}