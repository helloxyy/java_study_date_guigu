package com.xyy.execute;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Administrator
 * @program: java_study_426
 * @description:
 * @date 2022-04-28 16:44:11
 */
class Add_Executor_01 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("Add_Executor_01: " + i);
        }
    }
}


public class Executor_01 {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        executorService.execute(new Add_Executor_01()); // 实现 Runnable 接口
    }
}
