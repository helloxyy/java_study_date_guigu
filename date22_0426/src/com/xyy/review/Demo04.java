package com.xyy.review;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Administrator
 * @program: java_study_426
 * @description:
 * @date 2022-05-01 15:25:35
 */

public class Demo04 {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        executorService.execute(new Number01()); // 执行Runnable接口的实现类
        executorService.execute(new Number02()); // 执行Runnable接口的实现类
        executorService.submit(new Number03()); // 执行Callable接口的实现类\
        executorService.shutdown(); // 关闭线程池
    }
}
