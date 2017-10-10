package com.code;

public class SuperTest {

    String name;

    public SuperTest(){
        test();
        System.out.println(1);
    }

    public SuperTest(String name){
        System.out.println(2);
        this.name = name;
    }

    public void test(){
        System.out.println("father");
    }

    public static void main(String[] args) {
        new Child("milk");
    }

}


class Child extends SuperTest{

    SuperTest superTest;

    public Child(){
        System.out.println(4);
    }

    public Child(String name){
//        super(name);
        System.out.println(3);
        this.name = name;
        superTest = new SuperTest(name + ":F");
    }

    public void test(){
        System.out.println("child");
    }

}