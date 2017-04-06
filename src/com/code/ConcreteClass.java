package com.code;

/**
 * Created by backstop-samuel on 3/28/17.
 */
public  class ConcreteClass extends AbsClass{

    @Override
    void vd() {

    }

    public static void main(String[] args) {
        ConcreteClass concreteClass = new ConcreteClass(){
            @Override
            void vd() {
                super.vd();
            }
        };

    }

}