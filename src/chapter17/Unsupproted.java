package chapter17;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by Andrew on 2015/10/15.
 */
public class Unsupproted {

    static void test(String msg , List<String> list){
        System.out.println("---"+msg +"---");
        Collection<String> c = list;
        Collection<String> sublist = list.subList(1,8);
        Collection<String> c2 = new ArrayList<>(sublist);


    }
}
