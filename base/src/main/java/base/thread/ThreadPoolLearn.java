package base.thread;


import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author Elliot
 * 线程池的学习
 * 线程池处理任务过程：一开始的时候线程池是没有线程的，当任务来的时候才开始创建线程，当线程数量达到核心线程数量的时候
 * 才开始使用阻塞列队存储任务，当阻塞列队满了的时候就开始创建新的线程，当线程数量大于maximumPoolSize的时候就开
 * 始使用拒绝策略
 * 线程池任务：   线程池处理三种任务，从Api可以看出来
 * submit(Callable<T> task)
 * submit(Runnable task);
 * submit(Runnable task, T result);
 */
public class ThreadPoolLearn {

    public static void main(String[] args) {
        /**
         * 1.创建线程池的几个参数
         * corePoolSize: 核心线程数量，线程池创建之初并没有线程存在，而是等待任务的到来才创建线程，但是可以调用preStartAllCoreThreads()或preStartCoreThread()
         *               方法创建所有线程或一个线程
         * maximumPoolSize: 线程的最大数量，当线程池内线程数量大于maximumPoolSize的时候就开始使用拒绝策略
         * keepAliveTime: 线程在无任务可做的时候的存活时间，默认情况下当线程数量大于corePoolSize的时候这个参数才会排上用场,也就是说，
         *                默认情况下线程数量会保持在corePoolSize
         *                及以上，如果调用allowCoreThreadTimeOut(boolean)方法，就可以允许所有线程都被回收
         * Unit: 线程存活时间的单位，是一个枚举类，详情可以看代码。。。
         * workQueue: 存放任务的缓存列队,一般有下面三种选择
         *            1.ArrayBlockQueue
         *            2.LinkedBlockingQueue
         *            3.SynchronousQueue
         * threadFactory: 线程工厂，用来创建线程
         * handler: 表示拒绝策略,有下面四种：
         *              1.ThreadPoolExecutor.AbortPolicy:丢弃任务并抛出RejectedExecutionException异常。默认。
         *              2.ThreadPoolExecutor.DiscardPolicy：也是丢弃任务，但是不抛出异常。
         *              3.ThreadPoolExecutor.DiscardOldestPolicy：丢弃队列最前面的任务，然后重新尝试执行任务（重复此过程）
         *              4.ThreadPoolExecutor.CallerRunsPolicy：由调用线程处理该任务
         * 2.java doc中不提倡我们这样创建线程池，提供了三种方式给我们
         *          2.1.Executors.newCachedThreadPool() 创建缓冲池，池子容量是Integer.MAX_VALUE
         *          2.2.Executors.newSingleThreadExecutor() 创建一个容量为1的缓冲池
         *          2.3.Executors.newFixedThreadPool(int) 创建一个固定大小的缓冲池
         * 3.线程池状态:
         *              static final int RUNNING    = 0;
         *              static final int SHUTDOWN   = 1;
         *              static final int STOP       = 2;
         *              static final int TERMINATED = 3;
         */
        ThreadPoolExecutor pool = new ThreadPoolExecutor(
                5,
                10,
                200,
                TimeUnit.MINUTES,
                new ArrayBlockingQueue<Runnable>(5));
        int task = 20;
        for (int i = 0; i < task; i++) {
            MyTask myTask = new MyTask(i);
            pool.execute(myTask);
            System.out.println("线程池中线程数目" + pool.getPoolSize()
                    + ", 列队中等待执行任务 " + pool.getQueue().size()
                    + ",已经执行完别的任务 " + pool.getCompletedTaskCount());
        }
        /**
         * 线程池有两种关闭方式：
         *      1.shutdown() : 线程池处于SHUTDOWN状态,此时线程池不会接受新的任务，会等待所有任务执行完毕
         *      2.shutdownNow() : 线程池处于STOP状态，此时线程池不会接受新的任务，并且回去尝试结束正在执行的任务
         * 当线程池处于SHUTDOWN或者STOP状态的时候,并且所有工作线程已经销毁，任务缓存队列已经清空或执行结束后，线程
         * 池被设置为TERMINATED状态。
         */
        pool.shutdown();
    }

    static class MyTask implements Runnable {

        private int taskNum;

        public MyTask(int taskNum) {
            this.taskNum = taskNum;
        }

        @Override
        public void run() {
            System.out.println("正在执行task " + taskNum);
            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("task" + taskNum + "执行完毕");
        }
    }

}
