package com.code;

import java.time.LocalDateTime;

public class LocalDateTimeTest {

    public static void main(String[] args) {

        LocalDateTime localDateTime = LocalDateTime.of(2017, 8, 3, 16, 50 );
        System.out.println(localDateTime);

        System.out.println(
                "dayOfYear:" + localDateTime.getDayOfYear() + " dayOfMonth:" + localDateTime
                        .getDayOfMonth());

        System.out.println(" localDateTime.withDayOfMonth(10):" + localDateTime.withDayOfMonth(10));
        System.out.println(" localDateTime.withDayOfYear(243):" + localDateTime.withDayOfYear(243));

    }

}
