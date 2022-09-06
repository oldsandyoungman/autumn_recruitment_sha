package com.shasha.amazon;

import org.junit.Test;

/**
 * @author ShaLuwei
 * @create 2022-08-28 10:38
 */
public class ce1 {

    @Test
    public void test(){
        int[] power = {1,2,6,7};
        int armor = 5;
        System.out.println(getMin(power, armor));
    }

    public int getMin(int[] power, int armor){
        int n = power.length;
        int sum = 0;
        int max = 0;

        for (int i : power) {
            sum += i;
            max = Math.max(max, i);
        }

        if(max<=armor){
            sum -= max;
        }else{
            sum -= armor;
        }

        return sum+1;

    }

}
