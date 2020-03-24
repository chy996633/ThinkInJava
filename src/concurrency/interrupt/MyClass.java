package concurrency.interrupt;

// Java Program to illustrate the
// concept of interrupt() method
// while a thread does not stops working
class MyClass extends Thread {
    public void run()
    {
        try {
            for (int i = 0; i < 5; i++) {
                System.out.println("Child Thread executing");

                // Here current threads goes to sleeping state
                // Another thread gets the chance to execute
                Thread.sleep(1000);
            }
        }
        catch (InterruptedException e) {
            System.out.println("InterruptedException occur");
        }
    }
}

class Geeks extends Thread {
    public void run()
    {
        try {
            Thread.sleep(2000);
            System.out.println("Geeksforgeeks");
        }
        catch (InterruptedException e) {
            throw new RuntimeException("Thread " +
                    "interrupted");
        }
    }
    public static void main(String args[])
    {
        Geeks t1 = new Geeks();
        t1.start();
        try {
            t1.interrupt();
        }
        catch (Exception e) {
            System.out.println("Exception handled");
        }
    }
}

// Java Program to illustrate the concept of
// interrupt() method
class Geeks2 extends Thread {
    private static int a = 0;
    public void run()
    {
        for (int i = 0; i < 900000000; i++)
            a++;
        if(isInterrupted()) {
            return;
        }
    }
    public static void main(String args[])
    {
        Geeks t1 = new Geeks();
        t1.start();
        try{
            Thread.sleep(100);
        }catch (InterruptedException e) {
            throw new RuntimeException("Thread " +
                    "interrupted");
        }
        t1.interrupt();
        System.out.println("a :" + Geeks2.a);
    }
}


class Test {
    public static void main(String[] args)
            throws InterruptedException
    {
        MyClass thread = new MyClass();
        thread.start();

        Thread.sleep(1000);
        // main thread calls interrupt() method on
        // child thread
        thread.interrupt();

        System.out.println("Main thread execution completes");
    }
}

