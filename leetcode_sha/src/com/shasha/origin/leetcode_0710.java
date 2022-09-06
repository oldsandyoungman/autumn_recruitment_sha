package com.shasha.origin;

import java.util.HashSet;
import java.util.Random;

/**
 * @author ShaLuwei
 * @create 2022-08-01 07:42
 */
public class leetcode_0710 {

    public static void main(String[] args) {
        BlackList b = new BlackList(4, new int[]{0, 1});

    }



}


class BlackList {

    int count;
    int[] nums;
    Random r;

    public BlackList(int n, int[] blacklist) {
        int bn = blacklist.length;
        count = n - bn;
        nums = new int[count];
        r = new Random();

        for(int i=0; i<count; i++){
            nums[i] = i;
        }

        HashSet<Integer> s = new HashSet<>();
        for (int i : blacklist) {
            s.add(i);
        }

        int tail = n - 1;

        for(int b : blacklist){
            if(b < count){
                while(s.contains(tail)){
                    tail--;
                }
                nums[b] = tail;
                tail--;
            }
        }

    }

    public int pick() {

        int i = r.nextInt(count);
        return nums[i];

    }
}

/*
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(n, blacklist);
 * int param_1 = obj.pick();
 */
