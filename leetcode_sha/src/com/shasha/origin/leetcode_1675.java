package com.shasha.origin;

import org.junit.Test;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author ShaLuwei
 * @create 2022-08-07 22:31
 */
public class leetcode_1675 {

    public static void main(String[] args) {


    }

    @Test
    public void test(){

        int[] nums = {4,1,5,20,3};

        System.out.println(minimumDeviation(nums));

    }

    public int minimumDeviation(int[] nums) {
        int ans, mn;
        Arrays.sort(nums);
        int n = nums.length;
        mn = Integer.MAX_VALUE;
        ans = nums[n - 1] - nums[0];
        PriorityQueue<Integer> q = new PriorityQueue<>((a, b) -> b - a);

        for (int i = 0; i < n; i++) {
            if (nums[i] % 2 != 0)
                nums[i] *= 2;
            q.add(nums[i]);
            mn = Math.min(mn, nums[i]);
        }

        while (!q.isEmpty()) {
            int now = q.poll();
            ans = Math.min(ans, now - mn);
            if (now % 2 != 0) break;
            q.add(now / 2);
            mn = Math.min(mn, now / 2);
        }

        return ans;

    }

}
