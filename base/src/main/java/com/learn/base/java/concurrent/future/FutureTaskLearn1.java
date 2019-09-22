package com.learn.base.java.concurrent.future;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @program: learn
 * @description: future
 * @author: Elliot
 * @create: 2019-07-21 16:33
 **/
public class FutureTaskLearn1 {
    static class OddNumber implements Callable<Integer>{
        @Override
        public Integer call() throws Exception {
            Thread.sleep(3000);
            int result = 1 + 2 + 3 + 4 + 5;
            return result;
        }
    }

    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();
        OddNumber oddNumber = new OddNumber();
        Future<Integer> future = executor.submit(oddNumber);
        long startTime = System.currentTimeMillis();
        int evenNumber = 2 + 4 + 6 + 8 + 10;
        try {
            Thread.sleep(1000);
            System.out.println("0.开始了："+ (System.currentTimeMillis()-startTime) +"秒");
            int oddNumberResult = future.get();//这时间会被阻塞
            System.out.println("1+2+...+9+10="+(evenNumber+oddNumberResult));
            System.out.println("1.开始了："+ (System.currentTimeMillis()-startTime) +"秒");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
