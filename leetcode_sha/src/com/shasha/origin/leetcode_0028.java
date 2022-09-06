package com.shasha.origin;

import org.junit.Test;

/**
 * @author ShaLuwei
 * @create 2022-07-28 11:57
 */




public class leetcode_0028 {

    @Test
    public void test(){

        String a = "hello";
        String b = "ll";
        System.out.println(strStr(a, b));

    }

    public int strStr(String haystack, String needle) {
        char[] hh = haystack.toCharArray();
        char[] nn = needle.toCharArray();
        int n = hh.length;

        long Q = 1658598167;

        int R = 256;
        int L = nn.length;
        long RL = 1;
        for(int i=0; i<L-1; i++){
            RL = (RL*R)%Q;
        }

        long target = 0;
        for(int i=0; i<nn.length; i++){
            target = ((target*R)%Q + nn[i])%Q;
        }

        int left = 0;
        int right = 0;
        long cur = 0;

        while(right<n){
            cur = ((R*cur)%Q + hh[right])%Q;
            right++;

            if(cur==target){
                if(needle.equals(haystack.substring(left, right))){
                    return left;
                }

                cur = (cur - (RL*hh[left])%Q + Q)%Q;
                left++;

            }

        }

        return -1;

    }
}

//public class leetcode_0028 {
//
//    @Test
//    public void test(){
//
//        String a = "hello";
//        String b = "ll";
//        System.out.println(strStr(a, b));
//
//    }
//
//    public int strStr(String haystack, String needle) {
//        char[] ss = haystack.toCharArray();
//        int n = ss.length;
//
//        long Q = 1658598167;
//
//        int R = 256;
//        int L = needle.length();
//        long RL = 1;
//        for(int i=0; i<L-1; i++){
//            RL = (RL*R)%Q;
//        }
//
//
//        long target = 0;
//        char[] nn = haystack.toCharArray();
//        for(int i=0; i<nn.length; i++){
//            target = ((R*target)%Q + nn[i])%Q;
//        }
//
//        int left = 0;
//        int right = 0;
//        long cur = 0;
//
//
//        while(right<n){
//            cur = ((R*cur)%Q + ss[right])%Q;
//            right++;
//
//            if(right-left==L){
//                if(cur==target){
//                    // for(int i=0; i<nn.length; i++){
//                    //     if(ss[left+i]!=nn[i]){
//                    //         break;
//                    //     }
//                    // }
//                    // return left;
//                    if(haystack.substring(left, right).equals(needle)){
//                        return left;
//                    }
//
//                }
//
//                cur = (cur - (RL*ss[left])%Q + Q)%Q;
//                left++;
//            }
//
//        }
//
//        return -1;
//
//    }
//}