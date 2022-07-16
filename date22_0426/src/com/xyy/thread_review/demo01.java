package com.xyy.thread_review;

/**
 * @author Administrator
 * @program: java_study_426
 * @description: just a review
 * @date 2022-04-26 17:14:56
 */
public class demo01 {
    public static void main(String[] args) {
        Thread01 t1 = new Thread01();
        Thread n1 = new Thread(t1);
        n1.start();
    }
}

class Thread01 implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + ":" + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}