package com.learn.base.java.concurrent.thread;


/**
 * @program: learn
 * @description: 线程中断学习2
 * 线程内部有响应中断的逻辑。。。所以会中断返回
 * @author: Elliot
 * @create: 2019-08-03 22:02
 **/
public class ThreadInterruptLearn2 {
    public static void main(String[] args) {
        Thread t = new Thread(() -> {
            for ( ; ;){
                Thread.yield();
                if (Thread.interrupted()){
                    System.out.println("线程中断");
                    return;
                }
            }
        });
        t.start();
        t.interrupt();
    }
}
