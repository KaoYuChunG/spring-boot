package com.kao.task.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class ScheduledSevice {

//  可以點入註解裡查看如何給值
//  second,minute, hour, day of month, month, day of week
//  表達式  如 *(秒) *(分) *(時) *(日) *(月) MON-FRI(週一到週五)
//    @Scheduled(cron = "0 * * * * MON-SAT")
//    @Scheduled(cron = "0,1,2,3,4 * * * * MON-SAT")// enum
//    @Scheduled(cron = "0-4 * * * * MON-SAT")// 區間
//    @Scheduled(cron = "0/4 * * * * MON-SAT")//每四秒執行
//  ? 適用於衝突匹配用
//  星期可以用英文表示，也可以用數字表示0-7。如1-6(一到六)，而0和7都能表示週日
//  如 0 0 2-4 ? * 1#1 表示每個月的第一個週一早上二到四點期間，每個整點都執行一次
//  如 0 0 2 ? * 6L 每個月的最後一個週六早上二點執行一次
    public void hello() {

        System.out.println("hello....");
    }
}
