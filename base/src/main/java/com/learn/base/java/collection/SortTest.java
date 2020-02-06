package com.learn.base.java.collection;

import java.util.Arrays;

/**
 * @program: learn
 * @description: sort测试
 * @author: Elliot
 * @create: 2019-12-31 19:14
 **/
public class SortTest {

    static class TestClass implements Comparable{
        private String name;

        public TestClass(String name){
            this.name = name;
        }

        public void printName(){
            System.out.println(this.name);
        }

        public String getName(){
            return this.name;
        }

        @Override
        public int compareTo(Object o) {
           return this.name.compareTo(((TestClass)o).getName());
        }
    }

    public static void main(String[] args) {
        TestClass t1 = new TestClass("t1");
        TestClass t2 = new TestClass("t2");
        TestClass t3 = new TestClass("t3");
        TestClass t4 = new TestClass("t4");

        TestClass[] ts = new TestClass[]{t2, t1, t4, t3};

        Arrays.sort(ts);

        for (TestClass t : ts){
            t.printName();
        }
    }
}
