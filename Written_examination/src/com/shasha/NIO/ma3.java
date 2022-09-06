package com.shasha.NIO;

import java.util.Scanner;

/**
 * @author ShaLuwei
 * @create 2022-08-09 22:00
 */

public class ma3 {

    // GCACGACCTGA

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();
        int len = sc.nextInt();

        char[] ss = s.toCharArray();

        int n = ss.length;
        int l = 0;
        int r = 0;

        int count = 0;
        int res = 0;
        int res_l = 0;
        int res_r = 0;

        while(r<n){

            char cur = ss[r];
            if(cur=='C' || cur=='G'){
                count++;
            }
            r++;

            if(r-l>len){
                cur = ss[l];
                if(cur=='C' || cur=='G'){
                    count--;
                }
                l++;
            }

            if(r-l==len) {
                if (res < count) {
                    res = count;
                    res_l = l;
                    res_r = r;
                }
            }

        }

        System.out.println(s.substring(res_l, res_r));

    }


}
