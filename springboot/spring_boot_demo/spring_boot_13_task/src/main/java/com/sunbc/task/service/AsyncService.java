package com.sunbc.task.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * Created on 2020-07-13
 *
 * @author sunbc
 * @Describe
 * @since
 */
@Service
public class AsyncService {

    @Async
    public void hello(){
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("数据处理中...");
    }
}
