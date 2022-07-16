package com.xyy.ObjectStream;

import java.io.Serializable;

/**
 * @author Administrator
 * @program: java_study_426
 * @description:
 * @date 2022-04-28 19:10:27
 */

/*
* 1.需要实现Serializable
* 2.public static final long serialVersionUID = 15215L;
* */
public class Person implements Serializable {
    private String name;
    private int age;

    //序列翻转号
    public static final long serialVersionUID = 15215L;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
