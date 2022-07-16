package com.xyy.ObjectStream;

import org.junit.Test;

import java.io.*;

/**
 * @author Administrator
 * @program: java_study_426
 * @description:
 * @date 2022-04-28 18:51:35
 */


public class ObjectInoutOutputStreamTest {
    public static void main(String[] args) {

    }
    @Test
    public void test() throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("E:\\study Filecourse\\java\\java_study_426\\date22_0426\\src\\com\\xyy\\ObjectStream\\object01.dat"));
        oos.writeObject(new Person("张三",18));
        oos.flush();
        oos.close();

    }

    @Test
    public void test2() throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("E:\\study Filecourse\\java\\java_study_426\\date22_0426\\src\\com\\xyy\\ObjectStream\\object01.dat"));
        Object obj = ois.readObject();
        System.out.println(obj);
        ois.close();
    }
}
