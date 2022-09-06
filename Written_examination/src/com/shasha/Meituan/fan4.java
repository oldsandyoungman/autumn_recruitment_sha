package com.shasha.Meituan;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author ShaLuwei
 * @create 2022-09-03 11:11
 */
public class fan4 {

    @Test
    public void test(){

        int n = 3;
        int m = 5;
        int k = 0;
        int[] city = {1,0,1,2,1};
        int[] a = {9,6,2,1,7};
        int[] b = {1,3,0,5,2};

        System.out.println(getMax(n,m,k,city,a,b));

    }

    public long getMax(int n, int m, int k, int[] city, int[] a, int[] b){

        // 这里的 city 统一减了1， k也减了1

        // dp[i][j]：第i天结束，在第j个城市的最大收益
        Long[][] dp = new Long[m][n];


        // base
        for (int i = 0; i < m; i++) {
            Arrays.fill(dp[i], Long.MIN_VALUE);
        }

        if(city[0]==k){
            dp[0][k] = (long) a[0];
        }else{
            dp[0][city[0]] = (long) b[0];
            dp[0][k] = 0L;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                long tmp_max = Long.MIN_VALUE;

                if(city[i]==j){
                    for (int kk = 0; kk < n; kk++) {
                        if(kk==j){
                            tmp_max = Math.max(tmp_max, dp[i-1][kk]+a[i]);
                        }else{
                            tmp_max = Math.max(tmp_max, dp[i-1][kk]+b[i]);
                        }
                    }
                }else {

                    tmp_max = Math.max(tmp_max, dp[i-1][j]);

                }


                dp[i][j] = tmp_max;
            }
        }

//        for (int i = 0; i < m; i++) {
//            System.out.println(Arrays.deepToString(dp[i]));
//        }


        long res = 0;

        for (int i = 0; i < n; i++) {
            res = Math.max(res, dp[m-1][i]);
        }

        return res;


    }

}
