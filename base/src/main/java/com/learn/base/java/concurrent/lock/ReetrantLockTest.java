package com.learn.base.concurrent.lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Elliot
 * 可重入锁测试
 */
public class ReetrantLockTest {
    public static void main(String[] args) {
        ReentrantLock reentrantLock = new ReentrantLock();
        reentrantLock.lock();
        System.out.println("锁了一次");
        reentrantLock.lock();
        System.out.println("锁了两次");
        reentrantLock.unlock();
        reentrantLock.unlock();
    }
}
