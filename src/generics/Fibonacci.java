package generics;

import java.util.regex.Pattern;
import net.mindview.util.Generator;

public class Fibonacci implements Generator<Integer> {

    private int count = 0;

    @Override
    public Integer next() {
        return fib(count++);
    }

    private Integer fib(Integer count){
        if (count == 0 || count == 1) {
            return 1;
        } else {
            return fib(count-1) + fib(count -2);
        }
    }

    public static void main(String[] args) {
        Fibonacci fibonacci = new Fibonacci();
        for ( int i=0;i< 1900;i++){
            System.out.println(fibonacci.next());
        }
    }
}
