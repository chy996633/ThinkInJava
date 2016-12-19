package holding;

import chapter17.Countries;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by Andrew on 2016/2/19.
 */
public class MapOrder {
    public static void main(String[] args) {
        Map<String,String> m = new HashMap<String,String>();
        m.putAll(Countries.capitals(5));
//        m.putAll(Countries.capitals(5));
        System.out.println(m);
        Map<String,String> m2 = new LinkedHashMap<>();
        String[] keys = m.keySet().toArray(new String[0]);
        Arrays.sort(keys);
        for(String s : keys){
            m2.put(s,m.get(s));
        }
        System.out.println(m2);

//        Iterator<String> itr = m.keySet().iterator();
//        while (itr.hasNext()){
//            String s = itr.next();
//            m2.put(s,m.get(s));
//        }
//        System.out.println(m2);




    }

}
