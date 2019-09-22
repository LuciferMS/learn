package com.learn.base.pattern.proxy.dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @program: learn
 * @description: 代理方法调用处理器
 * 使用动态代理其实要实现的是invoke方法，看看要代理的是什么方法
 * 拓展可以看看注解的原理....
 * @author: Elliot
 * @create: 2019-07-21 14:39
 **/
public class DynamicProxyHandler implements InvocationHandler {

    private Object o;

    public DynamicProxyHandler(Object o) {
        this.o = o;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        final String METHOD_NAME = "sing";
        System.out.println("代理前统一操作....");
        Object invoke;
        if (METHOD_NAME.equals(method.getName())){
            /**
             * 拦截下唱歌...
             * 明星唱歌前经纪人跟活动商商量一下...
             */
            System.out.println("经纪人跟活动商进行唱歌亲的布置...");
            /**
             * 唱歌....
             */
            invoke = method.invoke(o, args);
            /**
             * 唱完歌了，收钱了.....
             */
            System.out.println("唱完歌后收钱....");
        }else{
            /**
             * 对其他方法的代理....
             */
            invoke = method.invoke(o, args);
        }
        System.out.println("代理后统一处理....");
        /**
         * 返回代理后的对象....
         */
        return invoke;
    }


}
