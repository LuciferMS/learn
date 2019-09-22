package com.learn.base.java.jvm.bytecode;

import java.io.IOException;

/**
 * @program: learn
 * @description:
 * @author: Elliot
 * @create: 2019-08-01 05:25
 **/
public class JavaOopByteCodeLearn2 {

    static class Parent{
        public static int nums = 10;
        private int age;
        public Parent(int age) {
            this.age = age;
        }

        public static int getNums() {
            return nums;
        }

        public static void setNums(int nums) {
            Parent.nums = nums;
        }

        public void say(){
            System.out.println("i am your father");
        }
    }

    static class Son extends Parent{

        private int age;

        public Son(int age, int age2) {
            super(age);
            this.age = age2;
        }

        @Override
        public void say(){
            System.out.println("i am your son");
        }
    }

    public static void main(String[] args) throws IOException {
        Parent p = new Son(100, 10);
        p.say();
        System.in.read();
    }
}

/**
 *主类字节码
 *Classfile /E:/ideaPro/learn/base/src/main/java/com/learn/base/java/jvm/bytecode/JavaOopByteCodeLearn2.class
 *   Last modified 2019-8-1; size 795 bytes
 *   MD5 checksum b52edce0ccbf282ff30900461f843aa2
 *   Compiled from "JavaOopByteCodeLearn2.java"
 * public class com.learn.base.java.jvm.bytecode.JavaOopByteCodeLearn2
 *   minor version: 0
 *   major version: 52
 *   flags: ACC_PUBLIC, ACC_SUPER
 * Constant pool:
 *    #1 = Methodref          #6.#26         // java/lang/Object."<init>":()V
 *    #2 = Class              #27            // com/learn/base/java/jvm/bytecode/JavaOopByteCodeLearn2$Son
 *    #3 = Methodref          #2.#28         // com/learn/base/java/jvm/bytecode/JavaOopByteCodeLearn2$Son."<init>":(II)V
 *    #4 = Methodref          #9.#29         // com/learn/base/java/jvm/bytecode/JavaOopByteCodeLearn2$Parent.say:()V
 *    #5 = Class              #30            // com/learn/base/java/jvm/bytecode/JavaOopByteCodeLearn2
 *    #6 = Class              #31            // java/lang/Object
 *    #7 = Utf8               Son
 *    #8 = Utf8               InnerClasses
 *    #9 = Class              #32            // com/learn/base/java/jvm/bytecode/JavaOopByteCodeLearn2$Parent
 *   #10 = Utf8               Parent
 *   #11 = Utf8               <init>
 *   #12 = Utf8               ()V
 *   #13 = Utf8               Code
 *   #14 = Utf8               LineNumberTable
 *   #15 = Utf8               LocalVariableTable
 *   #16 = Utf8               this
 *   #17 = Utf8               Lcom/learn/base/java/jvm/bytecode/JavaOopByteCodeLearn2;
 *   #18 = Utf8               main
 *   #19 = Utf8               ([Ljava/lang/String;)V
 *   #20 = Utf8               args
 *   #21 = Utf8               [Ljava/lang/String;
 *   #22 = Utf8               p
 *   #23 = Utf8               Lcom/learn/base/java/jvm/bytecode/JavaOopByteCodeLearn2$Parent;
 *   #24 = Utf8               SourceFile
 *   #25 = Utf8               JavaOopByteCodeLearn2.java
 *   #26 = NameAndType        #11:#12        // "<init>":()V
 *   #27 = Utf8               com/learn/base/java/jvm/bytecode/JavaOopByteCodeLearn2$Son
 *   #28 = NameAndType        #11:#33        // "<init>":(II)V
 *   #29 = NameAndType        #34:#12        // say:()V
 *   #30 = Utf8               com/learn/base/java/jvm/bytecode/JavaOopByteCodeLearn2
 *   #31 = Utf8               java/lang/Object
 *   #32 = Utf8               com/learn/base/java/jvm/bytecode/JavaOopByteCodeLearn2$Parent
 *   #33 = Utf8               (II)V
 *   #34 = Utf8               say
 * {
 *   public com.learn.base.java.jvm.bytecode.JavaOopByteCodeLearn2();
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
 *             0       5     0  this   Lcom/learn/base/java/jvm/bytecode/JavaOopByteCodeLearn2;
 *
 *   public static void main(java.lang.String[]);
 *     descriptor: ([Ljava/lang/String;)V
 *     flags: ACC_PUBLIC, ACC_STATIC
 *     Code:
 *       stack=4, locals=2, args_size=1
 *          0: new           #2                  // class com/learn/base/java/jvm/bytecode/JavaOopByteCodeLearn2$Son
 *          3: dup
 *          4: bipush        100
 *          6: bipush        10
 *          8: invokespecial #3                  // Method com/learn/base/java/jvm/bytecode/JavaOopByteCodeLearn2$Son."<init>":(II)V
 *         11: astore_1
 *         12: aload_1
 *         13: invokevirtual #4                  // Method com/learn/base/java/jvm/bytecode/JavaOopByteCodeLearn2$Parent.say:()V
 *         16: return
 *       LineNumberTable:
 *         line 47: 0
 *         line 48: 12
 *         line 49: 16
 *       LocalVariableTable:
 *         Start  Length  Slot  Name   Signature
 *             0      17     0  args   [Ljava/lang/String;
 *            12       5     1     p   Lcom/learn/base/java/jvm/bytecode/JavaOopByteCodeLearn2$Parent;
 * }
 * SourceFile: "JavaOopByteCodeLearn2.java"
 * InnerClasses:
 *      static #7= #2 of #5; //Son=class com/learn/base/java/jvm/bytecode/JavaOopByteCodeLearn2$Son of class com/learn/base/java/jvm/bytecode/JavaOopByteCodeLearn2
 *      static #10= #9 of #5; //Parent=class com/learn/base/java/jvm/bytecode/JavaOopByteCodeLearn2$Parent of class com/learn/base/java/jvm/bytecode/JavaOopByteCodeLe
 * arn2
 */

