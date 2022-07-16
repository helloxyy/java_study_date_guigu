package com.xyy.java1;

import java.nio.file.Path;

/**
 * @author Administrator
 * @program: java_study_date_guigu
 * @description:
 * @date 2022-05-08 15:03:15
 */
@MyAAnnotation(value = "Person")
public class Person extends Creature<String> implements Comparable<String>,MyInterface {
    private String name;
    int age;
    public int id;

    public Person() {


    }

    private Person(String name){
        this.name = name;
    }

    Person(String name,int age) {

    }

    @MyAAnnotation
    private String show(String nation){
        System.out.println("国家："+nation);
        return nation;
    }

    public String display(String interests){
        return interests;
    }


    @Override
    public int compareTo(String o) {
        return 0;
    }

    @Override
    public void info() {
        System.out.println("person");
    }
}
