package base.thread;

/**
 * @author Elliot
 * threadLocal学习
 */
public class ThreadLocalTest {

    private static String strLabel;

    private static ThreadLocal<String> threadLocal = new ThreadLocal();

    public static void main(String[] args) {
        strLabel = "main";
        threadLocal.set("main");
        Thread t = new Thread(() -> {
            strLabel = "child";
            threadLocal.set("child");
        });
        t.start();
        try {
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("strLabel = " + strLabel);
        System.out.println("threadLocal = " + threadLocal.get());
    }
}
