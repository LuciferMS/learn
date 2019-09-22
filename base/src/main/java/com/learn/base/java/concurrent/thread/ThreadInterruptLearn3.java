package com.learn.base.java.concurrent.thread;

/**
 * @program: learn
 * @description: 线程中断学习3
 * sleep() 方法被中断后会清除中断标记，所以循环会继续运行。
 * @author: Elliot
 * @create: 2019-08-03 22:11
 **/
public class ThreadInterruptLearn3 {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            while (true) {
                // 响应中断
                if (Thread.currentThread().isInterrupted()) {
                    System.out.println("线程被中断，程序退出。");
                    return;
                }

                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    System.out.println("线程休眠被中断，程序退出。");
                }
            }
        });
        thread.start();
        Thread.sleep(2000);
        thread.interrupt();
    }
}
