package com.learn.base.java.jvm.bytecode;

/**
 * @program: learn
 * @description: 装箱测试
 * @author: Elliot
 * @create: 2020-03-03 21:19
 **/
public class IntegerCacheTest {


    public static void test1(){
        int i = 1;
        System.out.println(i);
    }

    public static void test2(){
        int i = 1;
        System.out.printf("%d", i);
    }
}
