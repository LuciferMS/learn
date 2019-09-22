package com.learn.base.java.jvm.bytecode;

/**
 * public class com.learn.base.java.jvm.bytecode.JavaOopByteCodeLearn1 {
 *   public com.learn.base.java.jvm.bytecode.JavaOopByteCodeLearn1();
 *     Code:
 *        0: aload_0
 *        1: invokespecial #1                  // Method java/lang/Object."<init>":()V
 *        4: return
 *
 *   public static void main(java.lang.String[]);
 *     Code:
 *        0: new           #2                  // class com/learn/base/java/jvm/bytecode/JavaOopByteCodeLearn1$Sub
 *        3: dup
 *        4: invokespecial #3                  // Method com/learn/base/java/jvm/bytecode/JavaOopByteCodeLearn1$Sub."<init>":()V
 *        7: astore_1
 *        8: aload_1
 *        9: invokevirtual #4                  // Method com/learn/base/java/jvm/bytecode/JavaOopByteCodeLearn1$Parent.say:()V
 *       12: return
 * }
 */

/**
 * @program: learn
 * @description: java
 * @author: Elliot
 * @create: 2019-08-01 04:57
 **/
public class JavaOopByteCodeLearn1 {
    static class Parent{
        public void say(){
            System.out.println("i am your father");
        }

        public Parent() {

        }
    }

    static class Sub extends Parent{
        @Override
        public void say() {
            super.say();
        }

        public Sub() {
            super();
        }
    }

    public static void main(String[] args) {
        Parent sub = new Sub();
        sub.say();
    }

}
/**
 * 主类字节码
 * Last modified 2019-8-1; size 780 bytes
 *   MD5 checksum f4dcb0e07d486d7fb11947ba451b0a1c
 *   Compiled from "JavaOopByteCodeLearn1.java"
 * public class com.learn.base.java.jvm.bytecode.JavaOopByteCodeLearn1
 *   minor version: 0
 *   major version: 52
 *   flags: ACC_PUBLIC, ACC_SUPER
 * Constant pool:
 *    #1 = Methodref          #6.#26         // java/lang/Object."<init>":()V
 *    #2 = Class              #27            // com/learn/base/java/jvm/bytecode/JavaOopByteCodeLearn1$Sub
 *    #3 = Methodref          #2.#26         // com/learn/base/java/jvm/bytecode/JavaOopByteCodeLearn1$Sub."<init>":()V
 *    #4 = Methodref          #9.#28         // com/learn/base/java/jvm/bytecode/JavaOopByteCodeLearn1$Parent.say:()V
 *    #5 = Class              #29            // com/learn/base/java/jvm/bytecode/JavaOopByteCodeLearn1
 *    #6 = Class              #30            // java/lang/Object
 *    #7 = Utf8               Sub
 *    #8 = Utf8               InnerClasses
 *    #9 = Class              #31            // com/learn/base/java/jvm/bytecode/JavaOopByteCodeLearn1$Parent
 *   #10 = Utf8               Parent
 *   #11 = Utf8               <init>
 *   #12 = Utf8               ()V
 *   #13 = Utf8               Code
 *   #14 = Utf8               LineNumberTable
 *   #15 = Utf8               LocalVariableTable
 *   #16 = Utf8               this
 *   #17 = Utf8               Lcom/learn/base/java/jvm/bytecode/JavaOopByteCodeLearn1;
 *   #18 = Utf8               main
 *   #19 = Utf8               ([Ljava/lang/String;)V
 *   #20 = Utf8               args
 *   #21 = Utf8               [Ljava/lang/String;
 *   #22 = Utf8               sub
 *   #23 = Utf8               Lcom/learn/base/java/jvm/bytecode/JavaOopByteCodeLearn1$Parent;
 *   #24 = Utf8               SourceFile
 *   #25 = Utf8               JavaOopByteCodeLearn1.java
 *   #26 = NameAndType        #11:#12        // "<init>":()V
 *   #27 = Utf8               com/learn/base/java/jvm/bytecode/JavaOopByteCodeLearn1$Sub
 *   #28 = NameAndType        #32:#12        // say:()V
 *   #29 = Utf8               com/learn/base/java/jvm/bytecode/JavaOopByteCodeLearn1
 *   #30 = Utf8               java/lang/Object
 *   #31 = Utf8               com/learn/base/java/jvm/bytecode/JavaOopByteCodeLearn1$Parent
 *   #32 = Utf8               say
 * {
 *   public com.learn.base.java.jvm.bytecode.JavaOopByteCodeLearn1();
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
 *             0       5     0  this   Lcom/learn/base/java/jvm/bytecode/JavaOopByteCodeLearn1;
 *
 *   public static void main(java.lang.String[]);
 *     descriptor: ([Ljava/lang/String;)V
 *     flags: ACC_PUBLIC, ACC_STATIC
 *     Code:
 *       stack=2, locals=2, args_size=1
 *          0: new           #2                  // class com/learn/base/java/jvm/bytecode/JavaOopByteCodeLearn1$Sub
 *          3: dup
 *          4: invokespecial #3                  // Method com/learn/base/java/jvm/bytecode/JavaOopByteCodeLearn1$Sub."<init>":()V
 *          7: astore_1
 *          8: aload_1
 *          9: invokevirtual #4                  // Method com/learn/base/java/jvm/bytecode/JavaOopByteCodeLearn1$Parent.say:()V
 *         12: return
 *       LineNumberTable:
 *         line 32: 0
 *         line 33: 8
 *         line 34: 12
 *       LocalVariableTable:
 *         Start  Length  Slot  Name   Signature
 *             0      13     0  args   [Ljava/lang/String;
 *             8       5     1   sub   Lcom/learn/base/java/jvm/bytecode/JavaOopByteCodeLearn1$Parent;
 * }
 * SourceFile: "JavaOopByteCodeLearn1.java"
 * InnerClasses:
 *      static #7= #2 of #5; //Sub=class com/learn/base/java/jvm/bytecode/JavaOopByteCodeLearn1$Sub of class com/learn/base/java/jvm/bytecode/JavaOopByteCodeLearn1
 *      static #10= #9 of #5; //Parent=class com/learn/base/java/jvm/bytecode/JavaOopByteCodeLearn1$Parent of class com/learn/base/java/jvm/bytecode/JavaOopByteCodeLe
 * arn1
 */

