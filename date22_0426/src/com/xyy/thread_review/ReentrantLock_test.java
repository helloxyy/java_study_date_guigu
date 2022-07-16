package com.xyy.thread_review;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Administrator
 * @program: java_study_426
 * @description:
 * @date 2022-04-28 17:37:51
 */
class Test_Lock implements Runnable {
    private ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {
        try {
            lock.lock(); // 获取锁
            for (int i = 0; i < 100; i++) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        } finally {
            lock.unlock(); // 释放锁
        }
    }
}


public class ReentrantLock_test {
    public static void main(String[] args) {
        Thread t1 = new Thread(new Test_Lock(), "t1");
        Thread t2 = new Thread(new Test_Lock(), "t2");
        t1.start();
        t2.start();
    }
}
