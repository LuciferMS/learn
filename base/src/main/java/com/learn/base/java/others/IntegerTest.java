package com.learn.base.java.others;

/**
 * @program: learn
 * @description: IntegerTest
 * 你抓周树人跟我鲁迅有什么关系...
 * @author: Elliot
 * @create: 2019-08-01 07:28
 **/
public class IntegerTest {
    public static void main(String[] args) {
        Integer i = Integer.valueOf(1);
        add(i);
        System.out.println(i);
    }

    public static void add(Integer i){
        i = new Integer(2);
    }
}
