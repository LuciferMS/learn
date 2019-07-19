package base.thread;

/**
 * @program: learn
 * @description: 线程交替打印
 * @author: Elliot
 * @create: 2019-07-14 08:42
 * 三条线程共享一个实例，实例中设置了三个信号量，当某条线程满足条件的时候就打印数字
 **/
public class ThreadPrint {
    public static void main(String[] args) {
        Print print = new Print();
        RunnableA runnableA = new RunnableA(print);
        RunnableB runnableB = new RunnableB(print);
        RunnableC runnableC = new RunnableC(print);
        Thread t1 = new Thread(runnableA);
        Thread t2 = new Thread(runnableB);
        Thread t3 = new Thread(runnableC);
        t1.start();
        t2.start();
        t3.start();
    }

    static class Print {
        private boolean mutexA = true;
        private boolean mutexB = false;
        private boolean mutexC = false;
        private int i = 1;

        public boolean isMutexA() {
            return mutexA;
        }

        public void setMutexA(boolean mutexA) {
            this.mutexA = mutexA;
        }

        public boolean isMutexB() {
            return mutexB;
        }

        public void setMutexB(boolean mutexB) {
            this.mutexB = mutexB;
        }

        public boolean isMutexC() {
            return mutexC;
        }

        public void setMutexC(boolean mutexC) {
            this.mutexC = mutexC;
        }

        public int getI() {
            return i;
        }

        public void setI(int i) {
            this.i = i;
        }

        public Print(boolean mutexA, boolean mutexB, boolean mutexC, int i) {
            this.mutexA = mutexA;
            this.mutexB = mutexB;
            this.mutexC = mutexC;
            this.i = i;
        }

        public Print() {
        }
    }

    static class RunnableA implements Runnable {

        private Print print;

        public RunnableA(Print print) {
            this.print = print;
        }

        @Override
        public void run() {
            while (true) {
                synchronized (print) {
                    if (print.isMutexA()) {
                        int i = print.getI();
                        System.out.println("thread A:" + i);
                        print.setI(i + 1);
                        print.setMutexA(false);
                        print.setMutexB(true);
                    }
                }
            }
        }
    }

    static class RunnableB implements Runnable {

        private Print print;

        public RunnableB(Print print) {
            this.print = print;
        }

        @Override
        public void run() {
            while (true) {
                synchronized (print) {
                    if (print.isMutexB()) {
                        int i = print.getI();
                        System.out.println("thread B:" + i);
                        print.setI(i + 1);
                        print.setMutexB(false);
                        print.setMutexC(true);
                    }
                }
            }
        }
    }

    static class RunnableC implements Runnable {

        private Print print;

        public RunnableC(Print print) {
            this.print = print;
        }

        @Override
        public void run() {
            while (true) {
                synchronized (print) {
                    if (print.isMutexC()) {
                        int i = print.getI();
                        System.out.println("thread C:" + i);
                        print.setI(i + 1);
                        print.setMutexC(false);
                        print.setMutexA(true);
                    }
                }
            }
        }
    }
}
