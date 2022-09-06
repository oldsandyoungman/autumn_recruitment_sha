package com.shasha.origin;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ShaLuwei
 * @create 2022-08-05 09:37
 */
public class leetcode_0315 {

    @Test
    public void test(){

        int[] nums = {-1, -1};

        System.out.println(countSmaller(nums));

    }

    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        tmp = new Pair[n];
        count = new int[n];

        Pair[] src = new Pair[n];
        for(int i=0; i<n; i++){
            src[i] = new Pair(nums[i], i);
        }

        sort(src, 0, n-1);

        List<Integer> res = new ArrayList<>();
        for(int cur : count){
            res.add(cur);
        }
        return res;
    }

    private class Pair{
        int val;
        int id;
        Pair(int val, int id){
            this.val = val;
            this.id = id;
        }
    }

    Pair[] tmp;
    int[] count;

    private void sort(Pair[] nums, int start, int end){
        if(start>=end){
            return;
        }
        int mid = start + (end-start)/2;
        sort(nums, start, mid);
        sort(nums, mid+1, end);
        merge(nums, start, mid, end);
    }

    private void merge(Pair[] nums, int start, int mid, int end){
        for(int i=start; i<=end; i++){
            tmp[i] = nums[i];
        }

        int l = start;
        int r = mid+1;
        int index = start;

        while(l<=mid && r<=end){
            if(tmp[l].val<=tmp[r].val){
                nums[index] = tmp[l++];
                count[nums[index].id] += r-mid-1;
                index++;
            }else{
                nums[index] = tmp[r++];
                index++;
            }
        }

        if(l==mid+1){
            while(r<=end){
                nums[index] = tmp[r++];
                index++;
            }
        }else{
            while(l<=mid){
                nums[index] = tmp[l++];
                count[nums[index].id] += r-mid-1;
                index++;
            }
        }

    }



}