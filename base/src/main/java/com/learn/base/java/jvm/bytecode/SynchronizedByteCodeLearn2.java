package com.learn.base.java.jvm.bytecode;

/**
 * @program: learn
 * @description: SynchronizedByteCodeLearn2
 * @author: Elliot
 * @create: 2019-07-13 21:36
 **/
public class SynchronizedByteCodeLearn2 {

    /**
     * public class base.bytecode.SynchronizedByteCodeLearn2 {
     * public base.bytecode.SynchronizedByteCodeLearn2();
     * Code:
     * 0: aload_0
     * 1: invokespecial #1                  // Method java/lang/Object."<init>":()V
     * 4: return
     * <p>
     * public synchronized void testMethod();
     * Code:
     * 0: return
     * }
     * JVM 不会使用特殊的字节码来调用同步方法，当 JVM 解析方法的符号引用时，它会判断方法是不是同步的
     * （检查方法 ACC_SYNCHRONIZED 是否被设置）。如果是，执行线程会先尝试获取锁。如果是实例方法，
     * JVM 会尝试获取实例对象的锁，如果是类方法，JVM 会尝试获取类锁。在同步方法完成以后，不管是正常
     * 返回还是异常返回，都会释放锁
     */
    public synchronized void testMethod() {
        System.out.println("线程1在执行");

        while (true){

        }
    }

    public synchronized void testMethod2(){
        System.out.println("线程2在执行");
        while(true){

        }
    }

    public void setHello(){

    }

    static class Task implements Runnable{
        private SynchronizedByteCodeLearn2 synchronizedByteCodeLearn2;

        Task(SynchronizedByteCodeLearn2 synchronizedByteCodeLearn2){
            this.synchronizedByteCodeLearn2 = synchronizedByteCodeLearn2;
        }

        @Override
        public void run() {
            synchronizedByteCodeLearn2.testMethod();
        }
    }


    static class Task2 implements Runnable{
        private SynchronizedByteCodeLearn2 synchronizedByteCodeLearn2 ;

        Task2(SynchronizedByteCodeLearn2 synchronizedByteCodeLearn2){
            this.synchronizedByteCodeLearn2 = synchronizedByteCodeLearn2;
        }

        @Override
        public void run() {
            synchronizedByteCodeLearn2.testMethod2();
        }
    }

    public static void main(String[] args) {
        SynchronizedByteCodeLearn2 synchronizedByteCodeLearn2 = new SynchronizedByteCodeLearn2();
        new Thread(new Task(synchronizedByteCodeLearn2)).start();
        new Thread(new Task2(synchronizedByteCodeLearn2)).start();
    }
/**
 * 字节码结构
 * Classfile /E:/ideaPro/learn/base/src/main/java/base/bytecode/SynchronizedByteCodeLearn2.class
 *   Last modified 2019-7-13; size 401 bytes
 *   MD5 checksum 0145df0c652f3b38104fe8be29831db4
 *   Compiled from "SynchronizedByteCodeLearn2.java"
 * public class base.bytecode.SynchronizedByteCodeLearn2
 *   minor version: 0
 *   major version: 52
 *   flags: ACC_PUBLIC, ACC_SUPER
 * Constant pool:
 *    #1 = Methodref          #3.#14         // java/lang/Object."<init>":()V
 *    #2 = Class              #15            // base/bytecode/SynchronizedByteCodeLearn2
 *    #3 = Class              #16            // java/lang/Object
 *    #4 = Utf8               <init>
 *    #5 = Utf8               ()V
 *    #6 = Utf8               Code
 *    #7 = Utf8               LineNumberTable
 *    #8 = Utf8               LocalVariableTable
 *    #9 = Utf8               this
 *   #10 = Utf8               Lbase/bytecode/SynchronizedByteCodeLearn2;
 *   #11 = Utf8               testMethod
 *   #12 = Utf8               SourceFile
 *   #13 = Utf8               SynchronizedByteCodeLearn2.java
 *   #14 = NameAndType        #4:#5          // "<init>":()V
 *   #15 = Utf8               base/bytecode/SynchronizedByteCodeLearn2
 *   #16 = Utf8               java/lang/Object
 * {
 *   public base.bytecode.SynchronizedByteCodeLearn2();
 *     descriptor: ()V
 *     flags: ACC_PUBLIC
 *     Code:
 *       stack=1, locals=1, args_size=1
 *          0: aload_0
 *          1: invokespecial #1                  // Method java/lang/Object."<init>":()V
 *          4: return
 *       LineNumberTable:
 *         line 9: 0
 *       LocalVariableTable:
 *         Start  Length  Slot  Name   Signature
 *             0       5     0  this   Lbase/bytecode/SynchronizedByteCodeLearn2;
 *
 *   public synchronized void testMethod();
 *     descriptor: ()V
 *     flags: ACC_PUBLIC, ACC_SYNCHRONIZED
 *     Code:
 *       stack=0, locals=1, args_size=1
 *          0: return
 *       LineNumberTable:
 *         line 13: 0
 *       LocalVariableTable:
 *         Start  Length  Slot  Name   Signature
 *             0       1     0  this   Lbase/bytecode/SynchronizedByteCodeLearn2;
 * }
 * SourceFile: "SynchronizedByteCodeLearn2.java"
 */
}
