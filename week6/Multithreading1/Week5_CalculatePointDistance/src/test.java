import java.util.concurrent.atomic.AtomicInteger;

public class test {
    static boolean flag = false;
    static AtomicInteger ai = new AtomicInteger();

    static synchronized void increment() {
        for (int i = 0; i < 2000; i++) {
            System.out.println(ai.incrementAndGet());
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread A = new Thread(new Runnable() {
            @Override
            public void run() {
                while (!flag)
                    try {
                        wait();
                    } catch (InterruptedException e) {
                    }

                increment();
                flag = false;
                notify();
            }
        }, "A");
        Thread B = new Thread(new Runnable() {
            @Override
            public void run() {
                while (flag)
                    try {
                        wait();
                    } catch (InterruptedException e) {
                    }

                increment();
                flag = true;
                notify();
            }
        }, "B");
        A.start();
        B.start();
        A.join();
        B.join();
    }
}