package base.bytecode;

/**
 * @program: learn
 * @description: SynchronizedByteCodeLearn2
 * @author: Elliot
 * @create: 2019-07-13 21:36
 **/
public class SynchronizedByteCodeLearn2 {

    /**
     * public class base.bytecode.SynchronizedByteCodeLearn2 {
     * public base.bytecode.SynchronizedByteCodeLearn2();
     * Code:
     * 0: aload_0
     * 1: invokespecial #1                  // Method java/lang/Object."<init>":()V
     * 4: return
     * <p>
     * public synchronized void testMethod();
     * Code:
     * 0: return
     * }
     * JVM 不会使用特殊的字节码来调用同步方法，当 JVM 解析方法的符号引用时，它会判断方法是不是同步的
     * （检查方法 ACC_SYNCHRONIZED 是否被设置）。如果是，执行线程会先尝试获取锁。如果是实例方法，
     * JVM 会尝试获取实例对象的锁，如果是类方法，JVM 会尝试获取类锁。在同步方法完成以后，不管是正常
     * 返回还是异常返回，都会释放锁
     */
    public synchronized void testMethod() {

    }

}
