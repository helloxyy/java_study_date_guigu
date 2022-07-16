package com.xyy.review;

/**
 * @author Administrator
 * @program: java_study_426
 * @description:
 * @date 2022-05-01 15:13:13
 */
class Number02 implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName()+"-->"+i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class Demo02 {
    public static void main(String[] args) {
        Number02 number02 = new Number02();
        Thread thread1 = new Thread(number02,"线程1");
        Thread thread2 = new Thread(number02,"线程2");
        thread1.start();
        thread2.start();
    }
}
