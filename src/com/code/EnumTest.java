package com.code;

/**
 * Created by backstop-samuel on 2/23/17.
 * 枚举似乎可以理解为抽象类
 */
public enum EnumTest {


    ENUM_TEST("1"){
        @Override
        void abs() {

        }

        public void echo(){
            System.out.println("I'm ENUM_TEST");
        }
    },ENUM_TEST_2("2") {
        @Override
        void abs() {

        }
    },ENUM_TEST_3(String.class) {
        @Override
        void abs() {

        }
    };

    private String name;


    EnumTest(String string){
        this.name = string;
    }


    EnumTest(Class<String> clazz) {

    }

    abstract void abs();

//    private abstract priAbs();

    public static void main(String[] args) {
        EnumTest test = EnumTest.ENUM_TEST;


    }

}
