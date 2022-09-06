package com.shasha.origin;

import java.util.Arrays;

/**
 * @author ShaLuwei
 * @create 2022-09-04 00:27
 */
public class leetcode_0032 {


    public int longestValidParentheses(String s) {

        char[] ss = s.toCharArray();

        int n = ss.length;
        if(n<2){
            return 0;
        }
        // dp[i]：以第i个字符结尾，最长有效括号子串的长度
        int[] dp = new int[n];
        dp[0] = 0;
        if(ss[0]=='(' && ss[1]==')'){
            dp[1] = 2;
        }


        for(int i=2; i<n; i++){

            if(ss[i-1]=='(' && ss[i]==')'){
                dp[i] = dp[i-2] + 2;
                // dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
            }else{

                if(ss[i-1]==')' && ss[i]==')'){
                    if(i-dp[i-1]-2<0 || ss[i-dp[i-1]-1]==')'){
                        continue;
                    }
                    dp[i] = dp[i-1] + dp[i-dp[i-1]-2] + 2;
                    // dp[i] = dp[i - 1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                }

            }

        }

        System.out.println(Arrays.toString(dp));

        int res = 0;
        for(int i=0; i<n; i++){
            res = Math.max(res, dp[i]);
        }

        return res;

    }

}
