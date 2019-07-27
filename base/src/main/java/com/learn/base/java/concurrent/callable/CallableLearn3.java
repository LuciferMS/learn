package com.learn.base.concurrent.callable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @program: learn
 * @description: Callable学习3
 * @author: Elliot
 * @create: 2019-07-09 23:47
 **/
public class CallableLearn3 {
    /**
     * 将Callable包装进FutureTask里面，通过FutureTask创建线程执行任务，这个比较少用
     * 我这里有点好奇，其实FutureTask继承了Runnable接口，怎么获取Callable的结果的
     * FutureTask的run方法跑了Callable的call方法，并且把结果设置进他的属性里面
     *
     * @param args
     */
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<String> futureTask = new FutureTask<String>(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "Hello";
            }
        });
        Thread t = new Thread(futureTask);
        t.start();
        System.out.println(futureTask.get());
    }
}
