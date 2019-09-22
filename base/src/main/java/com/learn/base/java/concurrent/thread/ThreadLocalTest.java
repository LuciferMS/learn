package com.learn.base.java.concurrent.thread;

/**
 * @author Elliot
 * threadLocal学习
 * threadLocal 提供线程共享变量的功能
 * 其实就是通过theadLocal操作Thread实例内部的threadLocalMap属性进行数据的存取
 * 要注意的是threadLocal如何避免内存泄露(ThreadLocalMap的Key是弱引用，gc后会产生key为null的键值对，
 * TheadLocalMap在每次get set的时候移除这些键值对就好)
 */
public class ThreadLocalTest {

    private static String strLabel;

    private static ThreadLocal<String> threadLocal = new ThreadLocal();

    public static void main(String[] args) {
        strLabel = "main";
        threadLocal.set("main");
        Thread t = new Thread(() -> {
            strLabel = "child";
            threadLocal.set("child");
        });
        t.start();
        try {
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //静态变量改变了就是改变了
        System.out.println("strLabel = " + strLabel);
        //threadLocal获取的是当前线程的ThreadLocalMap属性下对应的值，所以这个值是线程隔离的
        System.out.println("threadLocal = " + threadLocal.get());
    }
}
