package com.xyy.java3;

import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.nio.charset.StandardCharsets;

/**
 * @author Administrator
 * @program: java_study_date_guigu
 * @description:
 * @date 2022-05-08 18:39:04
 */
interface Human{
    String getBelief();

    void eat(String food);
}

class Superman implements Human{

    @Override
    public String getBelief() {
        return "I'm a superman";
    }
    @Override
    public void eat(String food){
        System.out.println("I'm eating "+food);
    }
}

/*
q1 如何根据加载到内存的被代理类，动态创建一个代理类，并且实现代理类的接口？
q2 当通过代理类的对象调用方法时，是否会自动调用被代理类的方法？
 */
class Proxys {

    // 被代理对象
    public static Object getProxyInstance(Object target) {
        MyInvocationHandler handler = new MyInvocationHandler();
        handler.bind(target);
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), handler);
    }

}

class MyInvocationHandler implements InvocationHandler {
    public void bind(Object target) {
        // 被代理对象
    }
    @Override
    // 当我们通过代理类对象调用方法时，会自动调用该方法 inkov()
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return null;
    }
}

public class ProxyTest {
    public static void main(String[] args) {
        Superman superman = new Superman();
        Human human = (Human) Proxys.getProxyInstance(superman);
        String belief = human.getBelief();
        System.out.println(belief);
        human.eat("banana");

    }
}
