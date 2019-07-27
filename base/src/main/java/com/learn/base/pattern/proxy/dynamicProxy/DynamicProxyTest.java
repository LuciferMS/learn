package pattern.proxy.dynamicProxy;

import pattern.proxy.ILiveAction;
import pattern.proxy.ISkillAction;
import pattern.proxy.Star;

import java.lang.reflect.Proxy;

/**
 * @program: learn
 * @description: 动态代理功能测试
 * @author: Elliot
 * @create: 2019-07-21 14:46
 **/
public class DynamicProxyTest {
    public static void main(String[] args) {
        useDynamicProxy();
    }

    public static void useDynamicProxy(){
        Star star = new Star();
        DynamicProxyHandler dynamicProxyHandler = new DynamicProxyHandler(star);
        /**
         * jdk的动态代理主要还是这个方法....
         *
         *  * 返回指定接口的代理类的实例，将方法调用调度到指定的调用处理程序。
         *          *  * @param loader  用于定义代理类的类加载器
         *          *  * @param interfaces  要实现的代理类的接口列表
         *          *  * @param h  调度方法调用的调用处理程序
         *          *  * @return 具有代理类的指定调用处理程序的代理实例，
         *          *     该代理类的指定调用处理程序由指定的类装入器定义并实现指定的接口
         * Proxy.newProxyInstance(ClassLoader loader, Class<?>[] interfaces, InvocationHandler h)
         *
         *
         */
        Object proxy = Proxy.newProxyInstance(
                ClassLoader.getSystemClassLoader(),
                new Class[]{ISkillAction.class, ILiveAction.class},
                dynamicProxyHandler
                );
        ((ISkillAction)proxy).sing();
        ((ISkillAction)proxy).dance();
        ((ILiveAction) proxy).eat();
    }
}

