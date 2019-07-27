package base.thread;


import java.util.concurrent.*;

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
         *           直接提交。
         *                  工作队列的默认选项是 SynchronousQueue，它将任务直接提交给线程而不保持它们。
         *                  在此，如果不存在可用于立即运行任务的线程，则试图把任务加入队列将失败，因此
         *                  会构造一个新的线程。此策略可以避免在处理可能具有内部依赖性的请求集时出现锁。
         *                  直接提交通常要求无界 maximumPoolSizes 以避免拒绝新提交的任务。当命令以超过
         *                  队列所能处理的平均数连续到达时，此策略允许无界线程具有增长的可能性。
         *           无界队列。
         *                  使用无界队列（例如，不具有预定义容量的 LinkedBlockingQueue）将导致在
         *                  所有 corePoolSize 线程都忙时新任务在队列中等待。这样，创建的线程就不会
         *                  超过 corePoolSize。（因此，maximumPoolSize 的值也就无效了。）当每个
         *                  任务完全独立于其他任务，即任务执行互不影响时，适合于使用无界队列；
         *                  例如，在 Web 页服务器中。这种排队可用于处理瞬态突发请求，当命令以超过
         *                  队列所能处理的平均数连续到达时，此策略允许无界线程具有增长的可能性。
         *           有界队列。
         *                  当使用有限的 maximumPoolSizes 时，有界队列（如 ArrayBlockingQueue）
         *                  有助于防止资源耗尽，但是可能较难调整和控制。队列大小和最大池大小可能需
         *                  要相互折衷：使用大型队列和小型池可以最大限度地降低 CPU 使用率、操作系
         *                  统资源和上下文切换开销，但是可能导致人工降低吞吐量。如果任务频繁阻塞（
         *                  例如，如果它们是 I/O 边界），则系统可能为超过您许可的更多线程安排时间。
         *                  使用小型队列通常要求较大的池大小，CPU 使用率较高，但是可能遇到不可接受
         *                  的调度开销，这样也会降低吞吐量。
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
            /**
             * 这里我没有调用sumbit方法，但是需要知道的是，调用线程池的submit方法提交任务，
             * 会返回一个FutureTask对象，表示异步执行的任务
             * 其实这里调用sumbit方法也没什么，因为submit也会调用execute
             * 具体方法在AbstractExecutorsService里面
             *
             * 执行execute()方法和submit()方法的区别是什么呢？
             * 1)execute()方法用于提交不需要返回值的任务，所以无法判断任务是否被线程池执行成功与否；
             * 2)submit()方法用于提交需要返回值的任务。线程池会返回一个future类型的对象，通过这个
             * future对象可以判断任务是否执行成功，并且可以通过future的get()方法来获取返回值，
             * get()方法会阻塞当前线程直到任务完成，而使用get（long timeout，TimeUnit unit）
             * 方法则会阻塞当前线程一段时间后立即返回，这时候有可能任务没有执行完。
             */
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

    /**
     * 这里实现的是runnable的任务类
     * 实际上线程池可以提交实现callable的任务，
     * submit之后可以返回一个futureTask对象来操作这个任务
     */
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
