package com.shasha.JD;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @author ShaLuwei
 * @create 2022-09-03 19:38
 */
public class ma2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] nums = new int[n];
        int max = 0;
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
            max = Math.max(max, nums[i]);
        }


        int[] dp = new int[100001];
        Arrays.fill(dp, max);

        // base
        dp[1] = 0;
        dp[2] = 1;
        dp[3] = 2;

        for(int i=2; i<=max; i++){
            dp[i] = Math.min(dp[i],dp[i-1]+1);
            for(int j=2; j<i; j++){
                if(i*j>max){
                    break;
                }
                dp[i*j] = Math.min(dp[i*j],dp[i]+dp[j]+1);
            }
        }

        int res = 0;
        for(int num : nums){
            res += dp[num];
        }

        System.out.println(res);

//        memo = new HashMap<>();
//        int res = 0;
//        for(int num : nums){
//            res += dp(num);
//        }
//
//        System.out.println(res);

    }

    static HashMap<Integer, Integer> memo;

    private static int dp(int num) {
        if(num<=2){
            return num-1;
        }
        if(memo.containsKey(num)){
            return memo.get(num);
        }

        int choice = dp(num-1) + 1;

        int target = (int)Math.sqrt(num);
        for(int i=2; i<=target; i++){
            if(num%i==0){
                choice = Math.min(choice, dp(i)+dp(num/i)+1);
            }
        }

        memo.put(num, choice);

        return choice;
    }

}
