package com.learn.base.java.jvm.bytecode;
/**
 * public class base.bytecode.SwitchByteCodeLearn2 {
 *   public base.bytecode.SwitchByteCodeLearn2();
 *     Code:
 *        0: aload_0
 *        1: invokespecial #1                  // Method java/lang/Object."<init>":()V
 *        4: return
 *
 *   public static void main(java.lang.String[]);
 *     Code:
 *        0: ldc           #2                  // String Aa
 *        2: astore_1
 *        3: aload_1
 *        4: astore_2
 *        5: iconst_m1
 *        6: istore_3
 *        7: aload_2
 *        8: invokevirtual #3                  // Method java/lang/String.hashCode:()I
 *       11: lookupswitch  { // 1
 *                   2112: 28
 *                default: 53
 *           }
 *       28: aload_2
 *       29: ldc           #4                  // String BB
 *       31: invokevirtual #5                  // Method java/lang/String.equals:(Ljava/lang/Object;)Z
 *       34: ifeq          42
 *       37: iconst_1
 *       38: istore_3
 *       39: goto          53
 *       42: aload_2
 *       43: ldc           #2                  // String Aa
 *       45: invokevirtual #5                  // Method java/lang/String.equals:(Ljava/lang/Object;)Z
 *       48: ifeq          53
 *       51: iconst_0
 *       52: istore_3
 *       53: iload_3
 *       54: lookupswitch  { // 2
 *                      0: 80
 *                      1: 91
 *                default: 102
 *           }
 *       80: getstatic     #6                  // Field java/lang/System.out:Ljava/io/PrintStream;
 *       83: ldc           #2                  // String Aa
 *       85: invokevirtual #7                  // Method java/io/PrintStream.println:(Ljava/lang/String;)V
 *       88: goto          110
 *       91: getstatic     #6                  // Field java/lang/System.out:Ljava/io/PrintStream;
 *       94: ldc           #4                  // String BB
 *       96: invokevirtual #7                  // Method java/io/PrintStream.println:(Ljava/lang/String;)V
 *       99: goto          110
 *      102: getstatic     #6                  // Field java/lang/System.out:Ljava/io/PrintStream;
 *      105: ldc           #8                  // String default
 *      107: invokevirtual #7                  // Method java/io/PrintStream.println:(Ljava/lang/String;)V
 *      110: return
 * }
 */

/**
 * @program: learn
 * @description: SwitchByteCodeLearn2
 * @author: Elliot
 * @create: 2019-07-20 21:05
 **/
public class SwitchByteCodeLearn2 {
    /**
     * case String的时候实际上是对hash值进行一个匹配
     * 所以不难解释为什么s是null的时候会返回NullPointException
     * @param args
     */
    public static void main(String[] args) {
        String s = "Aa";
        switch (s){
            case "Aa":
                System.out.println("Aa");
                break;
            case "BB":
                System.out.println("BB");
                break;
                default:
                    System.out.println("default");
        }
    }
}
