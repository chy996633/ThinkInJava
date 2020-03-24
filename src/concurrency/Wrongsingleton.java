package concurrency;

/**
 * 测试使用volatile 保证单例模式的原子性是不可靠的
 */
public class Wrongsingleton {
//    private static volatile Wrongsingleton _instance = null;
    private static Wrongsingleton _instance = null;

    private Wrongsingleton() {}

    public static synchronized Wrongsingleton getInstance() {

        if (_instance == null) {
            _instance = new Wrongsingleton();
            System.out.println("--initialized once.");
        }

        return _instance;
    }

    public static void setNull() {
        _instance = null;
    }

    private static void testInit(){

        Thread t1 = new Thread(new LoopInit());
        Thread t2 = new Thread(new LoopInit2());
        Thread t3 = new Thread(new LoopInit());
        Thread t4 = new Thread(new LoopInit2());
        t1.start();
        t2.start();
        t3.start();
        t4.start();

        while (t1.isAlive() || t2.isAlive() || t3.isAlive()|| t4.isAlive()) {

        }

    }

    public static void main(String[] args) {
        for(int i=0;i<1000;i++) {
            Wrongsingleton.testInit();
            System.out.println("-----------------");
            Wrongsingleton.setNull();
        }
    }

}

class LoopInit implements Runnable {

    @Override
    public void run() {
        Wrongsingleton.getInstance();
    }
}

class LoopInit2 implements Runnable {

    @Override
    public void run() {
        Wrongsingleton.getInstance();
    }
}