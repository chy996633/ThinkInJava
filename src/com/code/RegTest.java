package com.code;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Andrew on 2016/1/20.
 */
public class RegTest {

    String pattern = "^\\d*\\d*\\d*$";
    String numPattern = "[1-35]";
    String blankPattern = "er\\b";
    String emailPat = "[\\w\\.\\-]+@([\\w\\-]+\\.)+[\\w\\-]+";
    String abPat = "[ab]*";
    String similarWordPat = "worl?d";
    static String valueRegex = "(\\d{4}-\\d{2}-\\d{2}T\\d{2}:\\d{2}:\\d{2}\\.\\d{3}\\+\\d{2}:\\d{2})";


    public void testStrArray(String[] arr){
        for(String str :arr){
            if(! str.matches(similarWordPat)){
                System.out.println(str+" not match");
            }else{
                System.out.println(str+" matches");
            }
        }

    }

    public static void replaceValueRegex(String message){
        String result = message.replaceAll(valueRegex,"null");
        System.out.println(result);
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

        String message = "{\n"
                + "        \"mCheckInTime\": null,\n"
                + "        \"mCheckOutTime\": null,\n"
                + "        \"mLateArrivalTime\": \"2017-09-14T18:00:00.000+05:00\",\n"
                + "        \"mNumberOfBeds\": 0\n"
                + "      }";

        replaceValueRegex(message);



    }
}
