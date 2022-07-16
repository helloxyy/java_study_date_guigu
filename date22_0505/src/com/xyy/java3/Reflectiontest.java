package com.xyy.java3;

import com.xyy.java1.Person;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author Administrator
 * @program: java_study_date_guigu
 * @description:
 * @date 2022-05-08 17:40:13
 */
public class Reflectiontest {

    @Test
    public void test01() throws NoSuchFieldException, InstantiationException, IllegalAccessException {
        Class<Person> clazz = Person.class;
        // 创建运行时类的对象
        Person person = clazz.newInstance();

        // 获取指定的属性
        // 通常不采用
        Field id = clazz.getField("id");

        /*
        设置当前属性
        set() param1: 当前属性的对象 param2: 当前属性的值
         */
        id.set(person, 100);
        /*
        获取当前属性
        get() param1: 当前属性的对象
         */
        System.out.println(id.get(person));
    }

    @Test
    public void test02() throws InstantiationException, IllegalAccessException, NoSuchFieldException, NoSuchMethodException, InvocationTargetException {
        Class<Person> clazz = Person.class;
        Person p = clazz.newInstance();
        Field name = clazz.getDeclaredField("name");
        name.setAccessible(true);
        name.set(p, "张三");
        System.out.println(name.get(p));

        // 获取方法的名称
        Method method = clazz.getDeclaredMethod("show", String.class);
        method.setAccessible(true);
        method.invoke(p, "china");

    }

    public void test03() throws InstantiationException, IllegalAccessException, NoSuchFieldException, NoSuchMethodException, InvocationTargetException {
        Class<Person> clazz = Person.class;
        Constructor constructor = clazz.getDeclaredConstructor(String.class, int.class);
        constructor.setAccessible(true);
        Person p = (Person) constructor.newInstance("张三", 20);

    }

}
