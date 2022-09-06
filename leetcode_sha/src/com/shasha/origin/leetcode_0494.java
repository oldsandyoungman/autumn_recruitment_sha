package com.shasha.origin;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author ShaLuwei
 * @create 2022-08-20 00:50
 */
public class leetcode_0494 {

    @Test
    public void test(){
        int[] nums = {1,1,1,1,1};
        int target = 3;
        System.out.println(findTargetSumWays(nums, target));
    }

    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        int sum = 0;
        for(int num : nums){
            sum += num;
        }
        int tmp = sum + target;
        if(tmp%2==0){
            return 0;
        }

        int new_target = tmp/2;

        System.out.println(new_target);

        int[][] dp = new int[n+1][new_target+1];

        // base: dp[0][0]=1, dp[0][i]=0, dp[i][0]其实不能直接确定
        dp[0][0] = 1;

        for(int i=1; i<=n; i++){
            for(int j=0; j<=new_target; j++){
                if(nums[i-1]<=j){
                    dp[i][j] = dp[i-1][j] + dp[i-1][j-nums[i-1]];
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        System.out.println(Arrays.deepToString(dp));

        return dp[n][new_target];

    }
}
