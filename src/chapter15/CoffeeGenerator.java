package chapter15;

import java.util.Iterator;
import java.util.Random;

/**
 * Created by Andrew on 2015/12/12.
 */
public class CoffeeGenerator implements Generator<Coffee>,Iterable<Coffee> {

    private int n;
    private Random random = new Random(47);
    private Class[] types = new Class[]{Lanshan.class,Kapuqinuo.class,Mocha.class};
    public CoffeeGenerator(){}

    public CoffeeGenerator(int size) {
        n = size;
    }

    @Override
    public Coffee next() {
        try {
            return (Coffee)types[random.nextInt(types.length)].newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        CoffeeGenerator generator = new CoffeeGenerator();
        for(int i=0;i<5;i++){
            System.out.println(generator.next());
        }
        for(Coffee e: new CoffeeGenerator(5)){
            System.out.println(e);
        }
    }

    @Override
    public Iterator<Coffee> iterator() {
        return new CoffeeIterator();
    }

    private class CoffeeIterator implements Iterator<Coffee> {
        int count = n;
        @Override
        public boolean hasNext() {
            return count>0;
        }

        @Override
        public Coffee next() {
            count--;
            return CoffeeGenerator.this.next();
        }
    }
}
