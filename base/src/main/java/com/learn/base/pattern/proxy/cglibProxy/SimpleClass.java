package com.learn.base.pattern.proxy.cglibProxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @program: learn
 * @description: cglib简单的demo
 * @author: Elliot
 * @create: 2019-09-22 18:16
 **/
public class SimpleClass {
    public void test(){
        System.out.println("hello world");
    }

    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(SimpleClass.class);
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                System.out.println("方法执行前....");
                Object result = methodProxy.invokeSuper(o, args);
                System.out.println("方法执行后....");
                return result;
            }
        });
        SimpleClass simpleClass = (SimpleClass)enhancer.create();
        simpleClass.test();
    }
}
