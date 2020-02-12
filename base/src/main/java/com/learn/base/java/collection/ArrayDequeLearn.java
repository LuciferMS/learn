package com.learn.base.java.collection;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @program: learn
 * @description: ArrayDequeLearn
 * @author: Elliot
 * @create: 2020-02-11 22:42
 **/
public class ArrayDequeLearn {
    public static void main(String[] args) {
        Deque<Integer> deque = new ArrayDeque<Integer>();
        deque.addFirst(1);
        deque.addLast(2);
        deque.addFirst(1);
    }
}