/**子类字节码
 *  Last modified 2019-8-1; size 606 bytes
 *   MD5 checksum 95a46ae18d454298ccf6b5e598d82248
 *   Compiled from "JavaOopByteCodeLearn1.java"
 * class com.learn.base.java.jvm.bytecode.JavaOopByteCodeLearn1$Sub extends com.learn.base.java.jvm.bytecode.JavaOopByteCodeLearn1$Parent
 *   minor version: 0
 *   major version: 52
 *   flags: ACC_SUPER
 * Constant pool:
 *    #1 = Methodref          #4.#17         // com/learn/base/java/jvm/bytecode/JavaOopByteCodeLearn1$Parent.say:()V
 *    #2 = Methodref          #4.#18         // com/learn/base/java/jvm/bytecode/JavaOopByteCodeLearn1$Parent."<init>":()V
 *    #3 = Class              #20            // com/learn/base/java/jvm/bytecode/JavaOopByteCodeLearn1$Sub
 *    #4 = Class              #21            // com/learn/base/java/jvm/bytecode/JavaOopByteCodeLearn1$Parent
 *    #5 = Utf8               say
 *    #6 = Utf8               ()V
 *    #7 = Utf8               Code
 *    #8 = Utf8               LineNumberTable
 *    #9 = Utf8               LocalVariableTable
 *   #10 = Utf8               this
 *   #11 = Utf8               Sub
 *   #12 = Utf8               InnerClasses
 *   #13 = Utf8               Lcom/learn/base/java/jvm/bytecode/JavaOopByteCodeLearn1$Sub;
 *   #14 = Utf8               <init>
 *   #15 = Utf8               SourceFile
 *   #16 = Utf8               JavaOopByteCodeLearn1.java
 *   #17 = NameAndType        #5:#6          // say:()V
 *   #18 = NameAndType        #14:#6         // "<init>":()V
 *   #19 = Class              #23            // com/learn/base/java/jvm/bytecode/JavaOopByteCodeLearn1
 *   #20 = Utf8               com/learn/base/java/jvm/bytecode/JavaOopByteCodeLearn1$Sub
 *   #21 = Utf8               com/learn/base/java/jvm/bytecode/JavaOopByteCodeLearn1$Parent
 *   #22 = Utf8               Parent
 *   #23 = Utf8               com/learn/base/java/jvm/bytecode/JavaOopByteCodeLearn1
 * {
 *   public void say();
 *     descriptor: ()V
 *     flags: ACC_PUBLIC
 *     Code:
 *       stack=1, locals=1, args_size=1
 *          0: aload_0
 *          1: invokespecial #1                  // Method com/learn/base/java/jvm/bytecode/JavaOopByteCodeLearn1$Parent.say:()V
 *          4: return
 *       LineNumberTable:
 *         line 23: 0
 *         line 24: 4
 *       LocalVariableTable:
 *         Start  Length  Slot  Name   Signature
 *             0       5     0  this   Lcom/learn/base/java/jvm/bytecode/JavaOopByteCodeLearn1$Sub;
 *
 *   public com.learn.base.java.jvm.bytecode.JavaOopByteCodeLearn1$Sub();
 *     descriptor: ()V
 *     flags: ACC_PUBLIC
 *     Code:
 *       stack=1, locals=1, args_size=1
 *          0: aload_0
 *          1: invokespecial #2                  // Method com/learn/base/java/jvm/bytecode/JavaOopByteCodeLearn1$Parent."<init>":()V
 *          4: return
 *       LineNumberTable:
 *         line 27: 0
 *         line 28: 4
 *       LocalVariableTable:
 *         Start  Length  Slot  Name   Signature
 *             0       5     0  this   Lcom/learn/base/java/jvm/bytecode/JavaOopByteCodeLearn1$Sub;
 * }
 * SourceFile: "JavaOopByteCodeLearn1.java"
 * InnerClasses:
 *      static #11= #3 of #19; //Sub=class com/learn/base/java/jvm/bytecode/JavaOopByteCodeLearn1$Sub of class com/learn/base/java/jvm/bytecode/JavaOopByteCodeLearn1
 *      static #22= #4 of #19; //Parent=class com/learn/base/java/jvm/bytecode/JavaOopByteCodeLearn1$Parent of class com/learn/base/java/jvm/bytecode/JavaOopByteCodeL
 * earn1
 */

