package com.xyy.callable_;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * @author Administrator
 * @program: java_study_426
 * @description:
 * @date 2022-04-28 16:39:58
 */
class Add implements Callable {
    @Override
    public Object call() throws Exception {
        int sum = 0;
        System.out.println("线程" + Thread.currentThread().getName() + "开始执行");
        for (int i = 0; i < 100; i++) {
            System.out.println("i=" + i);
            sum += i;
        }
        return sum;
    }
}

public class Callable_01 {
    public static void main(String[] args) {
        Add add = new Add();
        FutureTask futureTask = new FutureTask(add);
        new Thread(futureTask, "线程A").start();
    }
}
