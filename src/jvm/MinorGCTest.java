package jvm;

/**
 * VM options: -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8
 */
public class MinorGCTest {

    private static final int _1MB = 1024 * 1024;

    public static void testMinorGC() {
        byte[] allocate1, allocate2, allocate3, allocate4;
        allocate1 = new byte[_1MB * 2];
        allocate2 = new byte[_1MB * 2];
        allocate3 = new byte[_1MB * 2];
        allocate4 = new byte[_1MB * 4];
    }

    /**
     * -XX:+PrintTenuringDistribution -XX:MaxTenuringThreshold=1
     */
    public static void testTenuringThreshold() {
        byte[] allocate1, allocate2, allocate3;
        allocate1 = new byte[_1MB / 4];
        allocate2 = new byte[_1MB * 4];
        allocate3 = new byte[_1MB * 4];
        allocate3 = null;
        allocate3 = new byte[_1MB * 4];
    }

    public static void testTenuringThreshold2() {
        byte[] allocate1, allocate2, allocate3, allocate4;
        allocate1 = new byte[_1MB / 4];
        allocate2 = new byte[_1MB / 3];
        allocate3 = new byte[_1MB * 4];
        allocate4 = new byte[_1MB * 4];
        allocate4 = null;
        allocate4 = new byte[_1MB * 4];
    }

    public static void main(String[] args) {
        MinorGCTest.testMinorGC();


    }

}
