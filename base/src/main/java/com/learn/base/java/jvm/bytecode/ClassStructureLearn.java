package com.learn.base.jvm.bytecode;

import java.io.Serializable;
/**
 *  Last modified 2019-7-21; size 1319 bytes
 *   MD5 checksum 95547ecf2f946fecc93d0edb0f01c78d
 *   Compiled from "ClassStructureLearn.java"
 * public class base.bytecode.ClassStructureLearn implements java.io.Serializable
 *           **** 版本信息 ****
 *   minor version: 0                                                                                                   //主版本号
 *   major version: 52                                                                                                  //次版本号
 *           **** 访问控制 ****
 *   flags: ACC_PUBLIC, ACC_SUPER                                                                                       //代表public类，可被继承的类
 *
 *   //常量池
 *   紧接着主版本号之后的就是常量池入口。常量池是Class文件中的资源仓库，
 *   在接下来的内容中我们会发现很多地方会涉及，如Class Name，Interfaces等。
 *   常量池中主要存储2大类常量：字面量和符号引用。字面量如文本字符串，java中声明为final的常量值等等，
 *   而符号引用如类和接口的全局限定名，字段的名称和描述符，方法的名称和描述符。
 * Constant pool:
 *    #1 = Methodref          #6.#40         // java/lang/Object."<init>":()                                            //方法引用
 *    #2 = Fieldref           #5.#41         // base/bytecode/ClassStructureLearn.username:Ljava/lang/String;           //字段引用
 *    #3 = Fieldref           #5.#42         // base/bytecode/ClassStructureLearn.password:Ljava/lang/String;
 *    #4 = Fieldref           #5.#43         // base/bytecode/ClassStructureLearn.nums:I
 *    #5 = Class              #44            // base/bytecode/ClassStructureLearn
 *    #6 = Class              #45            // java/lang/Object                                                        //父类索引
 *    #7 = Class              #46            // java/io/Serializable                                                    //接口索引
 *                        ******字段表集合*****
 *    #8 = Utf8               username
 *    #9 = Utf8               Ljava/lang/String;
 *   #10 = Utf8               password
 *   #11 = Utf8               nums
 *   #12 = Utf8               I                                                                                         //class字段
 *                        ******方法******
 *   #13 = Utf8               <init>
 *   #14 = Utf8               (Ljava/lang/String;Ljava/lang/String;)V
 *   #15 = Utf8               Code
 *   #16 = Utf8               LineNumberTable
 *   #17 = Utf8               LocalVariableTable
 *   #18 = Utf8               this
 *   #19 = Utf8               Lbase/bytecode/ClassStructureLearn;
 *   #20 = Utf8               ()V
 *   #21 = Utf8               getUsername
 *   #22 = Utf8               ()Ljava/lang/String;
 *   #23 = Utf8               setUsername
 *   #24 = Utf8               (Ljava/lang/String;)V
 *   #25 = Utf8               getPassword
 *   #26 = Utf8               setPassword
 *   #27 = Utf8               getNums
 *   #28 = Utf8               ()I
 *   #29 = Utf8               setNums
 *   #30 = Utf8               (I)V
 *   #31 = Utf8               addNums
 *   #32 = Utf8               (I)I
 *   #33 = Utf8               i
 *   #34 = Utf8               main
 *   #35 = Utf8               ([Ljava/lang/String;)V
 *   #36 = Utf8               args
 *   #37 = Utf8               [Ljava/lang/String;
 *                  ****类信息****
 *   #38 = Utf8               SourceFile
 *   #39 = Utf8               ClassStructureLearn.java
 *   #40 = NameAndType        #13:#20        // "<init>":()V
 *   #41 = NameAndType        #8:#9          // username:Ljava/lang/String;
 *   #42 = NameAndType        #10:#9         // password:Ljava/lang/String;
 *   #43 = NameAndType        #11:#12        // nums:I
 *   #44 = Utf8               base/bytecode/ClassStructureLearn
 *   #45 = Utf8               java/lang/Object
 *   #46 = Utf8               java/io/Serializable
 *
 *   //方法表
 * {
 *   public static int nums;
 *     descriptor: I
 *     flags: ACC_PUBLIC, ACC_STATIC
 *
 *   public base.bytecode.ClassStructureLearn(java.lang.String, java.lang.String);
 *     descriptor: (Ljava/lang/String;Ljava/lang/String;)V
 *     flags: ACC_PUBLIC                                                                    //访问标记
 *     Code:
 *       stack=2, locals=3, args_size=3                                                     //方法信息，栈大小，局部变量表大小，参数个数，this隐式传入
 *          0: aload_0
 *          1: invokespecial #1                  // Method java/lang/Object."<init>":()V
 *          4: aload_0
 *          5: aload_1
 *          6: putfield      #2                  // Field username:Ljava/lang/String;
 *          9: aload_0
 *         10: aload_2
 *         11: putfield      #3                  // Field password:Ljava/lang/String;
 *         14: return
 *       LineNumberTable:
 *         line 16: 0
 *         line 17: 4
 *         line 18: 9
 *         line 19: 14
 *       LocalVariableTable:                                                                //局部变量表
 *         Start  Length  Slot  Name   Signature
 *             0      15     0  this   Lbase/bytecode/ClassStructureLearn;
 *             0      15     1 username   Ljava/lang/String;
 *             0      15     2 password   Ljava/lang/String;
 *
 *   public base.bytecode.ClassStructureLearn();
 *     descriptor: ()V
 *     flags: ACC_PUBLIC
 *     Code:
 *       stack=1, locals=1, args_size=1
 *          0: aload_0
 *          1: invokespecial #1                  // Method java/lang/Object."<init>":()V
 *          4: return
 *       LineNumberTable:
 *         line 21: 0
 *         line 22: 4
 *       LocalVariableTable:
 *         Start  Length  Slot  Name   Signature
 *             0       5     0  this   Lbase/bytecode/ClassStructureLearn;
 *
 *   public java.lang.String getUsername();
 *     descriptor: ()Ljava/lang/String;
 *     flags: ACC_PUBLIC
 *     Code:
 *       stack=1, locals=1, args_size=1
 *          0: aload_0
 *          1: getfield      #2                  // Field username:Ljava/lang/String;
 *          4: areturn
 *       LineNumberTable:
 *         line 25: 0
 *       LocalVariableTable:
 *         Start  Length  Slot  Name   Signature
 *             0       5     0  this   Lbase/bytecode/ClassStructureLearn;
 *
 *   public void setUsername(java.lang.String);
 *     descriptor: (Ljava/lang/String;)V
 *     flags: ACC_PUBLIC
 *     Code:
 *       stack=2, locals=2, args_size=2
 *          0: aload_0
 *          1: aload_1
 *          2: putfield      #2                  // Field username:Ljava/lang/String;
 *          5: return
 *       LineNumberTable:
 *         line 29: 0
 *         line 30: 5
 *       LocalVariableTable:
 *         Start  Length  Slot  Name   Signature
 *             0       6     0  this   Lbase/bytecode/ClassStructureLearn;
 *             0       6     1 username   Ljava/lang/String;
 *
 *   public java.lang.String getPassword();
 *     descriptor: ()Ljava/lang/String;
 *     flags: ACC_PUBLIC
 *     Code:
 *       stack=1, locals=1, args_size=1
 *          0: aload_0
 *          1: getfield      #3                  // Field password:Ljava/lang/String;
 *          4: areturn
 *       LineNumberTable:
 *         line 33: 0
 *       LocalVariableTable:
 *         Start  Length  Slot  Name   Signature
 *             0       5     0  this   Lbase/bytecode/ClassStructureLearn;
 *
 *   public void setPassword(java.lang.String);
 *     descriptor: (Ljava/lang/String;)V
 *     flags: ACC_PUBLIC
 *     Code:
 *       stack=2, locals=2, args_size=2
 *          0: aload_0
 *          1: aload_1
 *          2: putfield      #3                  // Field password:Ljava/lang/String;
 *          5: return
 *       LineNumberTable:
 *         line 37: 0
 *         line 38: 5
 *       LocalVariableTable:
 *         Start  Length  Slot  Name   Signature
 *             0       6     0  this   Lbase/bytecode/ClassStructureLearn;
 *             0       6     1 password   Ljava/lang/String;
 *
 *   public static int getNums();
 *     descriptor: ()I
 *     flags: ACC_PUBLIC, ACC_STATIC
 *     Code:
 *       stack=1, locals=0, args_size=0
 *          0: getstatic     #4                  // Field nums:I
 *          3: ireturn
 *       LineNumberTable:
 *         line 41: 0
 *
 *   public static void setNums(int);
 *     descriptor: (I)V
 *     flags: ACC_PUBLIC, ACC_STATIC
 *     Code:
 *       stack=1, locals=1, args_size=1
 *          0: iload_0
 *          1: putstatic     #4                  // Field nums:I
 *          4: return
 *       LineNumberTable:
 *         line 45: 0
 *         line 46: 4
 *       LocalVariableTable:
 *         Start  Length  Slot  Name   Signature
 *             0       5     0  nums   I
 *
 *   public static void main(java.lang.String[]);
 *     descriptor: ([Ljava/lang/String;)V
 *     flags: ACC_PUBLIC, ACC_STATIC
 *     Code:
 *       stack=0, locals=1, args_size=1
 *          0: return
 *       LineNumberTable:
 *         line 54: 0
 *       LocalVariableTable:
 *         Start  Length  Slot  Name   Signature
 *             0       1     0  args   [Ljava/lang/String;
 * }
 * SourceFile: "ClassStructureLearn.java"
 */

/**
 * @program: learn
 * @description: 字节码结构学习
 * @author: Elliot
 * @create: 2019-07-21 18:18
 * https://mp.weixin.qq.com/s?__biz=MzIwMzYwMTk1NA==&mid=2247483835&idx=1&sn=68eabd1942b04c7bff8f8cfa63378996&chksm=96cda0f6a1ba29e0ced05a08f2468fd3eaa7785f3cb5821150aae3401f06a6511b7292665664&mpshare=1&scene=23&srcid=0320XHoLsiJgc4k13ZbepW7h#rd
 **/
public class ClassStructureLearn implements Serializable {
    private String username;
    private String password;
    public static int nums;

    public ClassStructureLearn(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public ClassStructureLearn() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static int getNums() {
        return nums;
    }

    public static void setNums(int nums) {
        ClassStructureLearn.nums = nums;
    }

    private synchronized int addNums(int i){
        return 1;
    }

    public static void main(String[] args) {

    }
}
