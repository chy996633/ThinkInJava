package concurrency;

import com.sun.xml.internal.ws.util.StringUtils;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Test {

    public Runnable getRunnable(String str) {

        Runnable ru = null;
        try {
            ru = (Runnable) Class.forName(str).newInstance();
        } catch (InstantiationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return ru;
    }

    public void runInGroup(Runnable ru, int times) {

        for (int i = 0; i < times; i++) {
            Thread thread = new Thread(ru);
            thread.start();
        }
    }


    public static void main(String[] args) throws InterruptedException, ClassNotFoundException, IllegalAccessException, InstantiationException {
//        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
//        Class testClass = classLoader.loadClass("concurrency.Test");
//        Test test =  (Test)testClass.newInstance();
//        test.main(new String[]{});
//        System.out.println(testClass.getSimpleName());


        Runnable a = new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(10000);
                    System.out.println("runnable完成计算");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        Thread b = new Thread(a);
        b.start();
        System.out.println("线程启动");

    }

}

class A {
    class VC {

    }

    protected class B {

    }

    class C {

    }

}

interface B {
    class D {
        D() {
            System.out.println("D");
        }
    }

}