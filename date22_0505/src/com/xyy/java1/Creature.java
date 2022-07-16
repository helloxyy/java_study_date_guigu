package com.xyy.java1;

import java.io.Serializable;

/**
 * @author Administrator
 * @program: java_study_date_guigu
 * @description:
 * @date 2022-05-08 15:03:29
 */
public class Creature<T> implements Serializable {
    private char gender;
    public double weight;

    private void breath(){
        System.out.println("生物呼吸");
    }

    private void eat(){
        System.out.println("生物吃东西");
    }
}
