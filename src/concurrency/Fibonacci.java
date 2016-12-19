package concurrency;

import chapter15.Generator;

import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Andrew on 2015/11/20.
 */
public class Fibonacci implements Generator<Integer>,Runnable {

    private int count=0;
    private final int n;

    private int[] array = new int[100];
    public Fibonacci(int n){this.n = n;}

    private Integer fib(int n){
        //use recursion
        if(n < 2) return 1;
        return fib(n-2)+fib(n-1);

        //use iteration
//        array[0] = 1;
//        array[1] = 1;
//        int i;
//        for(i=2;i<n;i++){
//            array[i] = array[i-1]+array[i-2];
//        }
//        return array[i-1];
    }

    @Override
    public Integer next() {
        return fib(count++);
    }

    @Override
    public void run() {
        Integer[] array = new Integer[n];
        for(int i=0;i<n;i++){
            array[i] = next();
        }
        System.out.println("Seq of "+n+": "+Arrays.toString(array));
    }

    public static void main(String[] args) {
        ExecutorService service =  Executors.newCachedThreadPool();
        for(int i=1;i<=80;i++){
            service.execute(new Fibonacci(i));
        }
        service.shutdown();
    }

}