/**
 * 父类字节码
 Classfile /E:/ideaPro/learn/base/src/main/java/com/learn/base/java/jvm/bytecode/JavaOopByteCodeLearn2$Parent.class
 Last modified 2019-8-1; size 967 bytes
 MD5 checksum 997bcd9c45b4d32e96060e0372bf18d2
 Compiled from "JavaOopByteCodeLearn2.java"
 class com.learn.base.java.jvm.bytecode.JavaOopByteCodeLearn2$Parent
 minor version: 0
 major version: 52
 flags: ACC_SUPER
 Constant pool:
 #1 = Methodref          #8.#29         // java/lang/Object."<init>":()V
 #2 = Fieldref           #7.#30         // com/learn/base/java/jvm/bytecode/JavaOopByteCodeLearn2$Parent.age:I
 #3 = Fieldref           #7.#31         // com/learn/base/java/jvm/bytecode/JavaOopByteCodeLearn2$Parent.nums:I
 #4 = Fieldref           #32.#33        // java/lang/System.out:Ljava/io/PrintStream;
 #5 = String             #34            // i am your father
 #6 = Methodref          #35.#36        // java/io/PrintStream.println:(Ljava/lang/String;)V
 #7 = Class              #38            // com/learn/base/java/jvm/bytecode/JavaOopByteCodeLearn2$Parent
 #8 = Class              #39            // java/lang/Object
 #9 = Utf8               nums
 #10 = Utf8               I
 #11 = Utf8               age
 #12 = Utf8               <init>
 #13 = Utf8               (I)V
 #14 = Utf8               Code
 #15 = Utf8               LineNumberTable
 #16 = Utf8               LocalVariableTable
 #17 = Utf8               this
 #18 = Utf8               Parent
 #19 = Utf8               InnerClasses
 #20 = Utf8               Lcom/learn/base/java/jvm/bytecode/JavaOopByteCodeLearn2$Parent;
 #21 = Utf8               getNums
 #22 = Utf8               ()I
 #23 = Utf8               setNums
 #24 = Utf8               say
 #25 = Utf8               ()V
 #26 = Utf8               <clinit>
 #27 = Utf8               SourceFile
 #28 = Utf8               JavaOopByteCodeLearn2.java
 #29 = NameAndType        #12:#25        // "<init>":()V
 #30 = NameAndType        #11:#10        // age:I
 #31 = NameAndType        #9:#10         // nums:I
 #32 = Class              #40            // java/lang/System
 #33 = NameAndType        #41:#42        // out:Ljava/io/PrintStream;
 #34 = Utf8               i am your father
 #35 = Class              #43            // java/io/PrintStream
 #36 = NameAndType        #44:#45        // println:(Ljava/lang/String;)V
 #37 = Class              #46            // com/learn/base/java/jvm/bytecode/JavaOopByteCodeLearn2
 #38 = Utf8               com/learn/base/java/jvm/bytecode/JavaOopByteCodeLearn2$Parent
 #39 = Utf8               java/lang/Object
 #40 = Utf8               java/lang/System
 #41 = Utf8               out
 #42 = Utf8               Ljava/io/PrintStream;
 #43 = Utf8               java/io/PrintStream
 #44 = Utf8               println
 #45 = Utf8               (Ljava/lang/String;)V
 #46 = Utf8               com/learn/base/java/jvm/bytecode/JavaOopByteCodeLearn2
 {
 public static int nums;
 descriptor: I
 flags: ACC_PUBLIC, ACC_STATIC

 public com.learn.base.java.jvm.bytecode.JavaOopByteCodeLearn2$Parent(int);
 descriptor: (I)V
 flags: ACC_PUBLIC
 Code:
 stack=2, locals=2, args_size=2
 0: aload_0
 1: invokespecial #1                  // Method java/lang/Object."<init>":()V
 4: aload_0
 5: iload_1
 6: putfield      #2                  // Field age:I
 9: return
 LineNumberTable:
 line 14: 0
 line 15: 4
 line 16: 9
 LocalVariableTable:
 Start  Length  Slot  Name   Signature
 0      10     0  this   Lcom/learn/base/java/jvm/bytecode/JavaOopByteCodeLearn2$Parent;
 0      10     1   age   I

 public static int getNums();
 descriptor: ()I
 flags: ACC_PUBLIC, ACC_STATIC
 Code:
 stack=1, locals=0, args_size=0
 0: getstatic     #3                  // Field nums:I
 3: ireturn
 LineNumberTable:
 line 19: 0

 public static void setNums(int);
 descriptor: (I)V
 flags: ACC_PUBLIC, ACC_STATIC
 Code:
 stack=1, locals=1, args_size=1
 0: iload_0
 1: putstatic     #3                  // Field nums:I
 4: return
 LineNumberTable:
 line 23: 0
 line 24: 4
 LocalVariableTable:
 Start  Length  Slot  Name   Signature
 0       5     0  nums   I

 public void say();
 descriptor: ()V
 flags: ACC_PUBLIC
 Code:
 stack=2, locals=1, args_size=1
 0: getstatic     #4                  // Field java/lang/System.out:Ljava/io/PrintStream;
 3: ldc           #5                  // String i am your father
 5: invokevirtual #6                  // Method java/io/PrintStream.println:(Ljava/lang/String;)V
 8: return
 LineNumberTable:
 line 27: 0
 line 28: 8
 LocalVariableTable:
 Start  Length  Slot  Name   Signature
 0       9     0  this   Lcom/learn/base/java/jvm/bytecode/JavaOopByteCodeLearn2$Parent;

 static {};
 descriptor: ()V
 flags: ACC_STATIC
 Code:
 stack=1, locals=0, args_size=0
 0: bipush        10
 2: putstatic     #3                  // Field nums:I
 5: return
 LineNumberTable:
 line 12: 0
 }
 SourceFile: "JavaOopByteCodeLearn2.java"
 InnerClasses:
 static #18= #7 of #37; //Parent=class com/learn/base/java/jvm/bytecode/JavaOopByteCodeLearn2$Parent of class com/learn/base/java/jvm/bytecode/JavaOopByteCodeL
 earn2

 */

