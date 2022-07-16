package com.xyy.java2;

import org.junit.Test;

import java.util.Comparator;

/**
 * @author Administrator
 * @program: java_study_date_guigu
 * @description:
 * @date 2022-05-08 19:21:29
 */
interface Sum{
    int sum(int a, int b);
}

public class Lambdatest {

    public void test1() {
        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello World");
            }
        };
        r.run();
        Runnable r2 = () -> System.out.println("Hello World");
        r2.run();
    }
    public void test2() {
        Comparator<Integer> c = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return Integer.compare((Integer) o1, (Integer) o2);
            }
        };
        System.out.println(c.compare(1, 2));
        Comparator<Integer> c2 = Integer::compare;
        System.out.println(c2.compare(1, 2));
    }

    @Test
    public void test3(){
      Sum sum = (a, b) -> a + b;
      System.out.println(sum.sum(1, 2));
    }

}
