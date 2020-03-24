package concurrency.consumer;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class TestWithPriorityQueue {

    private Boolean canProduce = true;
    private Boolean canConsume = true;
    CountDownLatch gate = new CountDownLatch(1);

    class Producer implements Runnable {

        private AtomicInteger aInt = new AtomicInteger(1);
        private final ReentrantLock lock;
        private final Condition notEmpty;
        private final Condition notFull;
        private final BlockingQueue<Integer> queue;


        public Producer(BlockingQueue<Integer> queue, ReentrantLock lock, Condition notEmpty, Condition notFull) {
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
                    if (canProduce) {
                        if (queue.size() > 10) {
                            System.out.println("queue full, not produce!");
                            canProduce = false;
                            canConsume = true;

                            //等全部生产完，开始消费
                            System.out.println("=============================can consume!=============================");
                            gate.countDown();
                        }
                        if (canProduce) {
                            int i = aInt.getAndIncrement();
                            System.out.println(String.format("%s produce %s", Thread.currentThread().getName(), i));
                            queue.offer(i);
                            System.out.println("queue items : " + queue.toString());
                            Thread.sleep(1000);
                            canConsume = true;
                        }
                    }
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    class Consumer implements Runnable {

        private final BlockingQueue<Integer> queue;
        private final ReentrantLock lock;
        private final Condition notEmpty;
        private final Condition notFull;

        public Consumer(BlockingQueue<Integer> queue, ReentrantLock lock, Condition notEmpty, Condition notFull) {
            this.queue = queue;
            this.lock = lock;
            this.notEmpty = notEmpty;
            this.notFull = notFull;
        }

        @Override
        public void run() {
            System.out.println(String.format("consumer %s start !", Thread.currentThread().getName()));
            while (true) {
                if (canConsume) {
                    try {
                        gate.await();
                        if (queue.size() == 0) {
                            System.out.println("queue empty, not consume!");
                            canConsume = false;
                            canProduce = true;
                        }
                        if (canConsume) {
                            Integer i = queue.poll();
                            if (i != null) {
                                System.out.println(String.format("%s consumes %s", Thread.currentThread().getName(), i));
                            } else {
                                canConsume = false;
                                canProduce = true;
                                System.out.println("queue empty, not consume!");
                            }
                            Thread.sleep(1000);
                            canProduce = true;
                        }
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public void start() {
        BlockingQueue<Integer> queue = new PriorityBlockingQueue<>();
        ReentrantLock lock = new ReentrantLock();
        Condition notEmpty = lock.newCondition();
        Condition notFull = lock.newCondition();

        Consumer c = new Consumer(queue, lock, notEmpty, notFull);
        Producer p = new Producer(queue, lock, notEmpty, notFull);
        new Thread(p).start();
        new Thread(p).start();
        new Thread(c).start();
        new Thread(c).start();

    }

    public static void main(String[] args) {
        TestWithPriorityQueue t = new TestWithPriorityQueue();
        t.start();
    }

}
