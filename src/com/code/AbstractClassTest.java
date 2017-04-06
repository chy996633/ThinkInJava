package com.code;

import com.sun.deploy.association.Action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

/**
 * Created by backstop-samuel on 3/28/17.
 */
public class AbstractClassTest {


    public static void main(String[] args) throws FileNotFoundException {

        AbsClass absClass = new AbsClass() {
            @Override
            void vd() {

            }
        };

        AbsClass absClassB = new ConcreteClass();

        ActionListener actionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        };

        Closeable closeable = new InputStreamReader(new BufferedInputStream(new FileInputStream("asdasd")));

        Closeable closeable1 = new Closeable() {
            @Override
            public void close() throws IOException {

            }
        };


        System.out.println(absClass.add(1,2));
        System.out.println(absClassB.add(1,2));





    }







}
