package pattern.singleton.lazy;

/**
 * @program: learn
 * @description: 懒汉式延迟创建单例对象
 * @author: Elliot
 * @create: 2019-06-11 16:41
 * <p>
 * 1.私有化构造器
 * 2.提供获取实例方法
 * 3.懒加载
 **/
public class Singleton4 {
    private static Singleton4 instance;

    private Singleton4() {

    }

    public static Singleton4 getInstance() throws InterruptedException {
        if (instance == null) {
            /**
             * 存在线程安全问题
             * 如果某个线程到这里，由于种种原因，不继续执行下去了，然后后面线程来了，创建了实例
             * 这个线程恢复执行，就容易创建两个实例
             */
            Thread.sleep(1000);
            instance = new Singleton4();
        }
        return instance;
    }
}
