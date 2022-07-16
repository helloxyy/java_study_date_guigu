package com.xyy.thread_test;

/**
 * @author Administrator
 * @program: java_study_426
 * @description: 生产者消费者模型
 * @date 2022-04-26 21:08:30
 */
class Clerk{
    private int productNum = 0;

    //生产产品
    public synchronized void  produceProduct()  {
        if(productNum < 20) {
            productNum++;
            System.out.println("生产第" + (productNum) + "个产品");
            notify();
        }else{
            System.out.println("生产已满");
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    //消费产品
    public synchronized void consumeProduct() {
        if(productNum > 0) {
            System.out.println("消费第" + (productNum--) + "个产品");
            notify();
        }else{
            System.out.println("消费已空");
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

// 生产者
class Producer extends Thread{
    private Clerk clerk;
    public Producer(Clerk clerk){
        this.clerk = clerk;
    }

    @Override
    public void run() {
        System.out.println("生产者开始生产");
        while(true){
//            try {
////                Thread.sleep(1);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            clerk.produceProduct();

        }
    }
}

// 消费者
class Comsumer extends Thread{
    private Clerk clerk;
    public Comsumer(Clerk clerk){
        this.clerk = clerk;
    }

    @Override
    public void run() {
        System.out.println("消费者开始消费");
        while(true){
//            try {
//               Thread.sleep(1);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }

       clerk.consumeProduct();


        }
    }
}

public class Test {
    public static void main(String[] args) {
        Clerk clerk = new Clerk();
        Producer producer01 = new Producer(clerk);
        producer01.setName("生产者01");
        Comsumer comsumer01 = new Comsumer(clerk);
        comsumer01.setName("消费者01");
        Comsumer comsumer02 = new Comsumer(clerk);
        comsumer02.setName("消费者02");
        producer01.start();
        comsumer01.start();
        comsumer02.start();

    }
}
