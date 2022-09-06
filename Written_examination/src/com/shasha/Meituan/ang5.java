package com.shasha.Meituan;

import org.junit.Test;

/**
 * @author ShaLuwei
 * @create 2022-08-27 16:57
 */
public class ang5 {

    @Test
    public void test(){
        int n = 6;
        int k = 2;
        int T = 100;
        int[] t = new int[]{1,50};
        int[] e = new int[]{0,1,2,0,1,0};
        System.out.println(getMin(n,k,T,t,e));
    }

    private int getMin(int n, int k, int T, int[] t, int[] e) {
        int[] count = new int[k];
        return dp(n,k,T,t,e, count, 0);
    }

    private int dp(int n, int k, int T, int[] t, int[] e, int[] count, int index){
        if(index==n){
            return 0;
        }
        if(e[index]>0){
            count[e[index]-1]++;
            return dp(n,k,T,t,e, count, index+1);
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < count.length; i++) {
            if(count[i]>0){
                count[i]--;
                int cur = t[i] + dp(n,k,T,t,e, count, index+1);
                min = Math.min(min, cur);
                count[i]++;
            }
        }
        int choice = T + dp(n,k,T,t,e, count, index+1);
        min = Math.min(min, choice);
        return min;
    }


}
