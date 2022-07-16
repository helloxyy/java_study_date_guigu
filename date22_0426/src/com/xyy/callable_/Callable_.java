package com.xyy.callable_;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author Administrator
 * @program: java_study_426
 * @description: call方法有返回值，返回值类型为Callable<T>
 * @date 2022-04-27 11:21:54
 */


class NumThread implements Callable {
    @Override
    public Object call() throws Exception {
        int sum = 0;
        for (int i = 0; i < 100; i++) {
            System.out.println("i=" + i);
            sum += i;
        }
        return sum;
    }
}


public class Callable_ {
    public static void main(String[] args) {
        NumThread numThread = new NumThread();
        FutureTask<Integer> ift = new FutureTask<Integer>(numThread);
        new Thread(ift).start();
        try {
            // get()返回值就是FutureTask的call方法的返回值
            Integer sum = ift.get();
            System.out.println("sum=" + sum);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
