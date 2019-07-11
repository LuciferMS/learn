package base.thread.callablelearn.callable2;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @program: learn
 * @description: Callable学习3
 * @author: Elliot
 * @create: 2019-07-09 23:47
 **/
public class CallableLearn3 {
    public static void main(String[] args) {
        FutureTask<String> futureTask = new FutureTask<String>(new Callable<String>() {
            @Override
            public String call() throws Exception {
                System.out.println("hello");
                return "Hello";
            }
        });
        Thread t = new Thread(futureTask);
        t.start();
    }
}
