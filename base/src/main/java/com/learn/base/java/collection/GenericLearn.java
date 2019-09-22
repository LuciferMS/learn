package com.learn.base.java.collection;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: learn
 * @description: 泛型学习
 * @author: Elliot
 * @create: 2019-08-17 10:38
 **/
public class GenericLearn {

    static class Parent{

    }

    static class Sub extends Parent{

    }

    /**
     * extends限制数据生产者
     * super限制数据消费者
     * 可以看看Collection的copy方法，精妙的一批
     * @param args
     */
    public static void main(String[] args) {
       List<Sub> subs = new ArrayList<>();
       subs.add(new Sub());
       subs.add(new Sub());
       List<? super Sub> list = new ArrayList<>();
       containerCopy(list, subs);
       for (int i = 0; i < list.size(); i++){
           System.out.println(list.get(i));
       }
    }

    /**
     * 泛型协变
     */
    public static void covariation(){
        List<Sub> subList = new ArrayList<>();
        subList.add(new Sub());
        subList.add(new Sub());
        List<? extends Parent> list = subList;
        for (Parent parent : list){
            System.out.println(parent);
        }
    }

    /**
     * 泛型逆变
     */
    public static void inverter(){
        List<? super Sub> list1 = new ArrayList<>();
        list1.add(new Sub());
    }

    /**
     * 仿照Collections的copy方法
     * 数据源是? extends Sub, 数据消费者是? super Sub，可以保证类型安全性
     * @param dest
     * @param src
     */
    public static void containerCopy(List<? super Sub> dest, List<? extends Sub> src){
        for(Sub sub : src){
            dest.add(sub);
        }
    }

}
