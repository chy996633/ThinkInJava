package com.code;

public class StaticTest {

    static {
        System.out.println("static staticTest");
    }

    {
        System.out.println("I'm staticTest");
    }

    public StaticTest(){
        System.out.println("StaticTest");
    }

}

class HelloB extends StaticTest {

    static {
        System.out.println("static helloB");
    }

    {
        System.out.println("I'm HelloB");
    }

    public HelloB(){
        System.out.println("HelloB");
    }

    public static void main(String[] args) {

        System.out.println("-------------------main start---------------");
        new HelloB();
        System.out.println("-------------------main ends---------------");
    }


}