/**
 * Created by Andrew on 2015/10/21.
 */
public class Test {

    private Object o;

     Test(String investId){}



    /**
     * @paramargs add by zxx ,Dec 9, 2008
     */

    public static void main(String[] args) {


        System.out.println("1 >>> 8 = "+ (byte)(1 >>>8) );

        Test t = new Test("1");

//        b();
// TODO Auto-generated method stub

//        String a  = "ABC";
//        String b = a;
//        a = "DEF";
//        System.out.println(b);


//        float s1 = 72;
//        float s2 = 85;
//        float r = (s2-s1)/s1 ;
//        String str = String.format("score update %f %%",r );
//        System.out.println(str);

//        ArrayList<Coffee> list = new ArrayList<>();
//        list.add(new Object());

//        String s = "abc";
//        String b = s.replace("a", "A");
//        System.out.println(s);
//
//        HashMap<String,Integer> map = new HashMap<>();


//        try {
//            Class clazz = Class.forName("java.lang.String");
//            Constructor constructor =  clazz.getConstructor(String.class);
//            String str = (String)constructor.newInstance("test");
//            System.out.println(str);
//
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        } catch (InstantiationException e) {
//            e.printStackTrace();
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        } catch (NoSuchMethodException e) {
//            e.printStackTrace();
//        } catch (InvocationTargetException e) {
//            e.printStackTrace();
//        }

        for (String str : args) {
            System.out.println("args:" + str);
        }
        String test = "test";
        Object i;
//        System.out.println(i);
//        a();
//        t.b();

        System.out.println("main method");

        test.intern();

    }

    static {
        int i=0;
        System.out.println("i:"+i);
        System.out.println("static block");
    }

    public static void a(){
        a();
    }

    public void b(){
        System.out.println(o);
//        int a;
//        System.out.println(a);
    }

    private void c(){}


    static int test()

    {

        int x = 1;

        try

        {

            return x;

        } finally

        {
            ++x;

        }

    }


    class TestB extends Test{

        @Override
        public void  b(){
            System.out.println("override b");
        }


        TestB(String investId) {
            super(investId);
            int i=0;
        }
    }


}