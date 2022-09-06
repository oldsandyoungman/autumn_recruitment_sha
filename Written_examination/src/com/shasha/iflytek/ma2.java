package com.shasha.iflytek;

import java.util.Scanner;

/**
 * @author ShaLuwei
 * @create 2022-07-23 18:54
 */
public class ma2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int[][] nums = new int[N][2];

        for (int i = 0; i < N; i++) {
            nums[i][0] = sc.nextInt();
            nums[i][1] = sc.nextInt();
        }

        int res = calNum(nums);

        System.out.println(res);


    }


    public static int calNum(int[][] nums){

        int n = nums.length;

        int res = 0;

        for (int i = 0; i < n; i++) {

            int x1 = nums[i][0];
            int y1 = nums[i][1];

            for (int j = i+1; j < n; j++) {

                int x2 = nums[j][0];
                int y2 = nums[j][1];

                for (int k = j+1; k < n; k++) {

                    int x3 = nums[k][0];
                    int y3 = nums[k][1];

                    if(judge90(x1, y1, x2, y2, x3, y3)){
                        res++;
                    }

                }
            }
        }

        return res;

    }




    public static boolean judge90(int x1, int y1, int x2, int y2, int x3, int y3){

        int delta_x_12 = x1 - x2;
        int delta_y_12 = y1 - y2;
        int delta_x_13 = x1 - x3;
        int delta_y_13 = y1 - y3;
        int delta_x_23 = x2 - x3;
        int delta_y_23 = y2 - y3;

        int res12_23 = delta_y_12 * delta_y_23 + delta_x_23 * delta_x_12;
        int res13_23 = delta_y_13 * delta_y_23 + delta_x_13 * delta_x_23;
        int res12_13 = delta_y_12 * delta_y_13 + delta_x_12 * delta_x_13;

        if(res12_13==0 || res13_23 == 0 || res12_23 == 0 ){
            return true;
        }

        return false;
    }


}
