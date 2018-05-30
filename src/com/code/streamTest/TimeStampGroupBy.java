package com.code.streamTest;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TimeStampGroupBy {


    public static void main(String[] args) {

        List<Demo> list = new ArrayList<>();
        LocalDateTime now = LocalDateTime.now().truncatedTo(ChronoUnit.MINUTES);
        Demo demo = new Demo(Timestamp.valueOf(now), "Beijing", 66.40);
        list.add(demo);

        demo = new Demo(Timestamp.valueOf(now.plusMinutes(10)), "Beijing", 60.40);
        list.add(demo);

        demo = new Demo(Timestamp.valueOf(now.plusMinutes(16)), "Beijing", 80.40);
        list.add(demo);

        Map map = list.stream()
                .collect(Collectors.groupingBy(e -> roundUp(e.timestamp.toLocalDateTime())));

        System.out.println(map);
    }


    public static String roundUp(LocalDateTime time) {
        LocalDateTime temp;
        int minutesSinceLastWhole15 = time.getMinute() % 15;
        if (minutesSinceLastWhole15 >= 8) { // round up
            temp = time.plusMinutes(15 - minutesSinceLastWhole15);
        } else { // round down
            temp = time.minusMinutes(minutesSinceLastWhole15);
        }
        return temp.toString();
    }

    static class Demo {

        Timestamp timestamp;
        String city;
        Double price;

        public Demo(Timestamp timestamp, String city, Double price) {
            this.timestamp = timestamp;
            this.city = city;
            this.price = price;
        }

        @Override
        public String toString() {
            return "{ timestamp:" + timestamp + " city:" + city + " price:" + price + " }";
        }
    }

}
