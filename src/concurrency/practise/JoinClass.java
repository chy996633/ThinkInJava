package concurrency.practise;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Andrew on 2016/1/22.
 */
public class JoinClass {

    public static void main(String[] args) {
        B b = new B();
//        b.start();
        b.start();
    }
}

class A implements Runnable{

    B b;

    @Override
    public void run() {
        ExecutorService service =  Executors.newCachedThreadPool();
        service.submit(b);

    }
}

class B extends Thread{
    @Override
    public void run() {
        System.out.println("B thread");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

