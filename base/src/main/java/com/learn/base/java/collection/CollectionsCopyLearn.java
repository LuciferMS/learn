package com.learn.base.java.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @program: learn
 * @description: collections copy方法学习
 * @author: Elliot
 * @create: 2019-08-19 00:02
 **/
public class CollectionsCopyLearn {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        /**
         * 这个方法有点东西
         */
        Collections.copy(list, list1);
    }
}
