package com.learn.base.java.concurrent.callable;

import java.util.concurrent.*;

/**
 * @program: learn
 * @description: callable学习2
 * @author: Elliot
 * @create: 2019-07-09 23:38
 **/
public class CallableLearn2 {

    /**
     * 通过线程池执行Callable任务，然后获取结果
     *
     * @param args
     * @throws ExecutionException
     * @throws InterruptedException
     */
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        /**
         * 创建线程池
         * Executors是接口Executor的伴生类
         */
        ExecutorService pool = Executors.newCachedThreadPool();
        /**
         * 提交Callable任务，返回Future
         */
        Future<String> future = pool.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "hello";
            }
        });
        /**
         * 通过future获取结果
         */
        String result = future.get();
        System.out.println(result);
    }
}
