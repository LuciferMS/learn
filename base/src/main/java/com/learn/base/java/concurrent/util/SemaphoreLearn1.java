package com.learn.base.concurrent.util;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @program: learn
 * @description: SemaphoreLearn1
 * @author: Elliot
 * @create: 2019-07-17 21:41
 **/
public class SemaphoreLearn1 {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        final Semaphore semaphore = new Semaphore(3);
        for (int i = 0; i < 20; i++) {
            final int threadNum = i;
            executorService.execute(() -> {
                try {
                    /**
                     * 获取状态
                     */
                    semaphore.acquire();
                    test(threadNum);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    /**
                     * 释放状态
                     */
                    semaphore.release();
                }
            });
        }
    }

    private static void test(int threadNum) throws InterruptedException {
        System.out.println("目前是线程" + threadNum + "在工作.....");
        Thread.sleep(1000);
    }
}
