package com.shasha.lenovo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.util.Date;

/**
 * @author ShaLuwei
 * @create 2022-07-29 21:20
 */
public class ma2 {

    public static void main(String[] args) throws ParseException {

//        Scanner sc = new Scanner(System.in);
//
//        int n = sc.nextInt();

        String myDateString = "13:24:40";
        LocalTime localTime = LocalTime.parse(myDateString, DateTimeFormatter.ofPattern("HH:mm:ss"));
        int hour = localTime.get(ChronoField.CLOCK_HOUR_OF_DAY);
        int minute = localTime.get(ChronoField.MINUTE_OF_HOUR);
        int second = localTime.get(ChronoField.SECOND_OF_MINUTE);

        //prints "hour: 13, minute: 24, second: 40":
        System.out.println(String.format("hour: %d, minute: %d, second: %d", hour, minute, second));

        String myDateString1 = "13:24:40";
        LocalTime localTime1 = LocalTime.parse(myDateString, DateTimeFormatter.ofPattern("HH:mm:ss"));
        String myDateString2 = "13:25:45";
        LocalTime localTime2 = LocalTime.parse(myDateString, DateTimeFormatter.ofPattern("HH:mm:ss"));

        SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
        Date d1 = new SimpleDateFormat("HH:mm:ss").parse(myDateString1);
        long time = d1.getTime();

        Date d2 = new Date(time);

        System.out.println(d2);


    }

}
