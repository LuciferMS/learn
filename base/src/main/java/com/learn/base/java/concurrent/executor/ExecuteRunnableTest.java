package com.learn.base.java.concurrent.executor;

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
}
