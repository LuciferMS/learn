package com.learn.base.java.jvm.bytecode.asm;

/**
 * @program: learn
 * @description: 测试类
 * @author: Elliot
 * @create: 2019-08-05 17:50
 **/
public class ByteCodeDemo {

    private static final String NAME = "Elliot";

    private int age;

    public ByteCodeDemo(int age){
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public static void main(String[] args) {
        ByteCodeDemo byteCodeDemo = new ByteCodeDemo(1);
        System.out.println("name:" + NAME + byteCodeDemo.getAge());
    }

}
