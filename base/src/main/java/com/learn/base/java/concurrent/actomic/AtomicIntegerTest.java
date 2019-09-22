package com.learn.base.java.concurrent.actomic;

import java.lang.reflect.Field;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @program: learn
 * @description: 原子类测试
 * @author: Elliot
 * @create: 2019-07-30 06:33
 **/
public class AtomicIntegerTest {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        AtomicInteger i1 = new AtomicInteger(1);
        Long l1 = getValueOffset(AtomicInteger.class);
        System.out.println(l1);
        AtomicInteger i2 = new AtomicInteger(1);
        Long l2 = getValueOffset(AtomicInteger.class);
        System.out.println(l2);
    }

    private static Long getValueOffset(Class clz) throws NoSuchFieldException, IllegalAccessException {
        /**
         * 这里获取的是字段在对象内的偏移地址
         * 实际底层操作的时候是baseAddress + offsetAddress获取对象内字段的实际地址
         * 所以用静态字段存储偏移地址没错
         */
        Field f = clz.getDeclaredField("valueOffset");
        f.setAccessible(true);
        return (Long)f.get(null);
    }

}
