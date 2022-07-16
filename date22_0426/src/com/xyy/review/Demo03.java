package com.xyy.review;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author Administrator
 * @program: java_study_426
 * @description:
 * @date 2022-05-01 15:21:42
 */
class Number03 implements Callable {

    private Integer sum = 0;
    @Override
    public Integer call() throws Exception {
        for (int i = 0; i <=100 ; i++) {
            System.out.println(Thread.currentThread().getName()+"--"+i);
            Thread.sleep(500);
            sum += i;
        }
        return sum;
    }
}

public class Demo03 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<Integer> task = new FutureTask<>(new Number03());
        new Thread(task,"线程1").start();
        Integer result = task.get();
        System.out.println("the sum is "+result);
    }
}
