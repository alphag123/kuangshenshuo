package com.kuang.springboot09test.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class ScheduledService {

    //在一个特定的时间执行这个方法 Timer

    //cron表达式
    @Scheduled()
    public void hello(){
        System.out.println("hello,你被执行了");
    }

}
