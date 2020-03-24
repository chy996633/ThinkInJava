package concurrency;

import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;

public class AtomicityTest implements Runnable {
    private int i = 0;
//    private AtomicInteger i = new AtomicInteger(0);
    private ReentrantLock lock = new ReentrantLock(true);

    public int getValue() { return i; }
//    public int getValue() { return i.intValue(); }
//    private void evenIncrement() { i++; }
    private void evenIncrement() {
        lock.lock();
        try {
            i++;
        } finally {
            lock.unlock();
        }
    }
//    private void evenIncrement() { i.getAndIncrement(); }
    public void run() {
        for (int j = 0 ; j < 1000000; j++) {
            evenIncrement();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService exec = Executors.newCachedThreadPool();
        AtomicityTest at = new AtomicityTest();
        long curTime = System.currentTimeMillis();
        for (int a = 0 ; a < 10; a++ ) {
            exec.execute(at);
        }

        Thread.sleep(1000);

        System.out.println(at.getValue());
        System.out.println(System.currentTimeMillis() - curTime + " ms");
        System.exit(0);
    }
}