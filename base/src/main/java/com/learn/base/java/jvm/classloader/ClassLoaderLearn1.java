package com.learn.base.java.jvm.classloader;

/**
 * @program: learn
 * @description: 类加载器学习1
 * @author: Elliot
 * @create: 2019-07-24 04:39
 **/
public class ClassLoaderLearn1 {
    private static ClassLoaderLearn1 singleTon = new ClassLoaderLearn1();
    public static int count1;
    public static int count2 = 0;

    private ClassLoaderLearn1() {
        count1++;
        count2++;
    }

    public static ClassLoaderLearn1 getInstance() {
        return singleTon;
    }

    public static void main(String[] args) {
        ClassLoaderLearn1 singleTon = ClassLoaderLearn1.getInstance();
        System.out.println("count1=" + singleTon.count1);
        System.out.println("count2=" + singleTon.count2);
    }
}
