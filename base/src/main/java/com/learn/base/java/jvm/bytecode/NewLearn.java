package com.learn.base.java.jvm.bytecode;

/**
 * @program: learn
 * @description: New关键字的字节码学习
 * @author: Elliot
 * @create: 2019-07-11 14:54
 **/
public class NewLearn {

    /**
     * 一个对象创建的套路是这样的：new、dup、invokespecial，下次遇到同样的指令要形成条件反射。
     *
     * @param args
     */
    public static void main(String[] args) {
        /**
         * 类加载时会触发<clinit指令>，new，getstatic，putstatic，inivokestatic或者使用这个Class对象会是触发类的静态初始化，
         * 这里new B的时候，会发现B这个class还没有加载，会触发B的clinit，触发B clinit的时候发现A还没有做静态初始化，。。。
         */
        A a = new B();

        A[] as = new A[10];
        as[0] = new A();
    }

    /**
     * 类加载，先初始化静态字段，然后执行静态代码块
     * 对象初始化，先是初始化私有字段，再是执行代码块，最后才调用构造器方法
     * 这里还利用了多态的特性
     */
    static class A {
        static {
            System.out.println("A clinit");
        }

        A() {
            System.out.println("A init");
        }
    }

    static class B extends A {
        static {
            System.out.println("B clinit");
        }

        B() {
            System.out.println("B init");
        }
    }

    static class Father {
        private int i = test();
        private static int j = method();

        static {
            System.out.print("(1)");
        }

        Father() {
            System.out.print("(2)");
        }

        {
            System.out.print("(3)");
        }

        public int test() {
            System.out.print("(4)");
            return 1;
        }

        public static int method() {
            System.out.print("(5)");
            return 1;
        }
    }

    static public class Son extends Father {
        private int i = test();
        private static int j = method();

        static {
            System.out.print("(6)");
        }

        Son() {
            System.out.print("(7)");
        }

        {
            System.out.print("(8)");
        }

        @Override
        public int test() {
            System.out.print("(9)");
            return 1;
        }

        public static int method() {
            System.out.print("(10)");
            return 1;
        }

        /**
         * (5)(1)(10)(6)(9)(3)(2)(9)(8)(7)
         * (9)(3)(2)(9)(8)(7)
         * 考点：多态，初始化顺序
         * clinit, init,字段，方法块，构造方法
         *
         * @param args
         */
        public static void main(String[] args) {
            Son s1 = new Son();
            System.out.println();
            Son s2 = new Son();
        }
    }
}
