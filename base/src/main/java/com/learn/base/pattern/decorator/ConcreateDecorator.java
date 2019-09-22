package com.learn.base.pattern.decorator;

/**
 * @program: learn
 * @description: 单纯的实现
 * @author: Elliot
 * @create: 2019-07-31 01:10
 **/
public class ConcreateDecorator implements Component {

    @Override
    public void doSomething() {
        System.out.println("单纯的实现...");
    }
}
