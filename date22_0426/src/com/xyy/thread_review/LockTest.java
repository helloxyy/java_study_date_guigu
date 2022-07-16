package com.xyy.thread_review;

import java.awt.*;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Administrator
 * @program: java_study_426
 * @description: 解决线程安全问题的方式三
 * @date 2022-04-26 19:33:20
 */

/**
 * synchronized关键字和ReentrantLock的区别
 *1. 二者都可以保证线程安全，但是synchronized关键字更加简单，而且更加灵活，
 * 2. synchronized关键字会自动释放同步监视器
 * ReentruenLock不会自动释放同步监视器，需要手动释放 lock.unlock()
 *
*/
class Windows01 implements Runnable{
    private int count = 100;

    // 创建对象
    private ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {

        try{
            //调用lock.lock()方法，获取锁 保证线程安全
            lock.lock();

            while (true){
                if (count > 0){
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println(Thread.currentThread().getName() + ":" + count);
                    count--;
                }else{
                    break;
                }
            }
        }finally {
            //调用lock.unlock()方法，释放锁
            lock.unlock();
        }

    }
}

public class LockTest {
    public static void main(String[] args) {
        Windows01 windows01 = new Windows01();
        Thread thread1 = new Thread(windows01);
        Thread thread2 = new Thread(windows01);
        thread1.start();
        thread2.start();


    }
}
