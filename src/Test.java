/**
 * Created by Andrew on 2015/10/21.
 */
public class Test {

    private Object o;

    public void myMethod(String str) {
        System.err.println("string");
    }


    public void myMethod(Object obj) {
        System.err.println("object");
    }


    public static void main(String[] args) {
        // 静态方法调用与对象实例无关
        ((Test) null).haha();

        // NPE
//        ((Test) null).test();

        Test t = new TestExt();
        TestExt tExt = new TestExt();
        t.myMethod(null);
        tExt.myMethod(null);

    }

    public static void haha() {

//        System.out.println("haha");
    }

    void test() {
        System.out.println("test");
    }


}

class TestExt extends Test {

    @Override
    public void myMethod(Object obj) {
        System.err.println("ext object");
    }

    @Override
    public void myMethod(String str) {
        System.err.println("ext string");
    }
}