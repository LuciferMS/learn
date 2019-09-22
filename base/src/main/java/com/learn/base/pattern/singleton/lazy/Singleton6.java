package com.learn.base.pattern.singleton.lazy;

/**
 * @program: learn
 * @description: 内部类形式
 * @author: Elliot
 * @create: 2019-06-11 17:13
 **/
public class Singleton6 {
    private Singleton6() {

    }

    private static class Inner {
        private static final Singleton6 INSTANCE = new Singleton6();
    }

    public static Singleton6 getInstance() {
        return Inner.INSTANCE;
    }
}
