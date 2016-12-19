package chapter15;

/**
 * Created by Andrew on 2015/9/25.
 */
public class Coffee {
    private static long count;
    private final long id = count++;

    public String toString() {
        return getClass().getSimpleName() + " " + id;
    }
}

class Mocha extends Coffee {

}

class Kapuqinuo extends Coffee {

}

class Lanshan extends Coffee {

}


