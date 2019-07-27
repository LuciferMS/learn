package com.learn.base.jvm.bytecode;

import java.lang.reflect.Method;

/**
 * @program: learn
 * @description: ReflectionLearn1
 * @author: Elliot
 * @create: 2019-07-14 09:12
 **/
public class ReflectionLearn1 {

    private static int count = 0;

    public static void foo() {
        new Exception("test#" + count++).printStackTrace();
    }

    public static void main(String[] args) throws Exception {
        Class<?> clz = Class.forName("com.learn.base.jvm.bytecode.ReflectionLearn1");
        Method method = clz.getMethod("foo");
        for (int i = 0; i < 20; i++) {
            method.invoke(null);
        }
    }
}
