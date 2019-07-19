package base.concurrent;

import org.springframework.jca.cci.CciOperationNotSupportedException;

import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;

/**
 * @program: learn
 * @description: CountDownLatchLearn2
 * @author: Elliot
 * @create: 2019-07-17 20:52
 * 这里使用CountDownLatch计算一个数组的每一行的和，然后合并每一行的计算结果...
 **/
public class CountDownLatchLearn2 extends Thread {

    private CountDownLatch countDownLatch;
    private Task task;
    private int[] nums;
    private int index;

    static class Task {

        private int[] nums;

        public void getSum(int[] nums, int index) {
            System.out.println("计算线程 " + Thread.currentThread().getName() + "开始工作.....");
            int sum = 0;
            for (int num : nums) {
                sum += num;
            }
            System.out.println("计算结果是:" + sum);
            this.nums[index] = sum;
        }

        public int getResult() {
            System.out.println("汇总线程 " + Thread.currentThread().getName() + "开始工作.....");
            int sum = 0;
            for (int num : nums) {
                sum += num;
            }
            System.out.println("结果是:" + sum);
            return sum;
        }

        public Task(int length) {
            this.nums = new int[length];
        }
    }

    public CountDownLatchLearn2(CountDownLatch countDownLatch, int[] nums, int index, Task task) {
        this.countDownLatch = countDownLatch;
        this.nums = nums;
        this.index = index;
        this.task = task;
    }

    @Override
    public void run() {
        task.getSum(nums, index);
        countDownLatch.countDown();
    }

    public static void main(String[] args) {
        int[][] data = {
                {1, 2, 3, 4, 5},
                {2, 2, 3, 4, 5},
                {3, 2, 3, 4, 5}
        };
        CountDownLatch countDownLatch = new CountDownLatch(3);
        Task task = new Task(3);
        for (int i = 0; i < 3; i++) {
            new CountDownLatchLearn2(countDownLatch, data[i], i, task).start();
        }
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        task.getResult();
    }


}
