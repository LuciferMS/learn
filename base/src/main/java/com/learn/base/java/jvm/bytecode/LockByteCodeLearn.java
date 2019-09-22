package com.learn.base.java.jvm.bytecode;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @program: learn
 * @description: LockByteCodeLearn
 * @author: Elliot
 * @create: 2019-08-15 14:04
 **/
public class LockByteCodeLearn {
    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        try{
            lock.lock();
        }finally {
            lock.unlock();
        }
    }
}
/*
public class com.learn.base.java.jvm.bytecode.LockByteCodeLearn {
  public com.learn.base.java.jvm.bytecode.LockByteCodeLearn();
    Code:
       0: aload_0
       1: invokespecial #1                  // Method java/lang/Object."<init>":()V
       4: return

  public static void main(java.lang.String[]);
    Code:
       0: new           #2                  // class java/util/concurrent/locks/ReentrantLock
       3: dup
       4: invokespecial #3                  // Method java/util/concurrent/locks/ReentrantLock."<init>":()V
       7: astore_1
       8: aload_1
       9: invokeinterface #4,  1            // InterfaceMethod java/util/concurrent/locks/Lock.lock:()V
      14: aload_1
      15: invokeinterface #5,  1            // InterfaceMethod java/util/concurrent/locks/Lock.unlock:()V
      20: goto          32
      23: astore_2
      24: aload_1
      25: invokeinterface #5,  1            // InterfaceMethod java/util/concurrent/locks/Lock.unlock:()V
      30: aload_2
      31: athrow
      32: return
    Exception table:
       from    to  target type
           8    14    23   any
}
 */