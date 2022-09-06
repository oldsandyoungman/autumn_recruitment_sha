package com.shasha.Huatai;

import java.util.Scanner;

/**
 * @author ShaLuwei
 * @create 2022-08-28 22:25
 */
public class sha3 {

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }

        int k = sc.nextInt();
        int d = sc.nextInt();

        long[] dp_max = new long[n];
        long[] dp_min = new long[n];
        for(int i=0; i<n; i++){
            dp_max[i] = arr[i];
            dp_min[i] = arr[i];
        }

        int cur = 2;

        while(cur<=k){

            for(int i=n-1; i>=cur-1; i--){

                long min_val = dp_min[i-1];
                long max_val = dp_max[i-1];

                for(int j=1; j<=d; j++){

                    if(i-j>= cur-2){

                        min_val = Math.min(min_val, dp_min[i-j]);
                        max_val = Math.max(max_val, dp_max[i-j]);

                    }else{

                        break;

                    }

                    dp_max[i] = Math.max(arr[i]*max_val, arr[i]*min_val);
                    dp_min[i] = Math.min(arr[i]*max_val, arr[i]*min_val);

                }

                cur++;

            }

        }

        long res = dp_max[k-1];

        for(int i=k; i<n; i++){
            res = Math.max(res, dp_max[i]);
        }


        System.out.println(res);
    }



}
