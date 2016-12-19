package holding;

import java.util.*;

/**
 * Created by Andrew on 2016/2/20.
 */
public class P25 {

    public static void main(String[] args) {
        List<String> list = new TextFile("E:\\My_code\\Java\\ThinkInJava\\src\\holding\\P25.java","\\W+");
        Map<String,ArrayList<Integer>> map = new LinkedHashMap<>();
        for (int i = 0; i < list.size(); i++) {
            String s = list.get(i);
            if (map.containsKey(s)){
                map.get(s).add(i);
            }else {
                map.put(s,new ArrayList<>(Arrays.asList(i)));
            }
        }

        Set<Map.Entry<String,ArrayList<Integer>>> set = map.entrySet();
        Map<String,ArrayList<Integer>> m2 = new LinkedHashMap<>();
        for (int i = 0; i < list.size(); i++) {
            for(Map.Entry<String,ArrayList<Integer>> entry : set){
                if (entry.getValue().contains(i)){
                    m2.put(entry.getKey(),entry.getValue());
                    break;
                }
            }
        }
        System.out.println("map:"+map);
        System.out.println("m2:"+m2);
    }

}
