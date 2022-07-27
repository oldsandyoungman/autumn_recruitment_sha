package com.shasha.HuaWei;

import java.util.HashSet;
import java.util.Scanner;

/**
 * @author ShaLuwei
 * @create 2022-07-27 19:38
 */
public class other2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        System.out.println(getNum(s));

    }

    private static HashSet<Integer> set_feibo;

    public static int getNum(String s){

        char[] ss = s.toCharArray();

        set_feibo = new HashSet<>();
        create_feibo(ss.length);

        HashSet<String> res = new HashSet<>();

        for (int l = 0; l < ss.length; l++) {
            int r = l;
            int[] memo = new int[256];
            int kinds = 0;

            while (r<ss.length) {

                char cur = ss[r];
                if(memo[cur]==0){
                    kinds++;
                }
                memo[cur]++;
                r++;

                if (set_feibo.contains(kinds)){
                    res.add(s.substring(l,r));
                }

            }

        }

        return res.size();

    }

    private static void create_feibo(int length) {
//        if(length==1){
//            set_feibo.add(1);
//            return;
//        }
//        if(length==2){
//            set_feibo.add(1);
//            set_feibo.add(2);
//            return;
//        }
//
//        int l = 1;
//        int r = 2;
//        int cur = l+r;
//        while(cur<=length){
//            set_feibo.add(cur);
//            l = r;
//            r = cur;
//            cur = l + r;
//        }

        // 只有26个小写英文字母
        set_feibo.add(1);
        set_feibo.add(2);
        set_feibo.add(3);
        set_feibo.add(5);
        set_feibo.add(8);
        set_feibo.add(13);
        set_feibo.add(21);

    }


}
