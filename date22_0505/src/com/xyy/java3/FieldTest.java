package com.xyy.java3;

import com.xyy.java1.Person;
import org.junit.Test;

import java.lang.reflect.Field;

/**
 * @author Administrator
 * @program: java_study_date_guigu
 * @description: 获取运行时类的属性结构
 * @date 2022-05-08 15:20:58
 */
public class FieldTest {

    @Test
    public void test1(){
        Class clazz = Person.class;

        // 获取属性结构

        // getFields() 获取及其父类的public的属性
        Field[] fields = clazz.getFields();
        for (Field field : fields) {
            System.out.println(field);
        }
        //getDeclaredFields() 获取自己声明的属性 不包含父类的属性
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field field : declaredFields) {
            System.out.println(field);
        }

    }

    @Test
    public void test2(){
        Class clazz = Person.class;
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field field : declaredFields) {
            // 权限修饰符
            System.out.print(field.getModifiers()+" ");
            // 数据类型
            System.out.print(field.getType()+" ");
            // 属性名称
            System.out.println(field.getName());

            System.out.println();
        }

    }
}
