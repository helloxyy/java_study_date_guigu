/**
 * @author Administrator
 * @program: java_study_date_guigu
 * @description:
 * @date 2022-06-13 19:10:30
 */
public class Exercise01 {
    public static void main(String[] args) {
        Thread01 thread01 = new Thread01(2,100000);
        Thread01 thread02 = new Thread01(100000,200000);
        thread01.start();
        thread02.start();

    }
}

class Thread01 extends Thread {
    private int m;
    private int n;

    public Thread01(int m, int n) {
        this.m = m;
        this.n = n;
    }

    @Override
    public void run() {
        int num = 0;
        for (int i = m; i <= n ; i++) {
            if(isPrime(i)){
                num++;
            }
        }
        System.out.println(m+"和"+n+"之间的素数是有"+num+"个");
    }

    //判断素数
    public boolean isPrime(int n) {
        if (n == 1) {
            return false;
        }
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

}


