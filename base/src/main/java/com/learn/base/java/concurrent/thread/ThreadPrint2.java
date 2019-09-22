package com.learn.base.java.concurrent.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @program: learn
 * @description: 使用condition交替打印数字
 * @author: Elliot
 * @create: 2019-08-05 20:47
 **/
public class ThreadPrint2 {

    static class Print{
        private Integer i = new Integer(0);
        private ReentrantLock lock = new ReentrantLock();
        private Condition conditionA = lock.newCondition();
        private Condition conditionB = lock.newCondition();
        private Condition conditionC = lock.newCondition();

        public void aThreadHandler(){
            try {
                lock.lock();
                i++;
                System.out.println(Thread.currentThread().getName() + ": " + i.intValue());
                Thread.sleep(500);
                conditionB.signal();
                conditionA.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            lock.unlock();
        }

        public void bThreadHandler() {
            try {
                lock.lock();
                i++;
                Thread.sleep(500);
                System.out.println(Thread.currentThread().getName() + ": " + i.intValue());
                conditionC.signal();
                conditionB.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
        }

        public void cThreadHandler(){
            try {
                lock.lock();
                i++;
                System.out.println(Thread.currentThread().getName() + ": " + i.intValue());
                Thread.sleep(500);
                conditionA.signal();
                conditionC.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
        }
    }

    static class Task1 implements Runnable{

        private Print print;

        public Task1(Print print) {
            this.print = print;
        }

        @Override
        public void run() {
            while(true){
                print.aThreadHandler();
            }
        }
    }

    static class Task2 implements Runnable{

        private Print print;

        public Task2(Print print) {
            this.print = print;
        }

        @Override
        public void run() {
            while(true){
                print.bThreadHandler();
            }
        }
    }

    static class Task3 implements Runnable{

        private Print print;

        public Task3(Print print) {
            this.print = print;
        }

        @Override
        public void run() {
            while(true){
                print.cThreadHandler();
            }
        }
    }

    public static void main(String[] args)  {
        Print print = new Print();
        Thread threadA = new Thread(new Task1(print), "threadA");
        Thread threadB = new Thread(new Task2(print), "threadB");
        Thread threadC = new Thread(new Task3(print), "threadC");
        threadA.start();
        threadB.start();
        threadC.start();
    }
}
