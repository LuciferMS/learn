package com.learn.base.java.others;


import java.util.Timer;
import java.util.TimerTask;

/**
 * @author Elliot
 * 定时任务测试
 * 学习资料 https://blog.csdn.net/u013332124/article/details/79603943
 */
public class TimerTest {
    public static void main(String[] args) {
        /**
         * 通过看Timer的源码，他其实是维护了一个自己的线程。要执行的任务按照时间组成一个堆，
         * 堆顶为最小的元素。
         *
         */
        Timer timer = new Timer();
        timer.schedule(new MyTasks(), 5000, 10000);
    }
}


class MyTasks extends TimerTask {

    @Override
    public void run() {
        System.out.println("hello world");
    }
}