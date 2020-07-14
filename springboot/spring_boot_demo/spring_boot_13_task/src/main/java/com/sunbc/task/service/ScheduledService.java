package com.sunbc.task.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * Created on 2020-07-13
 *
 * @author sunbc
 * @Describe
 * @since
 */
@Service
public class ScheduledService {

    @Scheduled(cron = "0 * * ? * MON-SAT")
    public void hello(){
        System.out.println("hello...");
    }
}
