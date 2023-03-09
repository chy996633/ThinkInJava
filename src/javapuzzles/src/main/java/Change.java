package javapuzzles.src.main.java;

import java.math.BigDecimal;

/**
 * Created by Andrew on 2015/9/22.
 */
public class Change {

    public static void printBinary(){
        int i=-1;
        System.out.println(Integer.toBinaryString(i));
        i>>>=10;
        System.out.println(Integer.toBinaryString(i));
        int j = -1 >> 10;
        System.out.println(Integer.toBinaryString(j));
        int m = 1;
        System.out.println(Integer.toBinaryString(m<<10));
    }



    public static void main(String[] args) {
        Change.change();
    }

    private static void change() {
        System.out.println(new BigDecimal("2.0").subtract(new BigDecimal("1.1")));
        double f = 2e307-1;
        System.out.println(f);
    }

}
