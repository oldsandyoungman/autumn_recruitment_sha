package com.shasha.Microsoft;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author ShaLuwei
 * @create 2022-08-19 22:24
 */
public class fan1 {

    public static void main(String[] args) {

    }

    @Test
    public void test(){
//        int[] X = {2,4,2,6,7,1};
//        int[] Y = {0,5,3,2,1,5};
//        int W = 2;

//        int[] X = {4,8,2,2,1,4};
//        int[] Y = {1,2,3,1,2,3};
//        int W = 3;

        int[] X = {0,3,6,5};
        int[] Y = {0,3,2,4};
        int W = 1;

        System.out.println(getMin(X, Y, W));
    }

    public int getMin(int[] X, int[] Y, int W){

        int n = X.length;

        Arrays.sort(X);

        int res = 1;

        int bound = X[0] + W;

        for(int i=1; i<n; i++){

            if(X[i]<=bound){
                continue;
            }
            res++;
            bound = X[i] + W;
        }

        return res;

    }

}
