package com.learn.base.java.concurrent.future;

import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;

/**
 * @program: learn
 * @description: CompletableFutureLearn 异步任务接口
 * @author: Elliot
 * @create: 2019-07-21 16:38
 **/
public class CompletableFutureLearn {
    static class OddNumberPlus implements Supplier<Integer> {
        @Override
        public Integer get() {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 1+3+5+7+9;
        }
    }

    /**
     * 进行异步计算的时候当前线程不会进入阻塞状态
     * 不需要使用线程池，使用了forkjoin工作窃取框架进行任务的计算，
     * 也可以使用线程池....
     * @param args
     */
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        final int evenNumber = 2 + 4 + 6 + 8 + 10;
        CompletableFuture<Integer> oddNumber = CompletableFuture.supplyAsync(new OddNumberPlus());
        try {
            Thread.sleep(1000);
            System.out.println("0.开始了："+ (System.currentTimeMillis()-startTime) +"秒");
            //看这里，实现回调
            oddNumber.thenAccept(oddNumberResult->
            {
                System.out.println("1.开始了："+ (System.currentTimeMillis()-startTime) +"秒");
                System.out.println("此时计算结果为："+(evenNumber+oddNumberResult));
            });
            oddNumber.get();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
