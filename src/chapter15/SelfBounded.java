package chapter15;

/**
 * Created by Andrew on 2015/10/8.
 */
public class SelfBounded<T extends SelfBounded> {
    T element;
    T get(){return element;}
    void set(T arg){this.element = arg;}
}
