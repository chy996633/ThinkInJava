package com.code;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * Created by backstop-samuel on 5/2/17.
 */
public class LinkedListTest {

    public static void main(String[] args) {
        LinkedList<String> linkedList = new LinkedList<String>();
        linkedList.addAll(Arrays.asList("this is a new day".split(" ")));
        String s;
        while ((s = linkedList. poll()) != null){
            System.out.println(s);
        }

    }



}
