package concurrency.consumer;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class TestWithWaitAndNotify {

    class Producer implements Runnable {

        private AtomicInteger aInt = new AtomicInteger(1);
        private final LinkedBlockingQueue<Integer> queue;

        public Producer(LinkedBlockingQueue<Integer> queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            System.out.println(String.format("producer %s start !", Thread.currentThread().getName()));
            while (true) {
                synchronized (queue) {
                    try {
                        while (queue.size() >= 10) {
                            System.out.println("queue full, not produce!");
                            queue.wait();
                        }


                        int i = aInt.getAndIncrement();
                        System.out.println(String.format("%s produce %s", Thread.currentThread().getName(), i));
                        queue.offer(i);
                        Thread.sleep(1000);

                        queue.notifyAll();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    class Consumer implements Runnable {

        private final LinkedBlockingQueue<Integer> queue;

        public Consumer(LinkedBlockingQueue<Integer> queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            System.out.println(String.format("consumer %s start !", Thread.currentThread().getName()));
            while (true) {
                synchronized (queue) {
                    try {
                        while (queue.size() == 0) {
                            System.out.println("queue empty, not consume!");
                            queue.wait();
                        }
                        Integer i = queue.poll();
                        if (i != null) {
                            System.out.println(String.format("%s consumes %s", Thread.currentThread().getName(), i));
                        } else {
                            System.out.println("queue empty, not consume!");
                            queue.wait();
                        }
                        Thread.sleep(1000);

                        queue.notifyAll();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public void start() {
        LinkedBlockingQueue<Integer> queue = new LinkedBlockingQueue<>();
        Consumer c = new Consumer(queue);
        Producer p = new Producer(queue);
        new Thread(p).start();
        new Thread(p).start();

        new Thread(c).start();
    }

    public static void main(String[] args) {
        TestWithWaitAndNotify t = new TestWithWaitAndNotify();
        t.start();
    }

}
