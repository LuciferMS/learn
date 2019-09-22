package com.learn.base.java.annotation;

/**
 * @program: learn
 * @description: 自定义注解测试
 * @author: Elliot
 * @create: 2019-08-19 00:29
 **/
@MyAnnotation(say = "Hello world")
public class MyAnnotationTest {
    public static void main(String[] args) {
        /**
         * System.setProperty("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
         * 保留由动态代理生成的class字节码
         */
        //$Proxy @com.learn.base.java.annotation.MyAnnotation(say=Hello world)
        MyAnnotation annotation = MyAnnotationTest.class.getAnnotation(MyAnnotation.class);
        /**
         * 从map里面拿的，有点东西...
         */
        System.out.println(annotation.say());
    }
}
