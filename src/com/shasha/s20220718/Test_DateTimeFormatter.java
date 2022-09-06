package com.shasha.s20220718;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;

/**
 * @author ShaLuwei
 * @create 2022-07-18 10:13
 */
public class Test_DateTimeFormatter {

    public static void main(String[] args) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
        String format1 = dateTimeFormatter.format(LocalDateTime.now());
        System.out.println(format1);
        TemporalAccessor parse1 = dateTimeFormatter.parse(format1);
        System.out.println(parse1);

    }

}
