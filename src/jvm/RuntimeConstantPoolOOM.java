package jvm;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * VM args: -XX:PermSize=10M -XX:MaxPermSize=10M
 * use JDK 1.6 below
 * Samuel Chen
 */
public class RuntimeConstantPoolOOM {

    public static void main(String[] args) {
        //use List to hold strings to avoid GC
        List<String> list = new ArrayList<>();
        int i = 0;
        while (true) {
            list.add(String.valueOf(i++));
        }
    }

}
