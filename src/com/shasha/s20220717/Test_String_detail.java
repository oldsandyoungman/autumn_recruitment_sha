package com.shasha.s20220717;

/**
 * @author ShaLuwei
 * @create 2022-07-17 23:59
 */
public class Test_String_detail {

    public static void main(String[] args) {
        String str = null;
        StringBuffer sb = new StringBuffer();
        sb.append(str);

        System.out.println(sb.length()); // 4

        System.out.println(sb); // "null"

        StringBuffer sb1 = new StringBuffer(str); // NullPointerException

        System.out.println(sb1);

    }

}
