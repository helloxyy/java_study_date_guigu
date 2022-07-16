package com.xyy.java;

import org.junit.Test;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * @author Administrator
 * @program: java_study_date_guigu
 * @description:
 * @date 2022-05-05 15:31:02
 */
public class ReflectionTest {


    // 反射之前对Person类进行操作
    @Test
    public void test1() {
        Person person = new Person("小花", 18);
        System.out.println(person);
    }

    // 反射之后对Person类进行操作
    @Test
    public void test2() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        Class<Person> clazz = Person.class; // 获取Person类
        Constructor<Person> cons = clazz.getConstructor(String.class,int.class);// 获取Person类的构造方法

//        Person obj = cons.newInstance("小花", 18); // 创建对象
        Person person = new Person(); // 强制转换
        System.out.println(person.toString());

        // 反射获取类的属性
        Field age = clazz.getDeclaredField("age");
        age.set(person, 10);
        System.out.println(person.toString());

        // 反射获取类的方法
        Method show = clazz.getDeclaredMethod("show");
        show.invoke(person);

        // 反射获取类私有内容

        // 私有构造器
        Constructor<Person> cons1 = clazz.getDeclaredConstructor(String.class);
        cons1.setAccessible(true);
        Person person1 =new Person();
        System.out.println(person1.toString());

        // 私有属性
        Field name = clazz.getDeclaredField("name");
        name.setAccessible(true);
        name.set(person1, "Hanmeimei");
        System.out.println(person1.toString());

        // 私有方法
        Method show1 = clazz.getDeclaredMethod("showNation", String.class);
        show1.setAccessible(true);
        show1.invoke(person1, "China");


    }

    // 加载在内存中的运行时类 会被缓存起来 不会每次都去加载
    @Test
    public void test03() throws ClassNotFoundException {
        // 方式一  调用运行时类的属性 .class
        Class<Person> clazz = Person.class;
        System.out.println(clazz);

        // 方式二 通过运行时类的对象
        Person person = new Person("小花", 18);
        Class<? extends Person> clazz2 = person.getClass();
        System.out.println(clazz2);

        //方式三 通过class的静态方法 forName()
        Class<?> clazz3  =  Class.forName("com.xyy.java.Person");
        System.out.println(clazz3);

        System.out.println((clazz == clazz2));

        // 方式四 使用类的加载器
        ClassLoader classLoader = clazz.getClassLoader();
        Class<?> clazz4 = classLoader.loadClass("com.xyy.java.Person");
        System.out.println(clazz4);

    }

    @Test
    public void test01() throws IOException {

        Properties properties = new Properties();
//        FileInputStream fileInputStream = new FileInputStream();
//        properties.load(fileInputStream);

        ClassLoader classLoader = ReflectionTest.class.getClassLoader();
        InputStream is = classLoader.getResourceAsStream("jdbc.properties");
        properties.load(is);



        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        System.out.println(user + "," + password);

    }

}
