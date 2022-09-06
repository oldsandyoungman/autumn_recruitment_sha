package com.shasha.NIO;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @author ShaLuwei
 * @create 2022-08-06 16:03
 */
public class fan2 {

    /*
    aabcc
    ccdee

    leetcode
    codeleet

     */

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String s1 = in.nextLine();
        String s2 = in.nextLine();

        char[] ss1 = s1.toCharArray();
        char[] ss2 = s2.toCharArray();

        int n = ss1.length;

        HashMap<Character, Character> memo = new HashMap<>();

        for (int i = 0; i < n; i++) {
            char c1 = ss1[i];
            char c2 = ss2[i];
            if(memo.containsKey(c1)){
                if(memo.get(c1)!=c2){
                    System.out.println(-1);
                    return;
                }
            }else{
                memo.put(c1, c2);
            }
        }

        System.out.println(memo.size());

    }

}



//import java.util.*;
//
//public class Main {
//
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//
//        String s1 = in.nextLine();
//        String s2 = in.nextLine();
//
//        char[] ss1 = s1.toCharArray();
//        char[] ss2 = s2.toCharArray();
//
//        int n = ss1.length;
//
//        HashMap<Character, Character> memo = new HashMap<>();
//
//        for (int i = 0; i < n; i++) {
//            char c1 = ss1[i];
//            char c2 = ss2[i];
//            if(memo.containsKey(c1)){
//                if(memo.get(c1)!=c2){
//                    System.out.println(-1);
//                    return;
//                }
//            }else{
//                memo.put(c1, c2);
//            }
//        }
//
//        System.out.println(memo.size());
//
//    }
//
//}
