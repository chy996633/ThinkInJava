package generics;

import java.math.BigInteger;
import net.mindview.util.Generator;

public class Fibonacci implements Generator<BigInteger> {

    private BigInteger[] count = new BigInteger[100000];
    private int index = 0;

    @Override
    public BigInteger next() {
        Calcfib();
        return count[index++];
    }

    private void Calcfib() {
        if (index == 0 || index == 1) {
            count[index] = new BigInteger("1");
        } else {
            count[index] = count[index - 1].add(count[index - 2]);
        }
    }

    private Integer fib(Integer count) {
        if (count == 0 || count == 1) {
            return 1;
        } else {
            return fib(count - 1) + fib(count - 2);
        }
    }

    public static void main(String[] args) {
        Fibonacci fibonacci = new Fibonacci();
        for (int i = 0; i < 100; i++) {
            BigInteger next = fibonacci.next();
            System.out.println(next);
        }
    }
}
