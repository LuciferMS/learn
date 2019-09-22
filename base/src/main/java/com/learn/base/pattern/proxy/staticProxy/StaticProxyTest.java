package com.learn.base.pattern.proxy.staticProxy;

import com.learn.base.pattern.proxy.Star;

/**
 * @program: learn
 * @description: 静态代理测试
 * @author: Elliot
 * @create: 2019-07-21 14:02
 **/
public class StaticProxyTest {

    public static void main(String[] args) {
        useStaticProxy();
    }

    public static void useStaticProxy(){
        Star star = new Star();
        Agent agent = new Agent(star);
        agent.sing();
    }
}
