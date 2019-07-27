package com.learn.base.jvm.bytecode;

/**
 * @program: learn
 * @description: 异常字节码相关学习1
 * @author: Elliot
 * @create: 2019-07-13 12:54
 * try-catch语句中，在字节码中回生成一个异常表，在运行的时候会根据生成的字节码去异常表中查找相对因的异常然后
 * 跳转到相对应的target中执行异常处理语句
 **/
public class ExceptionByteCodeLearn1 {
    /**
     * Code:
     * 0: iconst_0
     * 1: istore_1
     * 2: goto          10
     * 5: astore_1      //把异常变量压入栈中
     * 6: goto          10
     * 9: astore_1      //把异常变量压入栈中
     * 10: return
     * Exception table:
     * from    to  target type
     * 0     2     5   Class java/lang/RuntimeException
     * 0     2     9   Class java/lang/Exception
     * <p>
     * 在编译后字节码中，每个方法都附带一个异常表（Exception table），异常表
     * 的每一行表示一个异常处理器，由 from 指针、to 指针、target 指针、所捕
     * 获的异常类型 type 组成。这些指针的值是字节码索引，用于定位字节码 其含
     * 义是在[from, to)字节码范围内，抛出了异常类型为type的异常，就会跳转到
     * target表示的字节码处。 比如，上面的例子异常表表示：在0到4中间（不包含 4）
     * 如果抛出了MyException1的异常，就跳转到7执行。
     *
     * @param args
     */
    public static void main(String[] args) {
        try {
            int i = 0;
        } catch (RuntimeException e1) {

        } catch (Exception e2) {

        }
    }
}
