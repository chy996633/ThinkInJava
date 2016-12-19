package holding;

import chapter17.Countries;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by Andrew on 2016/2/20.
 */
public class P24 {

    public static void main(String[] args) {
        Map<String,String> map = new LinkedHashMap<>(Countries.capitals(10));
        Set<Map.Entry<String,String>> set =  map.entrySet();


    }
}
