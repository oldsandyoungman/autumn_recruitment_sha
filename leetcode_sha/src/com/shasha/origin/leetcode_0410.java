package com.shasha.origin;

import org.junit.Test;

/**
 * @author ShaLuwei
 * @create 2022-07-30 09:54
 */
public class leetcode_0410 {


    @Test
    public void test(){
        int[] nums = {7,2,5,10,8};
        int m = 2;
        System.out.println(splitArray(nums, m));
    }


    public int splitArray(int[] nums, int m) {

        // 反过来的理解：已知每组和的上限，求能分成多少组
        // 二分法，并且左边界（上限尽可能小）

        int n = nums.length;
        int max = 0;
        int sum = 0;
        for(int i=0; i<n; i++){
            max = Math.max(max, nums[i]);
            sum += nums[i];
        }

        int l = max;
        int r = sum;

        while(l<=r){
            int mid = l + (r-l)/2;
            if(getM(nums, mid)>m){
                l = mid + 1;
            }else{
                r = mid - 1;
            }
        }

        return l;

    }

    public int getM(int[] nums, int maxSum){
        int res = 1;
        int cur = 0;

        int n = nums.length;
        for(int i=0; i<n; i++){
            if(cur + nums[i] > maxSum){
                cur = nums[i];
                res++;
            }else{
                cur += nums[i];
            }
        }

        return res;

    }

}