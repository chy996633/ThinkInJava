package com.code;

/**
 * Created by Andrew on 2016/1/24.
 */
public class PassParameterByValueInJavaTest {

    public void passParameter(A str){
        str.name = "A";
        str = new A();
        str.name = "new A";

    }

    public static void main(String[] args) {
        PassParameterByValueInJavaTest p = new PassParameterByValueInJavaTest();
        A a = new A();
        p.passParameter(a);
        System.out.println(a.name);
    }

}

class A{

    String name;
}
