package com.learn.base.jvm.bytecode;

/**
 * public class base.bytecode.SwitchByteCodeLearn1 {
 *   public base.bytecode.SwitchByteCodeLearn1();
 *     Code:
 *        0: aload_0
 *        1: invokespecial #1                  // Method java/lang/Object."<init>":()V
 *        4: return
 *
 *   public static void main(java.lang.String[]);
 *     Code:
 *        0: iconst_0
 *        1: istore_1
 *        2: iload_1
 *        3: lookupswitch  { // 2
 *                      0: 28
 *                      1: 38
 *                default: 48
 *           }
 *       28: getstatic     #2                  // Field java/lang/System.out:Ljava/io/PrintStream;
 *       31: iconst_0
 *       32: invokevirtual #3                  // Method java/io/PrintStream.println:(I)V
 *       35: goto          56
 *       38: getstatic     #2                  // Field java/lang/System.out:Ljava/io/PrintStream;
 *       41: iconst_1
 *       42: invokevirtual #3                  // Method java/io/PrintStream.println:(I)V
 *       45: goto          56
 *       48: getstatic     #2                  // Field java/lang/System.out:Ljava/io/PrintStream;
 *       51: ldc           #4                  // String default
 *       53: invokevirtual #5                  // Method java/io/PrintStream.println:(Ljava/lang/String;)V
 *       56: return
 * }
 */

/**
 * @program: learn
 * @description: SwitchByteCodeLearn1
 * @author: Elliot
 * @create: 2019-07-20 20:38
 **/
public class SwitchByteCodeLearn1 {
    public static void main(String[] args) {
        int i = 0;
        switch (i){
            case 0:
                System.out.println(0);
                break;
            case 1:
                System.out.println(1);
                break;
            default:
                System.out.println("default");
        }
    }
}
