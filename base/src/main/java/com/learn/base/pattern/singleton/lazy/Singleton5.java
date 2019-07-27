package pattern.singleton.lazy;

import org.omg.PortableInterceptor.INACTIVE;

/**
 * @program: learn
 * @description: 线程稍微安全一点的单例
 * @author: Elliot
 * @create: 2019-06-11 17:08
 **/
public class Singleton5 {
    private static Singleton5 instance;

    private Singleton5() {

    }

    public static Singleton5 getInstance() throws InterruptedException {
        if (instance == null) {
            synchronized (Singleton5.class) {
                if (instance == null) {
                    instance = new Singleton5();
                }
            }
        }
        return instance;
    }
}
