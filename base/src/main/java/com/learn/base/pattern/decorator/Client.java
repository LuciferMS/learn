package com.learn.base.pattern.decorator;

/**
 * @program: learn
 * @description: 客户端调用
 * @author: Elliot
 * @create: 2019-07-31 01:07
 **/
public class Client {

    public static void main(String[] args) {
        Component component = new ConcreateDecorator1(
                new ConcreateDecorator2(new ConcreateDecorator()));
        Component component1 = new ConcreateDecorator2(new ConcreateDecorator());
        Component component2 = new ConcreateDecorator();
        component.doSomething();
        System.out.println("======美丽的分割线======");
        component1.doSomething();
        System.out.println("======美丽的分割线======");
        component2.doSomething();
    }

}
