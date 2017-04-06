package com.code;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

/**
 * Created by backstop-samuel on 2/28/17.
 */
public class StreamUtil {


    public static Stream getStream(Collection collection){
        return collection.stream();
    }

    public static  <T> Stream getStream(T[] arrays){
        return Arrays.stream(arrays);
    }

    public static Stream getStream(BufferedReader bufferedReader){
        return bufferedReader.lines();
    }

    public static  IntStream getIntStream(){
        return IntStream.range(2,5);
    }

    public static Stream getFileStream(String path, String fileName) throws IOException {
        return Files.walk(FileSystems.getDefault().getPath(path, fileName));
    }

    public static Stream getFileStream() throws IOException {
        return getFileStream("/home/backstop-samuel/Documents", "BackstopBasics_1606.pdf");
    }

    public static LongStream getRandomLongStream(){
        return new Random().longs();
    }

    public static Stream<String> map(Stream<String> stream){
        return stream.map(String::toUpperCase);
    }

    public static IntStream mapToInt(Stream<String> stream){
        return stream.mapToInt(String::length);
    }

    public static Stream<String> flatMap(Stream<List<String>> listStream){
        return listStream.flatMap(List::stream);
    }

    public static Stream<String> gtThreeFilter(Stream<String> stream){
        return stream.filter(s -> s.length() > 3);
    }










}
