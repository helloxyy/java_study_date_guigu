package com.xyy.java3;

import com.xyy.java1.Person;
import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * @author Administrator
 * @program: java_study_date_guigu
 * @description:
 * @date 2022-05-08 17:09:20
 */
public class MethodTest {

    @Test
    public void test1(){
        Class clazz = Person.class;
        Method[] method = clazz.getMethods();
        for (Method m : method) {
            System.out.println(m);

            Annotation[] annos =  m.getAnnotations();
            for (Annotation anno : annos) {
                System.out.println(anno);
            }

        }


    }
}
