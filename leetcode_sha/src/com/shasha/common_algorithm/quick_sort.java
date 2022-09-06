package com.shasha.common_algorithm;

import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

/**
 * @author ShaLuwei
 * @create 2022-08-07 10:10
 */
public class quick_sort {

    public static void main(String[] args) {

    }

    @Test
    public void test(){
        int[] nums = {1,5,2,4,3};
        sort_all(nums);
        System.out.println(Arrays.toString(nums));
    }

    public void sort_all(int[] nums){

        shuffle(nums);
        int n = nums.length;
        sort(nums, 0, n-1);

    }

    private void shuffle(int[] nums) {

        int n = nums.length;
        Random r = new Random();
        for(int i=0; i<n; i++){
            int j = i + r.nextInt(n-i);
            swap(nums, i, j);
        }

    }

    public void sort(int[] nums, int start, int end){
        if(start>=end){
            return;
        }
        int index = divide(nums, start, end);
        sort(nums, start, index-1);
        sort(nums, index+1, end);
    }

    private int divide(int[] nums, int start, int end) {

        int l = start+1;
        int r = end;
        int val = nums[start];

        // 保证 [start,l) <= val && (r,end]>val

        while (l<=r){

            while(l<end && nums[l]<=val){
                l++;
            }

            while (r>start && nums[r]>val){
                r--;
            }

            if(l>=r){
                break;
            }

            swap(nums, l, r);

        }

        swap(nums, start, r);
        return r;

    }

    private void swap(int[] nums, int l, int r) {
        int tmp = nums[l];
        nums[l] = nums[r];
        nums[r] = tmp;
    }

}
