package base.thread.callablelearn;

import java.util.concurrent.*;

/**
 * @author Elliot
 * callable接口的学些
 */
public class CallableDemo2 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        System.out.println("start:" + System.nanoTime());
        FutureTask<Long> futureTask = new FutureTask<Long>(new SumTask());
        Executor executor = Executors.newSingleThreadExecutor();
        executor.execute(futureTask);
        System.out.println(futureTask.get());
        System.out.println("End:" + System.nanoTime());
    }
    static class SumTask implements Callable<Long>{

        @Override
        public Long call() throws Exception {
            long sum = 0;
            for (int i = 0; i < 10000; i++) {
                sum += i;
            }
            return sum;
        }
    }
}
