package com.xyy.thread_review;

/**
 * @author Administrator
 * @program: java_study_426
 * @description: wait notify notifyAll 使用范围在同步代码块中
 * @date 2022-04-26 20:46:32
 */

/**
 * wait()方法 和 sleep()方法的区别
 * 两个都会使当前线程进入阻塞状态，直到被唤醒
 * 1.wait()方法是在当前线程中等待，而sleep()方法是在当前线程中休眠
 * 2.声明位置不同：wait()方法是在同步代码块中声明，而sleep()方法是在Thread中声明
 * 3.sleep 不会释放锁，而wait会释放锁（同步监视器）
 * */
public class Demo02 {
    public static void main(String[] args) {
        Number number = new Number();
        Thread thread1 = new Thread(number);
        Thread thread2 = new Thread(number);
        thread1.start();
        thread2.start();
    }
}

class Number implements Runnable{
    private int number = 1;
    @Override
    public void run() {

        while (true){
            synchronized (this){
                notify(); // 唤醒
                if (number <= 100){
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println(Thread.currentThread().getName() + ":" + number);
                    number++;
                    try {
                        wait(); // 进入阻塞
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }else{
                    break;
                }

            }
            // System.out.println(Thread.currentThread().getName() + ":" + number++);

        }
    }
}