package holding;

import java.util.*;

/**
 * Created by Andrew on 2016/2/19.
 */
public class P21 {

    public static void main(String[] args) {
        //先对List排序，后插入Map
        ArrayList<String> list = new TextFile("E:\\My_code\\Java\\ThinkInJava\\src\\holding\\P21.java", "\\W+");
        Collections.sort(list, String.CASE_INSENSITIVE_ORDER);
        Map<String, Integer> m = new LinkedHashMap<>();
        for (String s : list) {
            Integer times = m.get(s);
            m.put(s, times == null ? 1 : times + 1);
        }
        System.out.println("word count:"+m);


    }

}
