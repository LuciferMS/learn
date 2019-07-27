package com.learn.base.jvm.bytecode;

/**
 * @program: learn
 * @description: lambda表达式学习1
 * @author: Elliot
 * @create: 2019-07-11 20:16
 **/
public class LambdaLearn1 {
    /**
     * 匿名内部类在编译时期就会生成一个class文件
     *
     * @param args
     */
    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("run");
            }
        };
    }
}
