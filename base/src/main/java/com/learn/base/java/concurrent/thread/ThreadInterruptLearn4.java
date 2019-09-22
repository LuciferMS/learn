package com.learn.base.java.concurrent.thread;

/**
 * @program: learn
 * @description: 线程中断学习4
 * 因为线程睡眠会清除中断信号，所以在中断异常处理的时候重新设置中断标记
 * @author: Elliot
 * @create: 2019-08-03 22:16
 **/
public class ThreadInterruptLearn4 {
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
                    Thread.currentThread().interrupt();
                }
            }
        });
        thread.start();
        Thread.sleep(2000);
        thread.interrupt();
    }
}
