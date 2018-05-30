package com.code.streamTest;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import javax.persistence.criteria.CriteriaBuilder.In;

public class GroupByTest {


    public static void main(String[] args) {
        List<Integer> array = Arrays.asList(2,3,4,1,2,3,4,5,1,1,3,4);
        Map<Integer, List<Integer>> map = array.stream().collect(Collectors.groupingBy(Function.identity()));
        System.out.println(map);


    }

}
