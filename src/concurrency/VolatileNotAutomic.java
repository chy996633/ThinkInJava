package concurrency;

/**
 * 证明Volatile并不能保证原子性操作， 需要加上同步字段
 */
public class VolatileNotAutomic {

    private static volatile long _longVal = 0;

    private static final Object obj = new Object();

    private static class LoopVolatile implements Runnable {
        public void run() {
            long val = 0;
            while (val < 10000000L) {
//                synchronized (obj) {
                    _longVal++;
//                }
                val++;
            }
        }
    }

    private static class LoopVolatile2 implements Runnable {
        public void run() {
            long val = 0;
            while (val < 10000000L) {
//                synchronized (obj) {
                    _longVal++;
//                }
                val++;
            }
        }
    }

    private  void testVolatile(){
        Thread t1 = new Thread(new LoopVolatile());
        t1.start();

        Thread t2 = new Thread(new LoopVolatile());
        t2.start();

        while (t1.isAlive() || t2.isAlive()) {
        }

        System.out.println("final val is: " + _longVal);
    }

    public static void main(String[] args) {
        VolatileNotAutomic v = new VolatileNotAutomic();
        v.testVolatile();
    }

}
