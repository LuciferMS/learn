package com.learn.base.java.concurrent.callable;

import java.util.concurrent.*;

/**
 * @author Elliot
 * callable接口的学习
 */
public class CallableDemo2 {

    /**
     * CallAble接口的实现需要交给线程池去执行
     * 也可以封装成FutureTask给Thread执行...
     * @param args
     * @throws ExecutionException
     * @throws InterruptedException
     */
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        System.out.println("start:" + System.nanoTime());
        FutureTask<Long> futureTask = new FutureTask<Long>(new SumTask());
        Executor executor = Executors.newSingleThreadExecutor();
        executor.execute(futureTask);
        System.out.println(futureTask.get());
        System.out.println("End:" + System.nanoTime());
    }

    static class SumTask implements Callable<Long> {

        @Override
        public Long call() throws Exception {
            long sum = 0;
            for (int i = 0; i < 10000; i++) {
                sum += i;
            }
            return sum;
        }
    }
}
