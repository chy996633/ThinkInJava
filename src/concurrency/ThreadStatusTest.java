package concurrency;

public class ThreadStatusTest {

    public static void main(String[] args) throws InterruptedException {

        Run run = new Run();
        Thread t = new Thread(run, "t");
        //new
//        System.out.println(Thread.currentThread().getName() + "  t status : " + t.getState());

        t.start();
        //runnable
//        System.out.println(Thread.currentThread().getName() + "  t status : " + t.getState());

        Thread.sleep(100);
        Thread t2 = new Thread(run, "t2");
        t2.start();
        Thread.sleep(500);

        //blocked
//        System.out.println(Thread.currentThread().getName() + "  t2 status : " + t2.getState());

        Thread.sleep(2000);
        //timed_waiting
//        System.out.println(Thread.currentThread().getName() + "  t status : " + t.getState());
        t.join();
        t2.join();

        System.out.println("所有线程结束");


    }

}


class Run implements Runnable {

    private Object obj = new Object();


    public void run() {

        synchronized (obj) {
            try {
                System.out.println(Thread.currentThread().getName() + " enter run");
                obj.notify();
                Thread.sleep(2000);
                System.out.println(Thread.currentThread().getName() + " after notify, start sleep ");
                Thread.sleep(4000);
                System.out.println(Thread.currentThread().getName() + " after sleep, start wait obj ");
                obj.wait(2000);
                System.out.println(Thread.currentThread().getName() + " after wait obj, finish run ");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}