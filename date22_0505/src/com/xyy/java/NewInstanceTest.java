package com.xyy.java;

import org.junit.Test;

import java.util.Random;

/**
 * @author Administrator
 * @program: java_study_date_guigu
 * @description:
 * @date 2022-05-05 19:45:24
 */
public class NewInstanceTest {
    @Test
    public void test2() throws InstantiationException, IllegalAccessException {
        Class<Person> clazz = Person.class;
        // 运行时类必须是空参构造器
        // 注意访问权限 通常是public
//        Person obj = (Person) clazz.newInstance();
//        System.out.println(obj);
    }

    @Test
    public void test1() throws Exception {
        int num= new Random().nextInt(3);
        String classpath = switch (num) {
            case 0 -> "com.xyy.java.Person";
            case 1 -> "com.xyy.java.Person";
            case 2 -> "com.xyy.java.Person";
            default -> "";
        };
        Object obj =  getInstance(classpath);
        System.out.println(obj);
    }

    public Object getInstance(String classPath) throws Exception{
        Class<?> clazz = Class.forName(classPath);
        return clazz.newInstance();
    }

}
