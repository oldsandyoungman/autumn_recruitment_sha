package Kuaishou;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author ShaLuwei
 * @create 2022-08-18 13:58
 */
public class ma1 {

    @Test
    public void test(){
        int[] nums = {3,1,2,4};
        cal(nums);
        System.out.println(Arrays.toString(nums));
    }

    public void cal(int[] nums){
        int n = nums.length;
        int l = 0;
        int r = n-1;

        while(l<=r){
            while (l<r && nums[l]%2==0) {
                l++;
            }
            while(l<r &&nums[r]%2==1){
                r--;
            }
            int tmp = nums[l];
            nums[l] = nums[r];
            nums[r] = tmp;
            l++;
            r--;
        }


    }

}
