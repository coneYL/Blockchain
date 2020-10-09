package com.coneyang.java;

import java.sql.SQLOutput;
import java.util.List;

/**
 * @author YangLei
 * @version 1.0.0.1
 * @since 2020/10/9 10:09
 */
public class HelloClass implements HelloInteface {

    @Override
    public void sayHello(String name) {
        System.out.println(name+ " said hello to you !");
    }

    public static void main(String[] args) {
        HelloInteface helloInteface = new HelloClass();
        helloInteface.sayHello("zhangsan");
        HelloInteface.say();
    }
}
