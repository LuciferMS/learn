package com.learn.base.concurrent.util;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @program: learn
 * @description: CyclicBarrierLearn
 * @author: Elliot
 * @create: 2019-07-17 20:49
 * 阻塞点，就像开会的时候，必须人齐了，才会开始开会...
 **/
public class CyclicBarrierLearn {

    private static CyclicBarrier barrier = new CyclicBarrier(5);

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 20; i++) {
            final int threadNum = i;
            Thread.sleep(1000);
            executorService.execute(() -> {
                try {
                    wait(threadNum);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }
        executorService.shutdown();
    }

    private static void wait(int threadNum) throws Exception {
        Thread.sleep(1000);
        System.out.println("线程" + threadNum + "在等待....");
        barrier.await();
        System.out.println("线程" + threadNum + "好了.....");
    }
}
