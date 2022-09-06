package com.shasha.s20220717;

import java.util.Date;

/**
 * @author ShaLuwei
 * @create 2022-07-17 22:18
 */
public class Test_time {

    public static void main(String[] args) {

        long l = System.currentTimeMillis();
        System.out.println(l);

        Date d1 = new Date();
        System.out.println(d1.toString());
        System.out.println(d1.getTime());

        Date d2 = new Date(132213131L);
        System.out.println(d1.toString());

        java.sql.Date d3 = new java.sql.Date(d1.getTime());
        System.out.println(d3.toString());

    }

}
