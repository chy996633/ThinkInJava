package com.code.streamTest;

import java.util.Arrays;
import java.util.List;

public class ReduceTest {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8);
        System.out.println(list.stream().reduce((a,b) -> a+b).get());
        System.out.println(list.stream().reduce((a,b) -> a).isPresent());
    }

}
