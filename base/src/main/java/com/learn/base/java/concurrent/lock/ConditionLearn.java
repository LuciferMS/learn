package com.learn.base.java.concurrent.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @program: learn
 * @description: condition使用
 * @author: Elliot
 * @create: 2019-08-05 20:30
 **/
public class ConditionLearn {

    private ReentrantLock lock = new ReentrantLock();

    private Condition condition1 = lock.newCondition();

    private Condition condition2 = lock.newCondition();

    public void awaitA(){
        try {
            lock.lock();
            System.out.println(Thread.currentThread().getName() + ", start await");
            condition1.await();
            System.out.println(Thread.currentThread().getName() + ", end await");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public void awaitB(){
        try {
            lock.lock();
            System.out.println(Thread.currentThread().getName() + ", start await");
            condition2.await();
            System.out.println(Thread.currentThread().getName() + ", end await");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public void signalA(){
        lock.lock();
        condition1.signal();
        System.out.println(Thread.currentThread().getName() + " : signal A");
    }

    public static void main(String[] args) throws InterruptedException {
        final ConditionLearn conditionLearn = new ConditionLearn();
        Runnable task = new Runnable() {
            @Override
            public void run() {
                conditionLearn.awaitA();
            }
        };

        Runnable task2 = new Runnable() {
            @Override
            public void run() {
                conditionLearn.awaitB();
            }
        };

        Thread threadA = new Thread(task,"thread-A");
        Thread threadB = new Thread(task2, "thread-B");
        threadA.start();
        threadB.start();
        Thread.sleep(3000);
        conditionLearn.signalA();
    }
}
