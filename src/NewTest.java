import chapter15.New;


/**
 * 第一种情况是在栈中声明了net引用，这个引用指向堆中的net Test()对象，然后调用方法后，栈中产生另一个nt引用，指向堆中同一个对象，因此直接
 * 修改nt.a，就相当于修改net引用指向的对象。
 * 第二种情况是在栈中声明了net引用，这个引用指向堆中的net Test()对象，然后调用方法后，栈中产生另一个nt引用，指向堆中同一个对象。nt重新
 * 指向一个new NewTest()对象，此时修改的不是net引用指向的对象
 * Java中对象都是按引用传递的，只有基本类型是传值。
 */

public class NewTest {

    public String a;

    public static void main(String[] args) {
        NewTest net = new NewTest();
        net.a = "abc";
        net.change(net);
        System.out.println(net.a);
    }

    void change(NewTest nt){
        // change the property a
//        nt.a = "c";
        //not change
        nt = new NewTest();
        nt.a = "c";

    }



}
