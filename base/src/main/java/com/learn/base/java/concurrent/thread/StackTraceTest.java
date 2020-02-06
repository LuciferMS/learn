package com.learn.base.java.concurrent.thread;

/**
 * @program: learn
 * @description: 方法测试
 * @author: Elliot
 * @create: 2020-01-03 21:44
 **/
public class StackTraceTest {
    public static void main(String[] args) {
        Thread t = Thread.currentThread();
        StackTraceElement[] sts = t.getStackTrace();
        for (StackTraceElement st : sts){
            System.out.println(st.getMethodName());
        }
    }
}
