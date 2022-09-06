package com.shasha.common_algorithm;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author ShaLuwei
 * @create 2022-08-16 20:10
 */
public class bubble_count {

    @Test
    public void test(){

        int[] nums = new int[]{1,5,3,2,4};
        sort(nums);
        System.out.println(Arrays.toString(nums));

    }

    public void sort(int[] nums){

        int n = nums.length;

        for (int i = 1; i < n; i++) {

            boolean flag = true;

            for (int j = 0; j < n - i; j++) {

                if(nums[j]>nums[j+1]){
                    int tmp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = tmp;
                    flag = false;
                }

            }

            if(flag){
                break;
            }

        }

    }

}
