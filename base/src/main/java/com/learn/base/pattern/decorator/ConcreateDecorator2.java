package com.learn.base.pattern.decorator;

/**
 * @program: learn
 * @description: 装饰器2
 * @author: Elliot
 * @create: 2019-07-31 01:06
 **/
public class ConcreateDecorator2 extends Decorator {

    public ConcreateDecorator2(Component component) {
        super(component);
    }

    @Override
    public void doSomething() {
        super.doSomething();
        this.doOtherThing();
    }

    private void doOtherThing(){
        System.out.println("功能B");
    }

}
