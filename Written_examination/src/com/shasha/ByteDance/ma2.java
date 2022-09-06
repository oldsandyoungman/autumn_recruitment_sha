package com.shasha.ByteDance;

import java.util.Scanner;

/**
 * @author ShaLuwei
 * @create 2022-08-21 20:44
 */
public class ma2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt();
        int n = sc.nextInt();

        char[][] matrix = new char[m][n];

        int start_r = -1;
        int start_c = -1;

        for (int i = 0; i < m; i++) {
            String tmp = sc.nextLine();
            matrix[i] = tmp.toCharArray();
            for (int j = 0; j < matrix[i].length; j++) {
                if(matrix[i][j]=='O'){
                    start_r = i;
                    start_c = j;
                }
            }
        }

        res = 0;

        final_dis = new int[m][n];

//        dfs(matrix, start_r, start_c);

        System.out.println(res);

    }

    static int res;


    public static void dfs(char[][] matrix, int start_r, int start_c){

    }

    static int[][] final_dis;

    public static void pre(char[][] matrix){
//        int m = matrix.length;
//        int n = matrix[0].length;
//
//        for

    }


}
