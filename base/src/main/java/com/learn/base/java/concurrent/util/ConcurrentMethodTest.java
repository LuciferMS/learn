package com.learn.base.concurrent.util;

/**
 * @program: learn
 * @description: 并发线程执行问题
 * @author: Elliot
 * @create: 2019-07-18 19:07
 * happens-before规则:
 * 锁的释放一定在锁的获取之前
 * 线程start之前的操作一定在start之前....
 **/
public class ConcurrentMethodTest {

    public synchronized void m1() throws InterruptedException {
        System.out.println("我将休息10秒钟");
        Thread.sleep(10000);
    }

    public synchronized void m2() throws InterruptedException {
        Thread.sleep(1000);
        System.out.println("看看我会不会被执行???");
    }

    static class Task1 implements Runnable {

        private ConcurrentMethodTest concurrentMethodTest;

        public Task1(ConcurrentMethodTest concurrentMethodTest) {
            this.concurrentMethodTest = concurrentMethodTest;
        }

        @Override
        public void run() {
            try {
                concurrentMethodTest.m1();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    static class Task2 implements Runnable {

        private ConcurrentMethodTest concurrentMethodTest;

        public Task2(ConcurrentMethodTest concurrentMethodTest) {
            this.concurrentMethodTest = concurrentMethodTest;
        }

        @Override
        public void run() {
            try {
                concurrentMethodTest.m2();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        ConcurrentMethodTest concurrentMethodTest = new ConcurrentMethodTest();
        new Thread(new Task1(concurrentMethodTest)).start();
        new Thread(new Task2(concurrentMethodTest)).start();
        System.out.println("main end");
    }
}
