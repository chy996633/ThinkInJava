package concurrency;

import java.util.concurrent.TimeUnit;

public class NoHappensBefore {

    private static boolean stop = false;

    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread(() -> {

            while (!stop) {
                //
                System.out.println("t1 is running");
            }
            System.out.println(Thread.currentThread().getName() + " finished");
        }, "t1");
        t1.start();

        TimeUnit.MILLISECONDS.sleep(5L);
        System.out.println("main thread awake");
        stop = true;
    }

}