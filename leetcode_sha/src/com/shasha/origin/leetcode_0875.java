package com.shasha.origin;

import org.junit.Test;

/**
 * @author ShaLuwei
 * @create 2022-07-30 10:10
 */
public class leetcode_0875 {

    public static void main(String[] args) {
    }


    @Test
    public void test(){

//        int[] piles = {3,6,7,11};
//        int h = 8;

        int[] piles = {805306368,805306368,805306368};
        int h = 1000000000;

        System.out.println(minEatingSpeed(piles, h));

    }

    public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;
        int max = 0;
        for(int i=0; i<n; i++){
            max = Math.max(max, piles[i]);
        }

        int l = 1;
        int r = max;

        while(l<=r){
            int mid = l + (r-l)/2;
            if(getH(piles, mid)>h){
                l = mid + 1;
            }else{
                r = mid - 1;
            }
        }

        return l;

    }

    public int getH(int[] piles, int k){
        int res = 0;

        int n = piles.length;
        for(int i=0; i<n; i++){
            int h = piles[i]/k;
            res += h;
            if(piles[i] > k*h){
                res++;
            }
        }

        return res;

    }

}
