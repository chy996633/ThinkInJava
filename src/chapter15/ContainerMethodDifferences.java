package chapter15;

import java.lang.reflect.Method;
import java.util.*;

/**
 * Created by Andrew on 2015/9/28.
 */
public class ContainerMethodDifferences {

    //找出一个类的所有方法
    static Set<String> methodSet(Class<?> type){
        Set<String> result = new TreeSet<String>();
        for(Method e: type.getMethods()){
            result.add(e.getName());
        }
        return result;
    }

    //找出一个类的所有接口
    static void interfaces(Class<?> type){
        System.out.println("Interfaces in "+type.getSimpleName()+" :");
        List<String> list = new ArrayList<String>();
        for(Class<?> c:type.getInterfaces()){
            list.add(c.getSimpleName());
        }
        System.out.println(list);
        System.out.println();
    }

    static Set<String> object = methodSet(Object.class);
    static{
        object.add("clone");
    }

    static void differences(Class<?> superclass,Class<?> subclass){
        System.out.println(superclass.getSimpleName() + " extends " + subclass.getSimpleName() + " ,adds: ");
        Set<String> comp = Sets.difference(methodSet(superclass),methodSet(subclass));
        comp.removeAll(object);
        System.out.println(comp);
        interfaces(superclass);
    }

    public static void main(String[] args) {
        differences(HashSet.class,Set.class);
        differences(ArrayList.class,List.class);
    }
}
