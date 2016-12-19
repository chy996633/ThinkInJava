package holding;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by Andrew on 2016/2/19.
 */
public class GerbilMap {


    public static void main(String[] args) {
        Map<String,Gerbil> m = new HashMap<>();
        m.put("Fuzzy",new Gerbil(1));
        m.put("Andrew",new Gerbil(2));
        m.put("Frank",new Gerbil(3));
        m.put("Iris",new Gerbil(4));
        m.put("Simon",new Gerbil(5));
        Iterator<String> iterator = m.keySet().iterator();
        while(iterator.hasNext()){
            Gerbil g = m.get(iterator.next());
            g.hop();
        }

    }
}
