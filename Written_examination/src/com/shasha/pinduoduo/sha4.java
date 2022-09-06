package com.shasha.pinduoduo;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author ShaLuwei
 * @create 2022-09-03 15:34
 */


/*

4 2 1
1 650
2 640
3 630
4 620

3 2 2
1 650
2 640
3 600

 */

public class sha4 {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int c = sc.nextInt();
        int r = sc.nextInt();
        int m = (int)Math.ceil(1.0*n/c);
        int[] nums = new int[n];
        for(int i=0; i<n; i++){
            sc.nextInt();
            nums[i] = sc.nextInt();
        }
        Arrays.sort(nums);
        // 从大到小排序
        int left = 0;
        int right = n-1;
        while(left<right){
            int tmp = nums[left];
            nums[left] = nums[right];
            nums[right] = tmp;
            left++;
            right--;
        }
        r--;

        double res = nums[r];
        int count = 1;
        boolean flag = true;
        double cur = 0;
        for(int i=0; i<n; i+=m){
            if(r>=i && r<i+m){
                continue;
            }
            cur = 0;
            if(i+m<=n){
                for(int j=0; j<m; j++){
                    cur += nums[i+j];
                }
                cur = cur /m;
                res += cur;
                count++;
            }else{
                flag = false;
                for(int j=0; i+j<n; j++){
                    cur += nums[i+j];
                }
                cur = cur /(n-i);
                break;
            }
        }
        if(!flag){
            res /= count;
            int rest = n%m;
            res = (1.0*rest/m)*(res*count + cur)/(count+1) + (1-1.0*rest/m)*res;
            System.out.println(String.format("%.2f",res));
            return;
        }
        res /= count;
        System.out.println(String.format("%.2f",res));
    }

}
