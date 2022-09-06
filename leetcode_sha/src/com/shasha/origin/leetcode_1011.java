package com.shasha.origin;

import org.junit.Test;

/**
 * @author ShaLuwei
 * @create 2022-07-30 09:34
 */
public class leetcode_1011 {

    public static void main(String[] args) {

    }

    @Test
    public void test(){
        int[] weights = {1,2,3,4,5,6,7,8,9,10};
        int days = 5;
        System.out.println(shipWithinDays(weights, days));
    }

    public int shipWithinDays(int[] weights, int days) {
        int n = weights.length;
        int max = 0;
        int sum = 0;
        for(int i=0; i<n; i++){
            max = Math.max(max, weights[i]);
            sum += weights[i];
        }

        int l = max;
        int r = sum;

        while(l<=r){
            int mid = l + (r-l)/2;
            if(getDays(weights, mid)>days){
                l = mid + 1;
            }else{
                r = mid - 1;
            }
        }

        return l;

    }

    public int getDays(int[] weights, int cap){
        int days = 0;
        int cur = 0;

        int n = weights.length;

        for(int i=0; i<n; i++){

            if(cur + weights[i] <= cap){
                cur += weights[i];
            }else {
                cur = weights[i];
                days++;
            }

        }

        if(cur>0){
            days++;
        }

        return days;

    }

}