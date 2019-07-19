package base.bytecode;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

/**
 * @program: learn
 * @description: 句柄学习
 * @author: Elliot
 * @create: 2019-07-11 19:47
 **/
public class MethodHandleLearn {
    /**
     * java句柄是java7加入的一个东西，为了处理invokeDynamic指令，首先我们要说一个叫鸭子类型的东西，
     * 鸭子类型： 只要这个东西具有鸭子的特性，我就认为他是一直鸭子
     * 句柄就是，只要具有与这个方法一样的签名，就可以认为是同一个方法
     *
     * @param args
     * @throws Throwable
     */
    public static void main(String[] args) throws Throwable {
        MethodHandleLearn m = new MethodHandleLearn();
        MethodType methodType = MethodType.methodType(void.class, String.class);
        MethodHandle methodHandle = MethodHandles.lookup().findVirtual(MethodHandleLearn.class, "print", methodType);
        methodHandle.invokeExact(m, "hello world");
    }

    public void print(String s) {
        System.out.println(s);
    }
}
