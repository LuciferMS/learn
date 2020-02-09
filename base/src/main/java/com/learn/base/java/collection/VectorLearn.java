package com.learn.base.java.collection;

import java.util.Vector;

/**
 * @program: learn
 * @description: vector的学习
 * @author: Elliot
 * @create: 2020-02-08 00:24
 **/
public class VectorLearn {
    public static void main(String[] args) {
        Vector<Integer> vector = new Vector<>(10, 11);
        vector.add(1);
        vector.add(2);
        System.out.println(vector.get(1));
        vector.remove(1);
    }
}
