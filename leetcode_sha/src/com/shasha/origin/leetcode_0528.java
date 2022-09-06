package com.shasha.origin;

import org.junit.Test;

import java.util.Random;

/**
 * @author ShaLuwei
 * @create 2022-07-29 09:51
 */
public class leetcode_0528 {


    @Test
    public void test(){
        int[] w = {1,2,3,4,5};
        WeightedRandom wr = new WeightedRandom(w);
        System.out.println(wr.pickIndex());
//        System.out.println(wr.pickIndex2());
    }


    @Test
    public void test_right_bound(){
        int[] nums = {0,1,3,6,10,15};
        System.out.println(right_bound(nums, 2));
        System.out.println(right_bound(nums, 3));
        System.out.println(left_bound(nums, 2));
        System.out.println(left_bound(nums, 3));
    }

    int right_bound(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] == target) {
                // 这里改成收缩左侧边界即可
                left = mid + 1;
            }
        }
        // 最后改成返回 left - 1
        if (left - 1 < 0) return -1;
//        return nums[left - 1] == target ? (left - 1) : -1;
        return right;
    }

    int left_bound(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        // 搜索区间为 [left, right]
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                // 搜索区间变为 [mid+1, right]
                left = mid + 1;
            } else if (nums[mid] > target) {
                // 搜索区间变为 [left, mid-1]
                right = mid - 1;
            } else if (nums[mid] == target) {
                // 收缩右侧边界
                right = mid - 1;
            }
        }
        // 判断 target 是否存在于 nums 中
        // 此时 target 比所有数都大，返回 -1
        if (left == nums.length) return -1;
        // 判断一下 nums[left] 是不是 target
//        return nums[left] == target ? left : -1;
        return left;
    }

}


class WeightedRandom {

    int[] preSum;
    int total = 0;
    Random r;

    public WeightedRandom(int[] w) {
        int n = w.length;
        preSum = new int[n+1];
        for(int i=1; i<=n; i++){
            preSum[i] = preSum[i-1] + w[i-1];
        }
        total = preSum[n];
        r = new Random();
    }

    public int pickIndex() {
        // 如果取随机值是3，那么
//        int target = r.nextInt(total); // [0,14]
        int target = 1;
        System.out.println(target);
        int l = 0;
        int r = preSum.length-1;
        while (l<=r) {
            int mid = l + (r - l) / 2;
            if (preSum[mid] > target) {
                r = mid - 1;
            } else{
                l = mid + 1;
            }
        }
        return r;
    }
    public int pickIndex2() {
        // 1开始的话，
        int target = 1 + r.nextInt(total);
//        int target = 14;
        System.out.println(target);
        int l = 0;
        int r = preSum.length-1;
        while (l<=r) {
            int mid = l + (r - l) / 2;
            if (preSum[mid] < target) {
                l = mid + 1;
            } else{
                r = mid - 1;
            }
        }

        return l - 1;
    }




}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */