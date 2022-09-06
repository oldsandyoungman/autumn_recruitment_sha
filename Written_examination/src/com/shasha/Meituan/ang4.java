package com.shasha.Meituan;

import org.junit.Test;

/**
 * @author ShaLuwei
 * @create 2022-08-27 16:15
 */
public class ang4 {

    @Test
    public void test(){
        int n = 3;
        int b = 5;
        int[] p = {1,2,3};
        int[] t = {7,5,3};
        System.out.println(getMin(n,b,p,t));
    }

    private int getMin(int n, int b, int[] p, int[] t) {
        // dp[i][j]：只用前i个机器人，在j电量的情况下，最少用时
        int[][] dp = new int[n+1][b+1];

        return 0;

    }

//    public int getMin(){
//
//    }

}
