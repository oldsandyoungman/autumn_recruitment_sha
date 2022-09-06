package com.shasha.common_algorithm;

import org.junit.Test;

/**
 * @author ShaLuwei
 * @create 2022-08-25 21:02
 */
public class two_divide {


    @Test
    public void test(){

        int[] nums = {1,2,3,6,9};
        int target = 3;

        System.out.println(find11(nums, target));


    }


    public int find1(int[] nums, int target){

        int n = nums.length;
        int l = 0;
        int r = n-1;
        while(l<=r){
            int mid = l + (r-l)/2;
            if(nums[mid]==target){
                return mid;
            }else if(nums[mid]>target){
                r = mid - 1;
            }else{
                l = mid + 1;
            }
        }

        return -1;

    }


    public int find11(int[] nums, int target){

        int n = nums.length;
        int l = 0;
        int r = n;
        if(l<r){
            int mid = l + (r-l)/2;
            if(nums[mid]==target){
                return mid;
            }else if(nums[mid]>target){
                r = mid;
            }else{
                l = mid + 1;
            }
        }

        return -1;

    }


}
