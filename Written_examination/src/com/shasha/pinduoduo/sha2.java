package com.shasha.pinduoduo;

import java.util.Scanner;

/**
 * @author ShaLuwei
 * @create 2022-09-03 16:16
 */

/*

1
3
L 1
L 1
R 1

 */

public class sha2 {


    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        int nn = sc.nextInt();

        for(int i=0; i<nn; i++){

            int n = sc.nextInt();

            int[] steps = new int[n];
            int[] res = new int[n];
            boolean[] memo = new boolean[n];

            sc.nextLine();

            for(int j=0; j<n; j++){
                String s = sc.nextLine();
                String[] ss = s.split(" ");
                int sign = 1;
                if(ss[0].equals("R")){
                    sign = 1;
                }else{
                    sign = -1;
                }
                int tmp = Integer.parseInt(ss[1]);
                steps[j] = sign*tmp;
            }


            for(int j=0; j<n; j++){
                if(res[j]==0){
                    dfs(j, res, steps, memo);
                }
            }

            for(int j=0; j<n; j++){
                System.out.println(res[j]);
            }



        }

    }

    public static int dfs(int cur, int[] res, int[] steps, boolean[] memo){
        int n = res.length;
        if(cur<0 || cur>=n){
            return 0;
        }
        if(res[cur]!=0){
            return res[cur];
        }
        if(memo[cur]){
            return -1;
        }

        memo[cur] = true;

        int count = dfs(cur+steps[cur], res, steps, memo);

        if(count==-1){
            res[cur] = -1;
        }else{
            res[cur] = count + 1;
        }

        memo[cur] = false;
        return res[cur];
    }

}
