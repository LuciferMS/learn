package com.learn.base.concurrent.future;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * @program: learn
 * @description: FutureTask相关学习
 * @author: Elliot
 * @create: 2019-07-10 19:14
 * FutureTask是一种支持取消的异步任务包装类，也就是说FutureTask执行的时候不立即返回结果，
 * 自己可以通过异步调用get方法获取结果，也可以中途调用cancel方法取消任务。而且必须要知道的
 * 就是FutureTask只是任务的包装类，并不是真正的任务类。
 *
 **/
public class FutureTaskLearn {

    /**
     * FutureTask状态
     * private volatile int state;
     * private static final int NEW          = 0; //新建任务的状态
     * private static final int COMPLETING   = 1; //我觉得可以称作进行中
     * private static final int NORMAL       = 2; //正常执行完毕
     * private static final int EXCEPTIONAL  = 3; //发生异常时
     * private static final int CANCELLED    = 4; //任务取消
     * private static final int INTERRUPTING = 5; //中断中
     * private static final int INTERRUPTED  = 6; //中断完成
     */

    /**
     * 创建FutureTask
     * futureTask支持两种创建方式
     * 一种传入Callable对象，一种传入runnable对象和一个返回值，其实就是将其包装成callable对象
     */
    public static void buildFutureTask(){
        FutureTask futureTask1 = new FutureTask(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "Hello";
            }
        });
        FutureTask futureTask2 = new FutureTask(new Runnable() {
            @Override
            public void run() {
                System.out.println("helloworld");
            }
        }, "hello");
    }

}
