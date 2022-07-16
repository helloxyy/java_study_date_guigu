package com.xyy.java2;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * @author Administrator
 * @program: java_study_date_guigu
 * @description:
 *              1. consumer<T>      消费型 有参数 无返回值            void accept(T t)
 *              2. Supplier<T>      供给型 无参数 有返回值            T get()
 *              3. Function<T,R>    参数类型 T 返回值类型 R          R apply(T t)
 *              4. Predicate<T>     参数类型 T 返回值类型 boolean        boolean test(T t)
 * @date 2022-05-09 15:16:12
 */
public class LambdaTest1 {

    @Test
    public void test1(){
        happyTime(400.0,money -> System.out.println("收到"+money+"元"));
    }

    public void happyTime(double money, Consumer<Double> consumer){
        consumer.accept(money);
    }

    @Test
    public void test2(){
        List<String> list = Arrays.asList("张三","李四","王五","赵五");
        List<String> filterList = filterString(list,str -> str.contains("五"));
        System.out.println(filterList);
    }


    // 根据指定的规则，返回一个新的集合
    public List<String> filterString(List<String> list, Predicate<String> predicate){
        ArrayList<String> filterList = new ArrayList<>();
        for (String str : list) {
            if (predicate.test(str)) {
                filterList.add(str);
            }
        }
        return filterList;
    }
}
