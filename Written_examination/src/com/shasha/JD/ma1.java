package com.shasha.JD;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @author ShaLuwei
 * @create 2022-09-03 20:03
 */
public class ma1 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int max = 0;

        HashMap<Integer, Integer> memo = new HashMap<>();

        for(int i=0; i<n; i++){
            int cur = sc.nextInt();
            max = Math.max(max, cur);
            memo.put(cur, memo.getOrDefault(cur, 0)+1);
        }

        System.out.println(n-memo.get(max));

    }

}
