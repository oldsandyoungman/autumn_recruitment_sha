package com.shasha.iflytek;


import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @author ShaLuwei
 * @create 2022-07-23 18:53
 */
public class ma1 {

    public static void main(String[] args) {


        double   f   =   -213.4999;
        BigDecimal b   =   new   BigDecimal(f);
        BigDecimal  b1   =   b.setScale(3,   RoundingMode.HALF_UP);
        double res = b1.setScale(0,   RoundingMode.HALF_UP).doubleValue();

        System.out.println((int)res);


    }

}


