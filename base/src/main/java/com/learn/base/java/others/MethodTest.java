package com.learn.base.java.others;

/**
 * @program: learn
 * @description: MethodTest
 * @author: Elliot
 * @create: 2019-07-01 18:13
 **/
public class MethodTest {
    static class Human {
        String say() {
            return "i am human";
        }
    }

    static class Man extends Human {
        @Override
        String say() {
            return "i am man";
        }
    }

    void testSay(Human human) {
        System.out.println("i am human");
    }


    void testSay(Man man) {
        System.out.println("i am man");
    }

    public static void main(String[] args) {
        Human h = new Man();
        MethodTest m = new MethodTest();
        h.say();
        m.testSay(h);
    }
}