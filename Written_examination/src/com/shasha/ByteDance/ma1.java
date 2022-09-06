package com.shasha.ByteDance;

import org.junit.Test;

/**
 * @author ShaLuwei
 * @create 2022-08-21 19:09
 */
public class ma1 {

    @Test
    public void test(){
//        int[] nums = {2,5};
        int[] nums = {6,2,4};
        System.out.println(getMin(nums));
    }

    public int getMin(int[] nums){

        int seat_with_2 = 0;
        int sum = 0;

        for(int num : nums){
            int kind = num%4;
            if(kind==0){
                sum += num/4;
                continue;
            }
            if (kind%4==2) {
                sum += num/4;
                seat_with_2++;
                if(seat_with_2==2){
                    sum++;
                    seat_with_2 = 0;
                }
                continue;
            }
            if(kind%4==3){
                sum += num/4 + 1;
                continue;
            }

            sum += num/4;
            if(num==1){
                sum++;
                continue;
            }
            if(seat_with_2==1){
                sum++;
                seat_with_2 = 0;
            }else {
                seat_with_2++;
            }

        }

        if(seat_with_2==1){
            sum++;
        }

        return sum-1;

    }

}
