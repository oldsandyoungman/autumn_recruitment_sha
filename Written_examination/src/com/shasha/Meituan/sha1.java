package com.shasha.Meituan;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author ShaLuwei
 * @create 2022-08-13 15:56
 */
public class sha1 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int t = sc.nextInt();

        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        Arrays.sort(nums);

        int sum = 0;
        int cur = t;

        for (int i = 0; i < n; i++) {
            if(nums[i]>=cur){
                sum++;
                cur += t;
            }
        }
        System.out.println(n-sum);
    }




}
