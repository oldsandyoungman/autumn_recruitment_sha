package com.shasha.origin;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author ShaLuwei
 * @create 2022-08-26 23:24
 */
public class leetcode_1024 {

    @Test
    public void test(){

        int[][] clips = {{0,2}, {1,6}, {3,10}};
        int time = 10;

        System.out.println(videoStitching(clips, time));

    }

    public int videoStitching(int[][] clips, int time) {
        int n = clips.length;

        Arrays.sort(clips, (o1, o2) -> {
            if(o1[0]==o2[0]){
                return Integer.compare(o2[1], o1[1]);
            }
            return Integer.compare(o1[0], o2[0]);
        });

        int left = clips[0][0];
        int right = clips[0][1];

        if(left>0){
            return -1;
        }

        int res = 1;

        int max_right = 0;

        for(int i=1; i<n; i++){

            int cur_left = clips[i][0];
            int cur_right = clips[i][1];

            if(cur_right<=right){
                continue;
            }

            if(right<cur_left){
                return -1;
            }
            max_right = 0;
            while(i<n && right>=clips[i][0]){
                max_right = Math.max(max_right, clips[i][1]);
                i++;
            }
            i--;
            right = max_right;
            res++;

        }

        if(right<time){
            return -1;
        }

        return res;

    }

}
