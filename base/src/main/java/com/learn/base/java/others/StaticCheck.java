package com.learn.base.java.others;

/**
 * @program: learn
 * @description: 静态类型检查
 * @author: Elliot
 * @create: 2019-08-01 06:48
 **/
public class StaticCheck {

    static class A{
        A me(){
            return this;
        }

        public void doA(){
            System.out.println("干A");
        }
    }

    static class B extends A{
        public void doB(){
            System.out.println("干B");
        }
    }

    public static void main(String[] args) {
        new B().me().doA();//编译可以通过，但是运行会出错
        ((B)new B().me()).doB();
    }
}
