package concurrency;

/**
 * Created by Andrew on 2015/10/28.
 */
public class OutputThread implements Runnable {

    private int num;
    private Object lock;

    public OutputThread(int num,Object obj){
        this.num = num;
        this.lock = obj;
    }

    @Override
    public void run() {
        try{
        while(true) {
            synchronized (lock){
                lock.notifyAll();
                lock.wait();
                System.out.println(num);
            }

        }}catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        final Object obj = new Object();
        Thread thread1 = new Thread(new OutputThread(0,obj));
        Thread thread2 = new Thread(new OutputThread(1,obj));

        thread1.start();
        thread2.start();

    }
}
