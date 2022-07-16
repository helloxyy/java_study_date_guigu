package com.xyy.thread_review;

/**
 * @author Administrator
 * @program: java_study_426
 * @description:
 * @date 2022-04-28 17:16:42
 */

class Test_Syn_Func extends Thread {
    @Override
    public void run() {
        synchronized (this) {
            for (int i = 0; i < 100; i++) {
                System.out.println(Thread.currentThread().getName() + " " + i);
            }
        }
    }
}



public class Synchornized_funcTest {
    public static void main(String[] args) {
        Thread t1 = new Test_Syn_Func();
        t1.start();
    }
}
