package com.shasha.s20220721;

/**
 * @author ShaLuwei
 * @create 2022-07-21 11:23
 */
public class Test_classloader {

    public static void main(String[] args) {

        ClassLoader classLoader = String.class.getClassLoader();
        System.out.println(classLoader); // 返回 null

    }

}
