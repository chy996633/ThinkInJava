package chapter15;

/**
 * Created by Andrew on 2015/9/29.
 */
interface Bounds {
    void a();
    void b();
}

class Impl implements Bounds {

    @Override
    public void a() {

    }

    @Override
    public void b() {

    }

    public void c(){}

}

public class Test {
    static <T extends Bounds> void f(T t){t.a();t.b();}

    public static void main(String[] args) {
        Test.f(new Impl());
    }
}


