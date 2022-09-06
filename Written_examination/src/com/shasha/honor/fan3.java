package com.shasha.honor;

import java.util.Scanner;

/**
 * @author ShaLuwei
 * @create 2022-08-30 18:34
 */
public class fan3 {

/*
today is a good day
is a dog day too

today is a good day
is a go day too

 */


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String t = sc.nextLine();
        String s = sc.nextLine();

        String[] tt = t.trim().split("\\s+");
        String[] ss = s.trim().split("\\s+");

        int m = ss.length;
        int n = tt.length;

        // dp[i][j]：ss[0~i] 变成 tt[0~j] 要扣的分数最小值
        int[][] dp = new int[m+1][n+1];

        for (int i = 1; i < m; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j < n; j++) {
            dp[0][j] = 2*j;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if(ss[i-1].equals(tt[j-1])){
                    dp[i][j] = dp[i-1][j-1];
                }else{
                    // 删除
                    int choice1 = dp[i-1][j] + 1;

                    // 增加
                    int choice2 = dp[i][j-1] + 2;

                    // 修改 或 删+增
                    char[] char_tt = tt[j-1].toCharArray();
                    int[] count_tt = new int[256];
                    for(char tmp : char_tt){
                        count_tt[tmp]++;
                    }
                    char[] char_ss = ss[i-1].toCharArray();
                    int tmp_cout = 0;
                    for(char tmp : char_ss){
                        if(count_tt[tmp]>0) {
                            tmp_cout++;
                            count_tt[tmp]--;
                        }
                    }
                    int choice3 = -1;
                    if(tmp_cout*2>char_tt.length){
                        // 修改
                        choice3 = dp[i-1][j-1] + 1;
                    }else{
                        // 删+增
                        choice3 = dp[i-1][j-1] + 3;
                    }

                    dp[i][j] = Math.min(Math.min(choice1,choice2), choice3);

                }


            }
        }
        int res = tt.length - dp[m][n];
        System.out.println(res);

    }

}
