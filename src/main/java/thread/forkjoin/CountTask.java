package thread.forkjoin;


import java.util.concurrent.*;

/**
 * @author Elliot
 */
public class CountTask extends RecursiveTask<Long> {

    /**
     * 阈值
     */
    private static final long THRESHOLD = 10000;

    /**
     * 开始
     */
    private long start;

    /**
     * 结束
     */
    private long end;

    public CountTask(long start, long end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        long sum = 0;

        /**
         * 判断任务是否达到阈值，就是可不可以进行计算，
         * 如果可以就进行计算
         * 不可以就继续进行任务的分割
         */
        boolean canCompute = (end - start) <= THRESHOLD;

        if (canCompute){
            for (long i = start; i <= end; i++){
                sum += i;
            }
        }else{
            long middle = (start + end) / 2;
            /**
             * 将任务分割成两个子任务
             */
            CountTask left = new CountTask(start, middle);
            CountTask right = new CountTask(middle + 1, end);
            invokeAll(left, right);
            long lResult = left.join();
            long rResult = right.join();
            sum = lResult + rResult;
        }
        return sum;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        long s = System.currentTimeMillis();
        ForkJoinPool pool = ForkJoinPool.commonPool();
        CountTask countTask = new CountTask(1, 1000000000);
        Future<Long> result = pool.submit(countTask);
        if (!((ForkJoinTask<Long>)result).isCompletedAbnormally()){
            System.out.println("计算结果为:" + result.get());
        }
        System.out.println("花费时间 ：" + (System.currentTimeMillis() -s) + "ms");


        s = System.currentTimeMillis();
        long sum = 0;
        for(int i = 1; i <= 1000000000 ; i++) {
            sum += i;
        }
        System.out.println("计算结果：" + sum);
        System.out.println("普通计算花费时间：" + (System.currentTimeMillis() - s) + "ms");
    }

}
