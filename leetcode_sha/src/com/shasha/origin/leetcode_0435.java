package com.shasha.origin;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author ShaLuwei
 * @create 2022-08-26 12:43
 */
public class leetcode_0435 {

    @Test
    public void test(){

        int[][] ints = {{1,2},{2,3},{3,4},{1,3}};
        System.out.println(eraseOverlapIntervals(ints));

    }

    public int eraseOverlapIntervals(int[][] intervals) {
        int n = intervals.length;

        Arrays.sort(intervals, (o1, o2) -> {
            if(o1[1]==o2[1]){
                return Integer.compare(o1[0], o2[0]);
            }
            return Integer.compare(o1[1], o2[1]);
        });

        int res = 0;

        int left = intervals[0][0];
        int right = intervals[0][1];

        for(int i=1; i<n; i++){

            int cur_left = intervals[i][0];
            int cur_right = intervals[i][1];

            if(cur_left<right){
                res++;
                continue;
            }

            right = cur_right;



        }

        return res;

    }
}
