package com.learn.base.pattern.decorator;

/**
 * @program: learn
 * @description: 装饰器1
 * @author: Elliot
 * @create: 2019-07-31 01:03
 **/
public class ConcreateDecorator1 extends Decorator {

    public ConcreateDecorator1(Component component) {
        super(component);
    }

    @Override
    public void doSomething() {
        super.doSomething();
        this.doOtherThing();
    }

    private void doOtherThing(){
        System.out.println("功能A");
    }
}
