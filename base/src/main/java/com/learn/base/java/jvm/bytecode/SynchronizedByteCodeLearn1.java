package com.learn.base.jvm.bytecode;

/**
 * @program: learn
 * @description: synchronizedByteCodeLearn1
 * @author: Elliot
 * @create: 2019-07-13 20:53
 **/

/**
 * public class base.bytecode.SynchronizedByteCodeLearn1 {
 *   public base.bytecode.SynchronizedByteCodeLearn1();
 *     Code:
 *        0: aload_0
 *        1: invokespecial #1                  // Method java/lang/Object."<init>":()V
 *        4: return
 *
 *   public static void main(java.lang.String[]);
 *     Code:
 *        0: bipush        11
 *        2: invokestatic  #2                  // Method java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
 *        5: astore_1
 *        6: aload_1
 *        7: dup
 *        8: astore_2
 *
 *        9: monitorenter                     //获取锁
 *       10: aload_1
 *       11: astore_3
 *       12: aload_1
 *       13: invokevirtual #3                  // Method java/lang/Integer.intValue:()I
 *       16: iconst_1
 *       17: iadd
 *       18: invokestatic  #2                  // Method java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
 *       21: dup
 *       22: astore_1
 *       23: astore        4
 *       25: aload_3
 *       26: pop
 *       27: aload_2
 *       28: monitorexit                     //释放锁
 *
 *       29: goto          39
 *       32: astore        5
 *       34: aload_2
 *       35: monitorexit                    //释放锁
 *       36: aload         5
 *       38: athrow
 *       39: return
 *     Exception table:
 *        from    to  target type
 *           10    29    32   any
 *           32    36    32   any
 *
 *           编译器必须保证，无论同步代码块中的代码以何种方式结束（正常 return 或者异常退出），
 *      代码中每次调用 monitorenter 必须执行对应的 monitorexit 指令。为了保证这一点，编译器会
 *      自动生成一个异常处理器，这个异常处理器的目的就是为了同步代码块抛出异常时能执行 monitorexit。
 *      这也是字节码中，只有一个 monitorenter 却有两个 monitorexit 的原因
 * }
 */
public class SynchronizedByteCodeLearn1 {
    public static void main(String[] args) {
        Integer i = Integer.valueOf(11);
        synchronized (i) {
            i++;
        }
    }
}
