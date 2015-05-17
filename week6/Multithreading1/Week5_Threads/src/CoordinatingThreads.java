
public class CoordinatingThreads extends Thread {
    Object lock = new Object();
    static boolean flag = false;
    static int ai = 0;

    public CoordinatingThreads() {

    }

    public synchronized void incrementA() {
        while (ai < 2000) {
            while (!flag) {
                try {
                    wait();
                } catch (InterruptedException e) {
                }
            }
            System.out.println(ai++);
            System.out.println(Thread.currentThread().getName());
            flag = false;
            notify();
        }
    }

    public synchronized void incrementB() {
        while (ai < 2000) {
            while (flag) {
                try {
                    wait();
                } catch (InterruptedException e) {
                }
            }
            System.out.println(ai++);
            System.out.println(Thread.currentThread().getName());
            flag = true;
            notify();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        CoordinatingThreads ct = new CoordinatingThreads();
        long startTime = System.currentTimeMillis();
        Thread A = new Thread(new Runnable() {
            @Override
            public void run() {
                ct.incrementA();
            }
        }, "A");
        Thread B = new Thread(new Runnable() {
            @Override
            public void run() {
                ct.incrementB();
            }
        }, "B");
        A.start();
        B.start();
        A.join();
        B.join();
        System.out.println(System.currentTimeMillis() - startTime);
    }
}
