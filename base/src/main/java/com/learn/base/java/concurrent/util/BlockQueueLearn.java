package com.learn.base.java.concurrent.util;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * @program: learn
 * @description: 阻塞队列学习
 * @author: Elliot
 * @create: 2019-08-17 00:55
 **/
public class BlockQueueLearn {
    public static void main(String[] args) {
        BlockingQueue<Integer> blockingQueue1 = new LinkedBlockingDeque<>();
        BlockingQueue<Integer> blockingQueue2 = new ArrayBlockingQueue<Integer>(10);
    }
}
