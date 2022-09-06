package com.shasha.s20220722;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ShaLuwei
 * @create 2022-07-22 10:31
 */
public class Test_leetcode_18 {


    @Test
    public void test(){
        int[] nums = {1,0,-1,0,-2,2};
        int target = 0;
        System.out.println(fourSum(nums, target));

        ArrayList<Integer> l = new ArrayList<>();
        
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        return kSum(nums, target, 4, 0);
    }

    public List<List<Integer>> kSum(int[] nums, int target, int k, int start) {

        List<List<Integer>> res = new ArrayList<>();

        if(k==2){

            int l = start;
            int r = nums.length - 1;
            while(l<r){
                int numl = nums[l];
                int numr = nums[r];
                int sum = numl + numr;
                if(sum>target){
                    r--;
                    while(r>l && nums[r]==numr){
                        r--;
                    }
                }else if(sum<target){
                    l++;
                    while(l<r && nums[l]==numl){
                        l++;
                    }
                }else{
                    ArrayList<Integer> tmp = new ArrayList<>();
                    tmp.add(numl);
                    tmp.add(numr);
                    res.add(tmp);
                    r--;
                    while(r>l && nums[r]==numr){
                        r--;
                    }
                    l++;
                    while(l<r && nums[l]==numl){
                        l++;
                    }
                }
            }
            return res;

        }else{

            for(int i=start; i<nums.length; i++){
                int newTarget = target - nums[i];
                List<List<Integer>> cur = kSum(nums, newTarget, k-1, i+1);
                for(List<Integer> t : cur){
                    t.add(nums[i]);
                    res.add(t);
                }
                i++;
                while(i<nums.length && nums[i]+newTarget==target){
                    i++;
                }

            }
            return res;

        }
    }

}
