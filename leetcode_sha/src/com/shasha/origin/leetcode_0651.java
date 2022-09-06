package com.shasha.origin;

import org.junit.Test;

import java.util.HashMap;

/**
 * @author ShaLuwei
 * @create 2022-08-24 12:19
 */
public class leetcode_0651 {

    @Test
    public void test(){

    }

    int maxA(int N){

        memo = new HashMap<>();

        return dp(N,0,0);
    }

    HashMap<String, Integer> memo;

    // 屏幕上最多显示多少个A
    public int dp(int N, int screen, int clipboard){
        if(N==0){
            return screen;
        }
        String key = N + "," + screen + "," + clipboard;
        if(memo.containsKey(key)){
            return memo.get(key);
        }
        if(N==1){
            int choice1 = screen + 1;
            int choice2 = screen + clipboard;
            int res = Math.max(choice1, choice2);
            memo.put(key, res);
            return res;
        }

        int choice1 = dp(N-1, screen+1, clipboard);
        int choice2 = dp(N-1, screen+clipboard, clipboard);
        // 全选 + 复制
        int choice3 = dp(N-2, screen, screen);

        int res = Math.max(Math.max(choice1, choice2), choice3);
        memo.put(key, res);
        return res;

    }

    int maxA2(int N){

        int[] dp = new int[N+1];
        // base dp[0] = 0;
        for (int i = 1; i <= N; i++) {
            int max = dp[i-1] + 1;
            for(int j=2; j<i; j++){
                max = Math.max(max, dp[j-2]*(i-j+1));
            }
            dp[i] = max;
        }

        return dp[N];

    }

}
