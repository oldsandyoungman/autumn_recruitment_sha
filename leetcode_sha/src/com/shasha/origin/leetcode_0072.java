package com.shasha.origin;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author ShaLuwei
 * @create 2022-08-18 20:05
 */
public class leetcode_0072 {

    @Test
    public void test(){

        String word1 = "horse", word2 = "ros";
//        State state = minDistance(word1, word2);
//        System.out.println(state.val);
//        System.out.println(state.l);

        ArrayDeque<Integer> node = minDistance2(word1, word2);
        System.out.println(node);


    }

    public State minDistance(String word1, String word2) {
        char[] s1 = word1.toCharArray();
        char[] s2 = word2.toCharArray();

        int n1 = s1.length;
        int n2 = s2.length;

        // 操作符：增：0；删：1；改：2；跳过：3

        // dp[i][j]：s1[0~i]到s2[0~j]的变化
        State[][] dp = new State[n1+1][n2+1];

        dp[0][0] = new State(0, new ArrayList<>());

        // 初始化dp，dp[0][i]=i, dp[i][0]=i, dp[0][0]
        for(int i=1; i<=n1; i++){
            ArrayList<Integer> cur = new ArrayList<>(dp[i-1][0].l);
            cur.add(1);
            dp[i][0] = new State(i, cur);
        }
        for(int i=1; i<=n2; i++){
            ArrayList<Integer> cur = new ArrayList<>(dp[0][i-1].l);
            cur.add(0);
            dp[0][i] = new State(i, cur);
        }

        for(int i=1; i<=n1; i++){

            for(int j=1; j<=n2; j++){

                if(s1[i-1]==s2[j-1]){
                    ArrayList<Integer> cur = new ArrayList<>(dp[i-1][j-1].l);
                    cur.add(3);
                    dp[i][j] = new State(dp[i-1][j-1].val, cur);
                }else{
                    int min = -1;
                    if(dp[i-1][j-1].val<dp[i-1][j].val && dp[i-1][j-1].val<dp[i][j-1].val){
                        min = dp[i-1][j-1].val;
                        ArrayList<Integer> cur = new ArrayList<>(dp[i-1][j-1].l);
                        cur.add(2);
                        dp[i][j] = new State(min+1, cur);
                        continue;
                    }
                    if(dp[i-1][j].val<dp[i-1][j-1].val && dp[i-1][j].val<dp[i][j-1].val){
                        min = dp[i-1][j].val;
                        ArrayList<Integer> cur = new ArrayList<>(dp[i-1][j].l);
                        cur.add(0);
                        dp[i][j] = new State(min+1, cur);
                        continue;
                    }

                    min = dp[i][j-1].val;
                    ArrayList<Integer> cur = new ArrayList<>(dp[i][j-1].l);
                    cur.add(1);
                    dp[i][j] = new State(min+1, cur);
                }

            }

        }

        System.out.println(Arrays.deepToString(dp));

        return dp[n1][n2];

    }

    public ArrayDeque<Integer> minDistance2(String word1, String word2) {
        char[] s1 = word1.toCharArray();
        char[] s2 = word2.toCharArray();

        int n1 = s1.length;
        int n2 = s2.length;

        // 操作符：
        // 增：0；
        // 删：1；
        // 改：2；
        // 跳过：3

        // dp[i][j]：s1[0~i]到s2[0~j]的变化
        Node[][] dp = new Node[n1+1][n2+1];

        dp[0][0] = new Node(0,0);

        // 初始化dp，dp[0][i]=i, dp[i][0]=i, dp[0][0]
        for(int i=1; i<=n1; i++){
            dp[i][0] = new Node(i, 1);
        }
        for(int i=1; i<=n2; i++){
            dp[0][i] = new Node(i, 0);
        }

        for(int i=1; i<=n1; i++){

            for(int j=1; j<=n2; j++){

                if(s1[i-1]==s2[j-1]){
                    dp[i][j] = new Node(dp[i-1][j-1].val, 3);
                }else{
                    int min = -1;
                    if(dp[i-1][j-1].val<dp[i-1][j].val && dp[i-1][j-1].val<dp[i][j-1].val){
                        min = dp[i-1][j-1].val;
                        dp[i][j] = new Node(min+1, 2);
                        continue;
                    }
                    if(dp[i-1][j].val<dp[i-1][j-1].val && dp[i-1][j].val<dp[i][j-1].val){
                        min = dp[i-1][j].val;
                        dp[i][j] = new Node(min+1, 1);
                        continue;
                    }

                    min = dp[i][j-1].val;
                    dp[i][j] = new Node(min+1, 0);
                }

            }

        }

        int i = n1;
        int j = n2;

        ArrayDeque<Integer> res = new ArrayDeque<>();

        while(i!=0 || j!=0){
            int val = dp[i][j].option;
            res.addFirst(val);
            switch (val){
                case 1:
                    i--;
                    break;
                case 0:
                    j--;
                default:
                    i--;
                    j--;
            }
        }
        System.out.println(dp[n1][n2].val);
        System.out.println(Arrays.deepToString(dp));

        return res;

    }

}

class State{

    int val;
    ArrayList<Integer> l;

    public State(int val, ArrayList<Integer> l){
        this.val = val;
        this.l = l;
    }

    @Override
    public String toString() {
        return val+"";
    }
}

class Node{

    int val;
    int option;

    public Node(int val, int option){
        this.val = val;
        this.option = option;
    }

    @Override
    public String toString() {
        return option+"";
    }
}

