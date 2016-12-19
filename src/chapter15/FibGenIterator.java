package chapter15;

import java.lang.Integer;
import java.util.Iterator;

/**
 * Created by Andrew on 2015/12/12.
 */
public class FibGenIterator extends FibGenerator implements Iterable<java.lang.Integer> {

    private int count;
    public FibGenIterator(int count){
        this.count = count;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new FibGenIteratorIner();
    }


    private class FibGenIteratorIner implements Iterator<Integer> {
        @Override
        public boolean hasNext() {
            return count > 0;
        }

        @Override
        public Integer next() {
            count--;
            return FibGenIterator.this.next();
        }
    }
}
