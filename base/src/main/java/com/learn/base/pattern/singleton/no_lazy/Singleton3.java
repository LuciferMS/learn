package com.learn.base.pattern.singleton.no_lazy;

/**
 * @program: learn
 * @description: 静态代码块形式创建单例
 * @author: Elliot
 * @create: 2019-06-02 12:33
 * <p>
 * 这种方法适合对象的构建流程比较复杂的场景
 **/
public class Singleton3 {
    private static final Singleton3 INSTANCE;

    static {
        INSTANCE = new Singleton3();
    }

    private Singleton3() {

    }

}
