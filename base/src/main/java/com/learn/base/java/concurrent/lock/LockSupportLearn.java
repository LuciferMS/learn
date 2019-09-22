package com.learn.base.java.concurrent.lock;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.LockSupport;

/**
 * @program: learn
 * @description: LockSupport学习
 * @author: Elliot
 * @create: 2019-08-21 22:39
 **/
public class LockSupportLearn {
    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while(true){
                    System.out.println("我好帅...");
                    /**
                     * 这尼玛是纳秒..这不是扯犊子吗...,
                     */
                    LockSupport.parkNanos(1000 * 1000 * 1000);
                }
            }
        });
        thread.start();
    }
}
