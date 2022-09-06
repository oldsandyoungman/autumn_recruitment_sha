package com.shasha.JD;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ShaLuwei
 * @create 2022-09-03 19:02
 */
public class ma0 {

    public static void main(String[] args) {

        String str = "A.B.C";
//        String[] re = str.split("\\.\s*");
//        String[] re = str.split("\.\s*");
        String[] re = str.split("\\.\\s*");
//        String[] re = str.split(".\s*");

        List<String> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        System.out.println(list1.getClass().equals(list2.getClass()));
    }

}
