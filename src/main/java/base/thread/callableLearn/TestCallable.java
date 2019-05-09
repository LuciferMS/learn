package base.thread.callableLearn;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author Elliot
 * 利用Callable创建子线程
 * 博客文章：https://blog.51cto.com/13501268/2087975
 */
public class TestCallable {
    public static void main(String[] args) throws InterruptedException {
        CallDemo callDemo = new CallDemo();
        FutureTask<String> ft = new FutureTask<String>(callDemo);
        new Thread(ft, "李存孝部队->").start();
        Thread.currentThread().setName("Elliot->");
        String th_name = Thread.currentThread().getName();
        System.out.println(th_name + "休整5s");
        Thread.sleep(5000);
        System.out.println(th_name + "休整完毕");
        try {
            String str = ft.get();
            System.out.println(Thread.currentThread().getName() + "获取友军信息" + str);
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }
}
