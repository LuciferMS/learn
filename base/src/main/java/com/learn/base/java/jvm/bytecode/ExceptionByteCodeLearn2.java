package com.learn.base.jvm.bytecode;

/**
 * @program: learn
 * @description: ExceptionByteCodeLearn2 异常字节码相关学习2
 * @author: Elliot
 * @create: 2019-07-13 13:15
 **/
public class ExceptionByteCodeLearn2 {
    /**
     * Code:
     * 0: iconst_0
     * 1: istore_1
     * 2: iconst_1
     * 3: istore_1
     * 4: iinc          1, 1     //finally内容
     * 7: goto          30
     * 10: astore_2
     * 11: iinc          1, 1    //finally内容
     * 14: goto          30
     * 17: astore_2
     * 18: iinc          1, 1    //finally内容
     * 21: goto          30
     * 24: astore_3
     * 25: iinc          1, 1    //finally内容
     * 28: aload_3
     * 29: athrow
     * 30: return
     * Exception table:
     * from    to  target type
     * 2     4    10   Class java/lang/RuntimeException
     * 2     4    17   Class java/lang/Exception
     * 2     4    24   any
     * Java 采用方式是复制 finally 代码块的内容，分别放在 try catch 代码块所有正常 return 和 异常 throw 之前。
     *
     * @param args
     */
    public static void main(String[] args) {
        int i = 0;
        try {
            i = 1;
        } catch (RuntimeException e1) {

        } catch (Exception e2) {

        } finally {
            i++;
        }
    }
}
