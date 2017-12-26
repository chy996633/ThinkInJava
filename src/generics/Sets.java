package generics;

import java.util.HashSet;
import java.util.Set;

public class Sets {

    static <T> Set<T> union(Set<T> a, Set<T> b){
        Set<T> set = new HashSet<T>(a);
        set.addAll(b);
        return set;
    }

    static <T> Set<T> difference(Set<T> a, Set<T> b){
        Set<T> set = new HashSet<T>(a);
        set.removeAll(b);
        return set;
    }

    static <T> Set<T> intersection(Set<T> superSet, Set<T> subSet){
        Set<T> set = new HashSet<T>(superSet);
        set.retainAll(subSet);
        return set;
    }

    static <T> Set<T> complement(Set<T> superSet, Set<T> subSet){
        return difference(union(superSet, subSet), difference(superSet, subSet));
    }

}
