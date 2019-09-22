package base.pattern;

import org.junit.Test;
import com.learn.base.pattern.singleton.lazy.Singleton4;

import java.util.concurrent.*;

/**
 * @program: learn
 * @description: 单例模式测试用例
 * @author: Elliot
 * @create: 2019-06-11 16:53
 **/
public class SingletonTest {

    @Test
    public void lazyLoadTest() throws ExecutionException, InterruptedException {
        Callable<Singleton4> c = new Callable<Singleton4>() {
            @Override
            public Singleton4 call() throws Exception {
                return Singleton4.getInstance();
            }
        };
        ExecutorService es = Executors.newFixedThreadPool(2);
        Future<Singleton4> f1 = es.submit(c);
        Future<Singleton4> f2 = es.submit(c);
        Singleton4 s1 = f1.get();
        Singleton4 s2 = f2.get();
        es.shutdown();
        System.out.println(s1 == s2);
    }
}
