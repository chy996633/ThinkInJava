package concurrency;

import java.io.IOException;

public class DaemonTest implements Runnable {

    static class Runnable1 implements Runnable {

        @Override
        public void run() {
            for (int i = 0; ; i++) {
                try {
                    Thread.sleep(1000);
                    if (i == 10) {
                        return;
                    }
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
                System.out.println("R1 :"+i);
            }
        }
    }

    static class Runnable2 implements Runnable {

        @Override
        public void run() {
            int i = 0;
            try {
                while (true) {
                    System.out.println("R2 :"+i);
                    i++;
                    Thread.sleep(1000);
                }
            } catch (InterruptedException ignored) {
                ignored.printStackTrace();
            }

        }
    }


    public void run() {
        for (int i = 0; ; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
            }
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        Runnable1 r1 = new Runnable1();
        Thread t = new Thread(r1);
//        t.setDaemon(true);
        t.start();

        Runnable2 r2 = new Runnable2();
        Thread t2 = new Thread(r2);
        t2.setDaemon(true);
        t2.start();

//        test.setDaemon(true);    //调试时可以设置为false，那么这个程序是个死循环，没有退出条件。设置为true，即可主线程结束，test线程也结束。
//        test.start();
//        System.out.println("isDaemon = " + test.isDaemon());
        try {
            System.in.read();   // 接受输入，使程序在此停顿，一旦接收到用户输入，main线程结束，守护线程自动结束
            System.out.printf("exit");
        } catch (IOException ex) {
        }
    }
}