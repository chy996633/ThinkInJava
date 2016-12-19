package chapter15;

import java.lang.Integer;
/**
 * Created by Andrew on 2015/12/12.
 */
public class FibGenerator implements Generator<Integer> {

    private int count = 0;

    @Override
    public Integer next() {
        return fib(count++);
    }

    private Integer fib(int count) {
        if(count == 1 || count == 0) return 1;
        return fib(count-1)+fib(count-2);
    }

    public static void main(String[] args) {
        FibGenerator fibGenerator = new FibGenerator();
//        for(int i=0;i<10;i++){
//            System.out.println(fibGenerator.next());
//        }
        for(Integer i : new FibGenIterator(10)){
            System.out.println(i);
        }
    }
}
