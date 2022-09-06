package com.shasha.Microsoft;

import org.junit.Test;

/**
 * @author ShaLuwei
 * @create 2022-08-13 11:00
 */
public class sha23 {

    @Test
    public void test(){
//        int[] A = {4,2,3,7};
//        int X = 2;
//        int Y = 2;

        int[] A = {10,3,4,7};
        int X = 2;
        int Y = 3;

//        int[] A = {4,2,5,4,3,5,1,4,2,7};
//        int X = 3;
//        int Y = 2;

        System.out.println(solution(A, A.length, X, Y));
    }

    int solution(int A[], int N, int X, int Y) {
        int res = 200000001;
        for(int i=0; i<Y; i++){

            if(i+(X-1)*Y>=N){
                continue;
            }

            int sum = 0;

            for(int j=0; j<X; j++){
                sum += A[i+j*Y];
            }

            res = Math.min(res, sum);

            int left = i;
            int right = i + X*Y;

            while (right<N) {

                sum += A[right] - A[left];
                res = Math.min(res, sum);

                left += Y;
                right += Y;

            }

        }

        return res;

    }

//    int solution(int A[], int N, int X, int Y) {
//        // write your code in C (C99 (gcc 6.2.0))
//
//        int res = 200000001;
//
//        for(int i=0; i+(X-1)*Y<N; i++){
//            int cur = 0;
//            for(int j=0; j<X; j++){
//                cur += A[i+j*Y];
//            }
//            res = Math.min(res, cur);
//        }
//
//        return res;
//
//    }

//    public int getMin(int[] A, int N, int X, int Y){
//        // dp[i][j][k]：到第i天晚上，还要做j次手术，k=1代表这天做了手术
//        int[][][] dp = new int[N][X+1][2];
//        int MAX_sha = 200000001;
//
//        // 初始化第0天
//        for(int i=0; i<=X; i++){
//            dp[0][i][0] = MAX_sha;
//            dp[0][i][1] = MAX_sha;
//        }
//        dp[0][X-1][1] = A[0];
//        dp[0][X][0] = 0;
//
//        for(int i=1; i<N; i++){
//            if(i>=Y){
//                for (int j = 0; j < X; j++) {
//                    dp[i][j][0] = Math.min(dp[i-1][j][0], dp[i-1][j][1]);
//                    dp[i][j][1] = dp[i-Y][j+1][1] + A[i];
//                }
//            }else{
//                for (int j = 0; j < X; j++) {
//                    dp[i][j][0] = Math.min(dp[i-1][j][0], dp[i-1][j][1]);
//                    dp[i][j][1] = dp[i-1][j][0] + A[i];
//                }
//            }
//
//        }
//
//        return Math.min(dp[N-1][0][0], dp[N-1][0][1]);
//
//    }

}
