package com.xyy.execute;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Administrator
 * @program: java_study_426
 * @description:
 * @date 2022-04-27 11:48:41
 */
class Number implements Runnable {
    private int number = 100;


    @Override
    public void run() {
        while (number > 0) {
            System.out.println(Thread.currentThread().getName() + ":" + number--);
        }
    }
}



public class Executor_ {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        executorService.execute(new Number()); // 适用于Runnable
       // executorService.submit(); // 适用于Callable

        executorService.shutdown();
    }
}
