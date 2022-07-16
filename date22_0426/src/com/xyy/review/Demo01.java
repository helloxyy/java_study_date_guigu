package com.xyy.review;

/**
 * @author Administrator
 * @program: java_study_426
 * @description:
 * @date 2022-05-01 15:10:46
 */
class Number01 extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + ":" + i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class Demo01 {
    public static void main(String[] args) {
        Number01 number01 = new Number01();
        number01.start();
    }
}
