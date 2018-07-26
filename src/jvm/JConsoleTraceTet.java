package jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * add VM options: -Dcom.sun.management.jmxremote
 */
public class JConsoleTraceTet {

    static class OOMObject {

        public byte[] placeholder = new byte[1024 * 64];
    }

    public static void fillHeap() throws InterruptedException {
        List<OOMObject> list = new ArrayList<>();
        while (true) {
            for (int i = 0; i < 1000; i++) {
                list.add(new OOMObject());
                System.out.println("add OOMObject "+ i );
                Thread.sleep(1000);
            }
            System.gc();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        fillHeap();
    }

}
