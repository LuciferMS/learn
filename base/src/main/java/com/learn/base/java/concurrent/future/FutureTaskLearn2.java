package com.learn.base.java.concurrent.future;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @program: learn
 * @description:
 * @author: Elliot
 * @create: 2019-08-01 21:45
 **/
public class FutureTaskLearn2 {

    static class Task implements Callable<String>{

        @Override
        public String call() throws Exception {
            return "我好帅";
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask f = new FutureTask(new Task());
        f.get();
        new Thread(f);
    }
}
