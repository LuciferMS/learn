package com.learn.base.java.collection;


import java.util.LinkedList;
import java.util.List;

/**
 * @program: learn
 * @description: 克隆测试
 * @author: Elliot
 * @create: 2019-08-17 18:47
 **/
public class CloneLearn {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        List<Integer> list1 = (List)list.clone();
        for (Integer i : list1){
            System.out.print(i + " ");
        }
        System.out.println();
        list.add(1);
        for (Integer i : list1){
            System.out.print(i + " ");
        }
        System.out.println();
        for (Integer i : list){
            System.out.print(i + " ");
        }
    }
}
