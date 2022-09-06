package com.shasha.S360;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author ShaLuwei
 * @create 2022-08-27 15:24
 */
public class ang2 {
    @Test
    public void test(){
        int[] nums = {1,9,2,8,3,7,4,6,5};
        cal(nums);
        System.out.println(Arrays.toString(nums));
    }

    public void cal(int[] nums){
        int n = nums.length;
        sort(nums, 0, n-1);
    }

    public void sort(int[] nums, int l, int r){
        if(r-l<=2){
            return;
        }
        int mid = l + (r-l)/2;
        int val = nums[mid];
        int i = l;
        int j = r;
        int[] copy_nums = Arrays.copyOf(nums, nums.length);
        for (int ii = l; ii <= r; ii++) {
            if(copy_nums[ii]<val){
                nums[i] = copy_nums[ii];
                i++;
            }
        }
        for (int ii = r; ii >= l; ii--) {
            if(copy_nums[ii]>val){
                nums[j] = copy_nums[ii];
                j--;
            }
        }
        nums[i] = val;
        sort(nums, l, i-1);
        sort(nums, i+1, r);

    }

}
