package com.shasha.honor;

import java.util.Scanner;

/**
 * @author ShaLuwei
 * @create 2022-08-30 19:01
 */

/*
200 0 200 10 200 50 200 30 200 25
 */


public class fan2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[][] nums = new int[6][2];
        // 起点
        nums[0][0] = 0;
        nums[0][1] = 0;
        for (int i = 1; i <= 5; i++) {
            nums[i][0] = sc.nextInt();
            nums[i][1] = sc.nextInt();
        }

        visited = new boolean[6];
        visited[0] = true;
        res = Integer.MAX_VALUE;

        dfs(nums, 0, 0);

        System.out.println((int)res);

    }

    static boolean[] visited;
    static double res;

    public static void dfs(int[][] nums, int index, double sum){
        if(visited[1]&&visited[2]&&visited[3]&&visited[4]&&visited[5]){
            sum += calDis(nums, index, 0);
            res = Math.min(res, sum);
            return;
        }

        for (int i = 1; i <= 5; i++) {

            if(i!=index && !visited[i]){
                double dis = calDis(nums, index, i);
                sum += dis;
                visited[i] = true;
                dfs(nums, i, sum);
                sum -= dis;
                visited[i] = false;
            }

        }

    }

    public static double calDis(int[][] nums, int i, int j){
        int dx = nums[i][0] - nums[j][0];
        int dy = nums[i][1] - nums[j][1];
        return Math.sqrt(Math.pow(dx, 2)+Math.pow(dy, 2));
    }

}
