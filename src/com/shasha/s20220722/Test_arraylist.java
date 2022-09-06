package com.shasha.s20220722;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ShaLuwei
 * @create 2022-07-22 09:47
 */
public class Test_arraylist {

    public static void main(String[] args) {

        List<Integer> l1 = Arrays.asList(1, 2, 3);
        System.out.println(l1.getClass());
//        l1.add(4); // 报错

        List<Integer> l2 = new ArrayList<>();
        System.out.println(l2.getClass());
        l2.add(4);

    }


    @Test
    public void test(){
        int[] nums = {-1,0,1,2,-1,-4};
        System.out.println(threeSum(nums));
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0; i<nums.length; ){
            int target = -nums[i];
            List<List<Integer>> cur = twoSum(nums, target, i+1);
            for(List<Integer> t : cur){
                t.add(nums[i]);
                res.add(t);
            }
            i++;
            if(i<nums.length && nums[i]+target==0){
                i++;
            }
        }
        return res;

    }

    public List<List<Integer>> twoSum(int[] nums, int target, int start){
        List<List<Integer>> res = new ArrayList<>();
        int l = start;
        int r = nums.length - 1;
        while(l<r){
            int numl = nums[l];
            int numr = nums[r];
            int sum = numl + numr;
            if(sum>target){
                r--;
                if(r>l && nums[r]==numr){
                    r--;
                }
            }else if(sum<target){
                l++;
                if(l<r && nums[l]==numl){
                    l++;
                }
            }else{
                res.add(Arrays.asList(numl, numr));
                r--;
                if(r>l && nums[r]==numr){
                    r--;
                }
                l++;
                if(l<r && nums[l]==numl){
                    l++;
                }
            }
        }

        return res;

    }

}
