package com.shasha.s20220709;

import java.util.Arrays;


/*





 */

public class bubbleSort {

    public static void main(String[] args) {
        int[] nums = new int[]{5,13,5,3,7,4,23,-6,-2};

        sort_sha(nums);

        System.out.println(Arrays.toString(nums));


    }

    public static void sort_sha(int[] nums){

        int n = nums.length;

        for (int i = n-1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (nums[j]>nums[j+1]){
                    int tmp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = tmp;
                }
            }
        }

    }

}
