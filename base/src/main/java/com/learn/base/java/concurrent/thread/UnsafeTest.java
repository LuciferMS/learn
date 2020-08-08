package com.learn.base.java.concurrent.thread;

//import sun.misc.Unsafe;
//
//import java.lang.reflect.Field;
//
///**
// * @author Elliot
// * unsafe类的学习
// * unsafe提供了像c++这样操纵内存的能力
// */
//public class UnsafeTest {
//
//    public static Unsafe getUnsafe() throws NoSuchFieldException, IllegalAccessException {
//        Field f = Unsafe.class.getDeclaredField("theUnsafe");
//        f.setAccessible(true);
//        Unsafe unsafe = (Unsafe) f.get(null);
//        return unsafe;
//    }
//
//    public static Object getTestBeanByUnsafe() throws InstantiationException, NoSuchFieldException, IllegalAccessException {
//        Unsafe unsafe = getUnsafe();
//        UserTestBean userTestBean = (UserTestBean) unsafe.allocateInstance(UserTestBean.class);
//        return userTestBean;
//    }
//
//}
