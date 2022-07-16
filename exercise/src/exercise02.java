/**
 * @author Administrator
 * @program: java_study_date_guigu
 * @description:
 * @date 2022-06-13 20:05:29
 */
public class exercise02 {
    private static int j = 0;

    private synchronized static void add() {
        j++;
        System.out.println(Thread.currentThread().getName()+" j="+j);
    }

    private synchronized static void sub() {
        j--;
        System.out.println(Thread.currentThread().getName()+" j="+j);
    }

    static class Thread01 implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                add();
            }
        }
    }

    static class Thread02 implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                sub();
            }
        }
    }

    public static void main(String[] args) {
        Thread01 thread01 = new Thread01();
        Thread02 thread02 = new Thread02();
        Thread t1 = new Thread(thread01);
        Thread t2 = new Thread(thread01);
        Thread t3 = new Thread(thread02);
        Thread t4 = new Thread(thread02);
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}


