package com.shasha.iflytek;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @author ShaLuwei
 * @create 2022-07-23 18:54
 */
public class ma3 {

    public static void main(String[] args) {


//        Scanner sc = new Scanner(System.in);
//
//        int judgeSum = sc.nextInt();
//
//        int[] score = new int[5];
//
//        for (int i = 0; i < 5; i++) {
//            score[i] = sc.nextInt();
//        }

        double num = -427;
        num *= 0.5;

        double tmp = Math.round(num);



        double   f   =   -1095.482;
        BigDecimal   b   =   new   BigDecimal(f);
        BigDecimal  b1   =   b.setScale(1,   RoundingMode.HALF_UP);
        double res = b1.setScale(0,   RoundingMode.HALF_UP).doubleValue();

        System.out.println((int)res);









    }





}
