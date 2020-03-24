package concurrency.consumer;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class TestWithLockAndCondition {

    class Producer implements Runnable {

        private AtomicInteger aInt = new AtomicInteger(1);
        private final ReentrantLock lock;
        private final Condition notEmpty;
        private final Condition notFull;
        private final LinkedBlockingQueue<Integer> queue;

        public Producer(LinkedBlockingQueue<Integer> queue, ReentrantLock lock, Condition notEmpty, Condition notFull) {
            this.queue = queue;
            this.lock = lock;
            this.notEmpty = notEmpty;
            this.notFull = notFull;
        }

        @Override
        public void run() {
            System.out.println(String.format("producer %s start !", Thread.currentThread().getName()));
            while (true) {
                try {
                    lock.lock();
                    while (queue.size() > 10) {
                        System.out.println("queue full, not produce!");
                        notEmpty.await();
                    }

                    int i = aInt.getAndIncrement();
                    System.out.println(String.format("%s produce %s", Thread.currentThread().getName(), i));
                    queue.offer(i);
                    notFull.signalAll();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    lock.unlock();
                }

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    class Consumer implements Runnable {

        private final LinkedBlockingQueue<Integer> queue;
        private final ReentrantLock lock;
        private final Condition notEmpty;
        private final Condition notFull;

        public Consumer(LinkedBlockingQueue<Integer> queue, ReentrantLock lock, Condition notEmpty, Condition notFull) {
            this.queue = queue;
            this.lock = lock;
            this.notEmpty = notEmpty;
            this.notFull = notFull;
        }

        @Override
        public void run() {
            System.out.println(String.format("consumer %s start !", Thread.currentThread().getName()));
            while (true) {

                try {
                    lock.lock();
                    while (queue.size() == 0) {
                        System.out.println("queue empty, not consume!");
                        notFull.await();
                    }

                    Integer i = queue.poll();
                    if (i != null) {
                        System.out.println(String.format("%s consumes %s", Thread.currentThread().getName(), i));
                    } else {
                        notFull.await();
                        System.out.println("queue empty, not consume!");
                    }

                    notEmpty.signalAll();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
    }

    public void start() {
        LinkedBlockingQueue<Integer> queue = new LinkedBlockingQueue<>();
        ReentrantLock lock = new ReentrantLock();
        Condition notEmpty = lock.newCondition();
        Condition notFull = lock.newCondition();
        Consumer c = new Consumer(queue, lock, notEmpty, notFull);
        Producer p = new Producer(queue, lock, notEmpty, notFull);
        new Thread(p).start();
        new Thread(p).start();

        new Thread(c).start();
    }

    public static void main(String[] args) {
        TestWithLockAndCondition t = new TestWithLockAndCondition();
        t.start();
    }

}
