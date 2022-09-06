package com.shasha.ByteDance;

import java.util.Arrays;

/**
 * @author ShaLuwei
 * @create 2022-08-21 22:18
 */
public class fan4 {


    public static void main(String[] args) {



    }

    public double[] res(int[] nums, int n){
        int m = 0;
        for(int i : nums){
            m += i;
        }

        int[][] dp = new int[n+1][m+1];

        int sum = 1;

        for (int num : nums) {
            sum *= num;
        }

        dp[0][0] = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = i; j <= m; j++) {
                for (int k = 1; k <= nums[i-1]; k++) {
                    if(j>=k){
                        dp[i][j] += dp[i-1][j-k];
                    }
                }
            }
        }

        double[] res = new double[m+1];
        for (int i = 0; i <= m; i++) {
            res[i] = 1.0*dp[n][i]/sum;
        }

        System.out.println(Arrays.toString(res));

        return res;

    }

}
