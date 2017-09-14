package com.code.streamTest;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupByTest {


    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8);
        Map map = numbers.stream().collect(Collectors.groupingBy(e -> e / 2));
        System.out.println(map);

    }

}
