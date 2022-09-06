package com.shasha.s20220718;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.Date;

/**
 * @author ShaLuwei
 * @create 2022-07-18 09:12
 */
public class Test_SimpleDateFormat {

    public static void main(String[] args) throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat();
        Date d = new Date();
        String format = sdf.format(d);
        System.out.println(format);
        Date parse_d = sdf.parse(format);
        System.out.println(parse_d);

        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date d2 = new Date();
        String format2 = sdf2.format(d);
        System.out.println(format2);
        Date parse_d2 = sdf2.parse(format2);
        System.out.println(parse_d2);

        String s = "1998-02-17";
        SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date parse = sdf3.parse(s);
        java.sql.Date target = new java.sql.Date(parse.getTime());


    }

}
