package chapter16;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Andrew on 2015/10/10.
 */
public class SystemCopyIsShadowCopy {
    public void test(){
        Object[] a1 = new Object[10];
        Object[] a2 = new Object[10];
        Arrays.fill(a1, new Integer("3"));
        System.arraycopy(a1, 0, a2, 0, 10);
        System.out.println(Arrays.toString(a1));
        System.out.println(Arrays.toString(a2));
        a1[0] = new ArrayList<>();
        System.out.println(Arrays.toString(a1));
        System.out.println(Arrays.toString(a2));

    }

    public static void main(String[] args) {
        new SystemCopyIsShadowCopy().test();
    }

}

