package chapter15;

import java.util.Iterator;

/**
 * Created by Andrew on 2015/12/12.
 */
public class FibGenCombine implements Iterable<Integer> {
    private FibGenerator fibGenerator = new FibGenerator();

    private int count ;
    public FibGenCombine(int count){
        this.count = count;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new FibGenCombineIter();
    }


    private class FibGenCombineIter implements Iterator<Integer> {
        @Override
        public boolean hasNext() {
            return count>0;
        }

        @Override
        public Integer next() {
            count--;
            return fibGenerator.next();
        }
    }

    public static void main(String[] args) {
        for(int i:new FibGenCombine(10)){
            System.out.println(i);
        }

    }
}
