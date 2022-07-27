package com.shasha.HuaWei;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @author ShaLuwei
 * @create 2022-07-27 20:18
 */
public class other3 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] intvs = new int[n][2];
        for (int i = 0; i < n; i++) {
            intvs[i][0] = sc.nextInt();
            intvs[i][1] = sc.nextInt();
        }

        System.out.println(eraseOverlapIntervals(intvs));

    }


    public static int eraseOverlapIntervals(int[][] intervals) {
        int n = intervals.length;
        return n - intervalSchedule(intervals);
    }

    // 区间调度算法，算出 intvs 中最多有几个互不相交的区间
    private static int intervalSchedule(int[][] intvs) {
        if (intvs.length == 0) return 0;
        // 按 end 升序排序
        Arrays.sort(intvs, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[1] - b[1];
            }
        });
        // 至少有一个区间不相交
        int count = 1;
        // 排序后，第一个区间就是 x
        int x_end = intvs[0][1];
        for (int[] interval : intvs) {
            int start = interval[0];
            if (start >= x_end) {
                // 找到下一个选择的区间了
                count++;
                x_end = interval[1];
            }
        }
        return count;
    }



}
