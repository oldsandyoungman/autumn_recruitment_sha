package com.shasha.origin;

import org.junit.Test;

/**
 * @author ShaLuwei
 * @create 2022-08-18 18:20
 */
public class leetcode_0712 {

    @Test
    public void test(){

        String s1 = "sea";
        String s2 = "eat";

        System.out.println(minimumDeleteSum(s1, s2));

    }


    public int minimumDeleteSum(String s1, String s2) {
        char[] ss1 = s1.toCharArray();
        char[] ss2 = s2.toCharArray();

        int n1 = ss1.length;
        int n2 = ss2.length;

        // dp[i][j]：s1[0~i], s2[0~j] 的变成相同的字符序列，扔掉的ASCII值
        int[][] dp = new int[n1+1][n2+1];

        // dp[0][i] = 0, dp[i][0] = 0;
        for(int i=1; i<=n1; i++){
            dp[i][0] = dp[i-1][0] + ss1[i-1];
        }
        for(int i=1; i<=n2; i++){
            dp[0][i] = dp[0][i-1] + ss2[i-1];
        }

        for(int i=1; i<=n1; i++){
            for(int j=1; j<=n2; j++){
                if(ss1[i-1]==ss2[j-1]){
                    dp[i][j] = dp[i-1][j-1];
                }else{
                    dp[i][j] = Math.min(dp[i][j-1]+ss2[j-1], dp[i-1][j]+ss1[i-1]);
                }
            }
        }

        return dp[n1][n2];

    }

}
