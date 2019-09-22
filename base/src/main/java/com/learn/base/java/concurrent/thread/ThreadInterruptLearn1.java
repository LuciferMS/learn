package com.learn.base.java.concurrent.thread;

/**
 * @program: learn
 * @description: 线程中断学习1
 * 这里线程不会中断的，因为虽然线程发出了终端信号，但是线程内部没有响应中断的机制。
 * @author: Elliot
 * @create: 2019-08-03 21:58
 **/
public class ThreadInterruptLearn1 {
    public static void main(String[] args) {
        Thread t = new Thread(() -> {
            while(true){
                /**
                 * yield方法会让当前线程你让出cpu
                 */
                Thread.yield();
                System.out.println(1);
            }
        });
        t.start();
        t.interrupt();//发送中断信号
    }
}
