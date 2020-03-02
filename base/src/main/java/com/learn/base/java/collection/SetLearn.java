package com.learn.base.java.collection;

import java.util.HashSet;
import java.util.Set;

/**
 * @program: learn
 * @description: set api 学习
 * @author: Elliot
 * @create: 2020-03-02 16:58
 **/
public class SetLearn {
    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>();
        set.add(1);
        set.add(2);
        System.out.println(set.contains(1));
    }
}