/**
 *子类字节码
 *class com.learn.base.java.jvm.bytecode.JavaOopByteCodeLearn2$Son extends com.learn.base.java.jvm.bytecode.JavaOopByteCodeLearn2$Parent
 *   minor version: 0
 *   major version: 52
 *   flags: ACC_SUPER
 * Constant pool:
 *    #1 = Methodref          #7.#24         // com/learn/base/java/jvm/bytecode/JavaOopByteCodeLearn2$Parent."<init>":(I)V
 *    #2 = Fieldref           #6.#25         // com/learn/base/java/jvm/bytecode/JavaOopByteCodeLearn2$Son.age:I
 *    #3 = Fieldref           #26.#27        // java/lang/System.out:Ljava/io/PrintStream;
 *    #4 = String             #28            // i am your son
 *    #5 = Methodref          #29.#30        // java/io/PrintStream.println:(Ljava/lang/String;)V
 *    #6 = Class              #32            // com/learn/base/java/jvm/bytecode/JavaOopByteCodeLearn2$Son
 *    #7 = Class              #33            // com/learn/base/java/jvm/bytecode/JavaOopByteCodeLearn2$Parent
 *    #8 = Utf8               age
 *    #9 = Utf8               I
 *   #10 = Utf8               <init>
 *   #11 = Utf8               (II)V
 *   #12 = Utf8               Code
 *   #13 = Utf8               LineNumberTable
 *   #14 = Utf8               LocalVariableTable
 *   #15 = Utf8               this
 *   #16 = Utf8               Son
 *   #17 = Utf8               InnerClasses
 *   #18 = Utf8               Lcom/learn/base/java/jvm/bytecode/JavaOopByteCodeLearn2$Son;
 *   #19 = Utf8               age2
 *   #20 = Utf8               say
 *   #21 = Utf8               ()V
 *   #22 = Utf8               SourceFile
 *   #23 = Utf8               JavaOopByteCodeLearn2.java
 *   #24 = NameAndType        #10:#35        // "<init>":(I)V
 *   #25 = NameAndType        #8:#9          // age:I
 *   #26 = Class              #36            // java/lang/System
 *   #27 = NameAndType        #37:#38        // out:Ljava/io/PrintStream;
 *   #28 = Utf8               i am your son
 *   #29 = Class              #39            // java/io/PrintStream
 *   #30 = NameAndType        #40:#41        // println:(Ljava/lang/String;)V
 *   #31 = Class              #42            // com/learn/base/java/jvm/bytecode/JavaOopByteCodeLearn2
 *   #32 = Utf8               com/learn/base/java/jvm/bytecode/JavaOopByteCodeLearn2$Son
 *   #33 = Utf8               com/learn/base/java/jvm/bytecode/JavaOopByteCodeLearn2$Parent
 *   #34 = Utf8               Parent
 *   #35 = Utf8               (I)V
 *   #36 = Utf8               java/lang/System
 *   #37 = Utf8               out
 *   #38 = Utf8               Ljava/io/PrintStream;
 *   #39 = Utf8               java/io/PrintStream
 *   #40 = Utf8               println
 *   #41 = Utf8               (Ljava/lang/String;)V
 *   #42 = Utf8               com/learn/base/java/jvm/bytecode/JavaOopByteCodeLearn2
 * {
 *   public com.learn.base.java.jvm.bytecode.JavaOopByteCodeLearn2$Son(int, int);
 *     descriptor: (II)V
 *     flags: ACC_PUBLIC
 *     Code:
 *       stack=2, locals=3, args_size=3
 *          0: aload_0
 *          1: iload_1
 *          2: invokespecial #1                  // Method com/learn/base/java/jvm/bytecode/JavaOopByteCodeLearn2$Parent."<init>":(I)V
 *          5: aload_0
 *          6: iload_2
 *          7: putfield      #2                  // Field age:I
 *         10: return
 *       LineNumberTable:
 *         line 36: 0
 *         line 37: 5
 *         line 38: 10
 *       LocalVariableTable:
 *         Start  Length  Slot  Name   Signature
 *             0      11     0  this   Lcom/learn/base/java/jvm/bytecode/JavaOopByteCodeLearn2$Son;
 *             0      11     1   age   I
 *             0      11     2  age2   I
 *
 *   public void say();
 *     descriptor: ()V
 *     flags: ACC_PUBLIC
 *     Code:
 *       stack=2, locals=1, args_size=1
 *          0: getstatic     #3                  // Field java/lang/System.out:Ljava/io/PrintStream;
 *          3: ldc           #4                  // String i am your son
 *          5: invokevirtual #5                  // Method java/io/PrintStream.println:(Ljava/lang/String;)V
 *          8: return
 *       LineNumberTable:
 *         line 42: 0
 *         line 43: 8
 *       LocalVariableTable:
 *         Start  Length  Slot  Name   Signature
 *             0       9     0  this   Lcom/learn/base/java/jvm/bytecode/JavaOopByteCodeLearn2$Son;
 * }
 * SourceFile: "JavaOopByteCodeLearn2.java"
 * InnerClasses:
 *      static #16= #6 of #31; //Son=class com/learn/base/java/jvm/bytecode/JavaOopByteCodeLearn2$Son of class com/learn/base/java/jvm/bytecode/JavaOopByteCodeLearn2
 *      static #34= #7 of #31; //Parent=class com/learn/base/java/jvm/bytecode/JavaOopByteCodeLearn2$Parent of class com/learn/base/java/jvm/bytecode/JavaOopByteCodeL
 * earn2
 */