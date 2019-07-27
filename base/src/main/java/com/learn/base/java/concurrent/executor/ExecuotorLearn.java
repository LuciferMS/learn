package com.learn.base.concurrent.executor;

import java.util.concurrent.Executor;

/**
 * @program: learn
 * @description: executor接口
 * @author: Elliot
 * @create: 2019-07-28 01:35
 **/
public class ExecuotorLearn  implements Executor {
    /**
     * 这就是一个简单的线程池
     * 提交任务之后创建一条线程执行任务，这个跟反复创建线程没什么区别
     * 没有很好的复用线程..
     * @param command
     */
    @Override
    public void execute(Runnable command) {
        if (command == null){
            throw new RuntimeException("task can not be null");
        }
        new Thread(command).start();
    }
}
