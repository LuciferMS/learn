package com.learn.tool.test.proxy;

import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @program: learn
 * @description: 动态代理测试类
 * @author: Elliot
 * @create: 2020-03-01 17:02
 **/
public class ProxyTester {

    interface ISinger{
        void sing();
        void swim();
    }

    class Singer implements ISinger{
        public void sing() {
            System.out.println("我唱歌啦....");
        }

        public void swim(){
            System.out.println("我游泳啦...");
        }
    }

    class ProxyHandler implements InvocationHandler{

        private Object o;

        public ProxyHandler(Object o){
            this.o = o;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            final String METHOD_NAME = "sing";
            System.out.println("代理前....");
            Object invoke;
            if(METHOD_NAME.equals(method.getName())){
                System.out.println("我快要唱啦。。。");
                invoke = method.invoke(o, args);
            }else{
                System.out.println("其他方法代理..");
                invoke = method.invoke(o, args);
            }
            return invoke;
        }
    }

    @Test
    public void proxyTest(){
        Singer singer = new Singer();
        ProxyHandler proxyHandler = new ProxyHandler(singer);
        Object proxy = Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(),
                                                new Class[]{ISinger.class,},
                                                proxyHandler);
        ISinger s = (ISinger) proxy;
        s.sing();
        s.swim();
    }

}
