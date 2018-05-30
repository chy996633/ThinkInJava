package com.code.streamTest;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FunctionalUtil {

    public static <T,R> List<R> multiGetResult(List<Function<List<T>, R>> functions, List<T> list) {
        return functions.stream().map(f -> f.apply(list)).collect(Collectors.toList());
    }

    public static void main(String[] args) {
        System.out.println(multiGetResult(
                Arrays.asList(
                        list -> list.stream().collect(Collectors.summarizingInt(x -> x)),
                        list -> list.stream().filter(x -> x < 50).sorted().collect(Collectors.toList()),
                        list -> list.stream().sorted().collect(Collectors.toList()),
                        list -> list.stream().sorted().collect(Collectors.toMap(x -> x, y -> Math.pow(2,y)))),
//                        list -> list.stream().map(Math::sqrt).sorted().collect(Collectors.toList())),
                Arrays.asList(11,21,31,41,5,4,3,2,1)
                )
        );

    }

}
