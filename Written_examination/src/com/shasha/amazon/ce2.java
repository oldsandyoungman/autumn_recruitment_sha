package com.shasha.amazon;

import org.junit.Test;

/**
 * @author ShaLuwei
 * @create 2022-08-28 10:38
 */
public class ce2 {

    @Test
    public void test(){

        int[] nums = {1,3,2,3};
        System.out.println(getMinDiff(nums));

    }

    public int getMinDiff(int[] stockPrice){

        int n = stockPrice.length;

        long[] preSum = new long[n];
        long[] postSum = new long[n];

        preSum[0] = stockPrice[0];
        postSum[n-1] = stockPrice[n-1];

        for(int i=1; i<n; i++){
            preSum[i] = preSum[i-1] + stockPrice[i];
        }
        for(int i=n-2; i>=0; i--){
            postSum[i] = postSum[i+1] + stockPrice[i];
        }

        long res = Long.MAX_VALUE;
        int index = -1;
        for (int i = 0; i < n-1; i++) {
            long avg1 = preSum[i]/(i+1);
            long avg2 = postSum[i+1]/(n-i-1);
            long diff = Math.abs(avg1-avg2);
            if(diff<res){
                res = diff;
                index = i;
            }
        }

        return index+1;
    }


}
