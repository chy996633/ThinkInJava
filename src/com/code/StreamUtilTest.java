package com.code;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.*;

/**
 * Created by backstop-samuel on 2/28/17.
 */
public class StreamUtilTest {

    @Test
    public void gtThreeFilter() throws Exception {
        Stream<String> 热啊 = Stream.of("aaa","aaaa","bbb","bbbb");
        List strList = StreamUtil.gtThreeFilter(热啊).collect(Collectors.toList());
        Assert.assertTrue(strList.containsAll(Arrays.asList("aaaa","bbbb")) && strList.size() == 2);
    }


    @org.junit.Test
    public void flatMap() throws Exception {
        Stream<List<String>> listStream = Stream.of(Arrays.asList("1"),Arrays.asList("2","3"),Arrays.asList("4","5","6"));
        List list = Arrays.asList("1","2","3","4","5","6");
        List collectList = StreamUtil.flatMap(listStream).collect(Collectors.toList());
//        Stream collectList = listStream.flatMap(a -> a.stream()).;
        Assert.assertTrue((collectList).containsAll(list));
    }




}