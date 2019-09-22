package com.learn.base.java.concurrent.executor;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @program: learn
 * @description: 提交runnable实例
 * @author: Elliot
 * @create: 2019-08-06 14:37
 **/
public class ExecuteRunnableTest {

    static class Task implements Runnable{
        @Override
        public void run() {
            System.out.println("我是Elliot");
        }
    }

    public static void main(String[] args) {
        ExecutorService pool = Executors.newSingleThreadExecutor();
        pool.execute(new Task());
        pool.shutdown();
    }
}
