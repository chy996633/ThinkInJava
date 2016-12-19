package com.code;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Andrew on 2016/1/20.
 */
public class RegTest {

    public void testStrArray(String[] arr){
        String pattern = "^\\d*\\d*\\d*$";
        String numPattern = "[1-35]";
        String blankPattern = "er\\b";
        String emailPat = "[\\w\\.\\-]+@([\\w\\-]+\\.)+[\\w\\-]+";
        String abPat = "[ab]*";
        String similarWordPat = "worl?d";



        for(String str :arr){
            if(! str.matches(similarWordPat)){
                System.out.println(str+" not match");
            }else{
                System.out.println(str+" matches");
            }
        }

    }

    public boolean test(){
        String catPat = "cat";
        Pattern pattern = Pattern.compile(catPat);
        Matcher matcher = pattern.matcher("catsdsd");
        return matcher.lookingAt();
    }

    public static void main(String[] args) {
        RegTest test = new RegTest();
        String[] arr = {"word","ssds@sina.com","13477754148","137-8885-8854"};
//        test.testStrArray(arr);
        System.out.println(test.test());


    }
}
