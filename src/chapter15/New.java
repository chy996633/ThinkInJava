package chapter15;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Andrew on 2015/9/28.
 */
public class New {

    public static <K,V> Map<K,V> map(){
        return new HashMap<>();
    }

    public static void main(String[] args) {
        Map<String,List<String>> sls =  New.map();


    }
}
