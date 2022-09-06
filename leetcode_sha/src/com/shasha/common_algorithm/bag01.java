package com.shasha.common_algorithm;

/**
 * @author ShaLuwei
 * @create 2022-08-31 16:15
 */
public class bag01 {


    public static void main(String[] args) {

        int[] wt = {8,11,14,5,9,5};
        int[] val = {20,15,40,10,25,30};

        System.out.println(getMax(wt, val, 30));

    }

    public static int getMax(int[] wt, int[] val, int W){
        int N = wt.length;

        int[][] dp = new int[N + 1][W + 1];
        for (int i = 1; i <= N; i++) {
            for (int w = 1; w <= W; w++) {
                if (w - wt[i - 1] < 0) {
                    // 这种情况下只能选择不装入背包
                    dp[i][w] = dp[i - 1][w];
                } else {
                    // 装入或者不装入背包，择优
                    dp[i][w] = Math.max(
                            dp[i - 1][w - wt[i-1]] + val[i-1],
                            dp[i - 1][w]
                    );
                }
            }
        }

        return dp[N][W];

    }

}