/**父类字节码
 *  minor version: 0
 *   major version: 52
 *   flags: ACC_SUPER
 * Constant pool:
 *    #1 = Fieldref           #19.#20        // java/lang/System.out:Ljava/io/PrintStream;
 *    #2 = String             #21            // i am your father
 *    #3 = Methodref          #22.#23        // java/io/PrintStream.println:(Ljava/lang/String;)V
 *    #4 = Methodref          #6.#24         // java/lang/Object."<init>":()V
 *    #5 = Class              #26            // com/learn/base/java/jvm/bytecode/JavaOopByteCodeLearn1$Parent
 *    #6 = Class              #27            // java/lang/Object
 *    #7 = Utf8               say
 *    #8 = Utf8               ()V
 *    #9 = Utf8               Code
 *   #10 = Utf8               LineNumberTable
 *   #11 = Utf8               LocalVariableTable
 *   #12 = Utf8               this
 *   #13 = Utf8               Parent
 *   #14 = Utf8               InnerClasses
 *   #15 = Utf8               Lcom/learn/base/java/jvm/bytecode/JavaOopByteCodeLearn1$Parent;
 *   #16 = Utf8               <init>
 *   #17 = Utf8               SourceFile
 *   #18 = Utf8               JavaOopByteCodeLearn1.java
 *   #19 = Class              #28            // java/lang/System
 *   #20 = NameAndType        #29:#30        // out:Ljava/io/PrintStream;
 *   #21 = Utf8               i am your father
 *   #22 = Class              #31            // java/io/PrintStream
 *   #23 = NameAndType        #32:#33        // println:(Ljava/lang/String;)V
 *   #24 = NameAndType        #16:#8         // "<init>":()V
 *   #25 = Class              #34            // com/learn/base/java/jvm/bytecode/JavaOopByteCodeLearn1
 *   #26 = Utf8               com/learn/base/java/jvm/bytecode/JavaOopByteCodeLearn1$Parent
 *   #27 = Utf8               java/lang/Object
 *   #28 = Utf8               java/lang/System
 *   #29 = Utf8               out
 *   #30 = Utf8               Ljava/io/PrintStream;
 *   #31 = Utf8               java/io/PrintStream
 *   #32 = Utf8               println
 *   #33 = Utf8               (Ljava/lang/String;)V
 *   #34 = Utf8               com/learn/base/java/jvm/bytecode/JavaOopByteCodeLearn1
 * {
 *   public void say();
 *     descriptor: ()V
 *     flags: ACC_PUBLIC
 *     Code:
 *       stack=2, locals=1, args_size=1
 *          0: getstatic     #1                  // Field java/lang/System.out:Ljava/io/PrintStream;
 *          3: ldc           #2                  // String i am your father
 *          5: invokevirtual #3                  // Method java/io/PrintStream.println:(Ljava/lang/String;)V
 *          8: return
 *       LineNumberTable:
 *         line 12: 0
 *         line 13: 8
 *       LocalVariableTable:
 *         Start  Length  Slot  Name   Signature
 *             0       9     0  this   Lcom/learn/base/java/jvm/bytecode/JavaOopByteCodeLearn1$Parent;
 *
 *   public com.learn.base.java.jvm.bytecode.JavaOopByteCodeLearn1$Parent();
 *     descriptor: ()V
 *     flags: ACC_PUBLIC
 *     Code:
 *       stack=1, locals=1, args_size=1
 *          0: aload_0
 *          1: invokespecial #4                  // Method java/lang/Object."<init>":()V
 *          4: return
 *       LineNumberTable:
 *         line 15: 0
 *         line 17: 4
 *       LocalVariableTable:
 *         Start  Length  Slot  Name   Signature
 *             0       5     0  this   Lcom/learn/base/java/jvm/bytecode/JavaOopByteCodeLearn1$Parent;
 * }
 * SourceFile: "JavaOopByteCodeLearn1.java"
 * InnerClasses:
 *      static #13= #5 of #25; //Parent=class com/learn/base/java/jvm/bytecode/JavaOopByteCodeLearn1$Parent of class com/learn/base/java/jvm/bytecode/JavaOopByteCodeL
 * earn1
 */