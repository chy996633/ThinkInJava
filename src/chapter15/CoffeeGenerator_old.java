package chapter15;

import java.util.Iterator;
import java.util.Random;

/**
 * Created by Andrew on 2015/9/25.
 */
public class CoffeeGenerator_old implements Generator<Coffee>,Iterable<Coffee> {

    private Class[] types = {Kapuqinuo.class,Lanshan.class,Mocha.class};
    private static Random rand = new Random(47);
    private int size = 0;

    public CoffeeGenerator_old(int sz){
        size = sz;
    }

    public CoffeeGenerator_old(){ }

    @Override
    public Iterator<Coffee> iterator() {
        return new CoffeeIterator();
    }

    class CoffeeIterator implements Iterator<Coffee>{
        int count = size;

        @Override
        public boolean hasNext() {
            return count > 0;
        }

        @Override
        public Coffee next() {
            count--;
            return CoffeeGenerator_old.this.next();
        }

        @Override
        public void remove() {
            count--;
        }
    }


    public Coffee next() {
        try {
            return (Coffee)
                    types[rand.nextInt(types.length)].newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args){
        CoffeeGenerator_old cg = new CoffeeGenerator_old();
        for(int i=0;i<5;i++){
            System.out.println(cg.next());
        }
        for(Coffee coffee : new CoffeeGenerator_old(5)){
            System.out.println(coffee);
        }
    }


}