package base.concurrent;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @program: learn
 * @description: CountDownLatch学习
 * @author: Elliot
 * @create: 2019-07-17 18:05
 * 倒计时器
 * 多个任务执行完毕之后，才会触发后面代码的执行。。。其本质是一个用aqs实现的共享锁
 **/
public class CountDownLatchLearn implements Runnable {

    /**
     * 初始化倒计时器，给一个int的值，其实质就是初始化aqs的state状态
     */
    static final CountDownLatch LATCH = new CountDownLatch(10);
    static final CountDownLatchLearn LEARN = new CountDownLatchLearn();

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName() + "这个任务做完了.....");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            /**
             * 没执行一次这个方法，state就会减1,直到state的值是0就算是子任务都完成了...
             */
            LATCH.countDown();
        }
    }


    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 10; i++) {
            executorService.submit(LEARN);
        }
        try {
            /**
             * 阻塞式等待子任务都执行完，才会继续执行下面的代码....
             */
            LATCH.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("任务都做完啦....");
        executorService.shutdown();
    }
}
