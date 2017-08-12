package com.code.algorithm;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by backstop-samuel on 6/13/17.
 * Question asked on https://stackoverflow.com/questions/29383296/split-string-based-on-alternating-character-in-r/29383355#29383355
 * I wonder how much code in Java
 */
public class SplitTestOne {


    public static String[] split(String str){
        ArrayList<String> stringArrayList = new ArrayList<>();

        String regex = "(0+|1+)";
        Pattern pattern = Pattern.compile(regex);
        Matcher m = pattern.matcher(str);
        while (m.find()){
            System.out.println(m.group());
            stringArrayList.add(m.group());
        }
        return stringArrayList.toArray(new String[stringArrayList.size()]);
    }

    public static void main(String[] args) {
        String str = "111110000011110000111000";
        SplitTestOne.split(str);
    }

}
