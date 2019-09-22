package com.learn.base.java.others.type;

import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

/**
 * @program: learn
 * @description: 类型变量
 * @author: Elliot
 * @create: 2019-08-03 22:31
 **/
public class TypeVariableLearn<K extends Number, T> {

    //K有指定了上边界Number
    K key;
    //T没有指定上边界，其默认上边界为Object
    T value;

    public static void main(String[] args){
        Type[] types = TypeVariableLearn.class.getTypeParameters();
        for (Type type : types){
            TypeVariable t = (TypeVariable) type;
            int index = t.getBounds().length - 1;
            //输出上边界
            System.out.println("--getBounds()-- " + t.getBounds()[index]);
            //输出名称
            System.out.println("--getName()--" + t.getName());
            //输出所在的类的类型
            System.out.println("--getGenericDeclaration()--" + 														t.getGenericDeclaration());
        }
    }
}

