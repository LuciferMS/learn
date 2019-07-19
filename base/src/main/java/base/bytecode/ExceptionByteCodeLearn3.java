package base.bytecode;

/**
 * @program: learn
 * @description: ExceptionByteCodeLearn3 异常字节码相关学习3
 * @author: Elliot
 * @create: 2019-07-13 14:07
 **/

/**
 * public class base.bytecode.ExceptionByteCodeLearn3 {
 * public base.bytecode.ExceptionByteCodeLearn3();
 * Code:
 * 0: aload_0
 * 1: invokespecial #1                  // Method java/lang/Object."<init>":()V
 * 4: return
 * <p>
 * static int finallyTest();
 * Code:
 * 0: iconst_0
 * 1: istore_0
 * 2: iconst_1
 * 3: istore_0
 * 4: iload_0
 * 5: istore_1
 * 6: iinc          0, 1
 * 9: iload_1
 * 10: ireturn
 * 11: astore_1
 * 12: iinc          0, 1
 * 15: goto          24
 * 18: astore_2
 * 19: iinc          0, 1
 * 22: aload_2
 * 23: athrow
 * 24: iload_0
 * 25: ireturn
 * Exception table:
 * from    to  target type
 * 2     6    11   Class java/lang/Exception
 * 2     6    18   any
 * <p>
 * public static void main(java.lang.String[]);
 * Code:
 * 0: getstatic     #3                  // Field java/lang/System.out:Ljava/io/PrintStream;
 * 3: invokestatic  #4                  // Method finallyTest:()I
 * 6: invokevirtual #5                  // Method java/io/PrintStream.println:(I)V
 * 9: return
 * }
 */
public class ExceptionByteCodeLearn3 {
    static int finallyTest() {
        int i = 0;
        try {
            i = 1;
            return i;
        } catch (Exception e) {

        } finally {
            i++;
        }
        return i;
    }

    /**
     * 输出是 1
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(finallyTest());
    }
}
