package com.learn.base.pattern.decorator;

/**
 * @program: learn
 * @description: 装饰器
 * @author: Elliot
 * @create: 2019-07-31 01:01
 **/
public class Decorator implements Component{

    private  Component component;

    public Decorator(Component component) {
        this.component = component;
    }

    @Override
    public void doSomething() {
        component.doSomething();
    }
}
