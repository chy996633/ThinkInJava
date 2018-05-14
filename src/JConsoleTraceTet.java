import java.util.ArrayList;
import java.util.List;

public class JConsoleTraceTet {

    static class OOMObject {

        public byte[] placeholder = new byte[1024 * 64];
    }

    public static void fillHeap() throws InterruptedException {
        List<OOMObject> list = new ArrayList<>();
        while (true) {
            for (int i = 0; i < 1000; i++) {
                list.add(new OOMObject());
                Thread.sleep(50);
            }
            System.gc();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        fillHeap();
    }

}
