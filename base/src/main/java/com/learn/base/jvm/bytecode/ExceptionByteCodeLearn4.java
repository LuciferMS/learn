package base.bytecode;


/**
 * public class base.bytecode.ExceptionByteCodeLearn4 {
 * public base.bytecode.ExceptionByteCodeLearn4();
 * Code:
 * 0: aload_0
 * 1: invokespecial #1                  // Method java/lang/Object."<init>":()V
 * 4: return
 * <p>
 * public void m1() throws java.lang.Exception;
 * Code:
 * 0: return
 * <p>
 * public void m2();
 * Code:
 * 0: aload_0
 * 1: invokevirtual #2                  // Method m1:()V
 * 4: goto          12
 * 7: astore_1
 * 8: aload_1
 * 9: invokevirtual #4                  // Method java/lang/Exception.printStackTrace:()V
 * 12: return
 * Exception table:
 * from    to  target type
 * 0     4     7   Class java/lang/Exception
 * }
 */

/**
 * @program: learn
 * @description: ExceptionByteCodeLearn4看看方法抛出异常会怎么样
 * @author: Elliot
 * @create: 2019-07-17 22:17
 * 看了一下字节码之后，发现方法抛出来的异常就在本地处理了....2333
 **/
public class ExceptionByteCodeLearn4 {

    public void m1() throws Exception {

    }

    public void m2() {
        try {
            m1();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
