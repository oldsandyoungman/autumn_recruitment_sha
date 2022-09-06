package com.shasha.origin;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author ShaLuwei
 * @create 2022-08-20 15:56
 */
public class leetcode_0514 {

    @Test
    public void test(){

        String s1 = "ababcab";
        String s2 = "acbaacba";

        System.out.println(findRotateSteps(s1, s2));

    }


    public int findRotateSteps(String ring, String key) {

        char[] ss = ring.toCharArray();
        char[] tt = key.toCharArray();

        int n = ss.length;
        // int m = tt.length;

        memo = new int[n][3];
        for(int i=0; i<n; i++){
            Arrays.fill(memo[i], -1);
        }

        HashMap<Character, List<Integer>> m = new HashMap<>();

        for(int i=0; i<n; i++){
            m.putIfAbsent(ss[i], new ArrayList<>());
            m.get(ss[i]).add(i);
        }

        int result = tt.length + dfs(ss, tt, 0, 0, m);

        System.out.println(Arrays.deepToString(memo));

        return result;



    }

    int[][] memo;

    public int dfs(char[] ss, char[] tt, int s_start, int t_start, HashMap<Character, List<Integer>> m){
        if(t_start==tt.length){
            return 0;
        }

        char target = tt[t_start];

        if(memo[s_start][target-'a']!=-1){
            return memo[s_start][target-'a'];
        }

        int res = Integer.MAX_VALUE;
        for(int index : m.get(target)){
            int delta = Math.abs(index-s_start);
            int reverse_delta = ss.length - delta;
            int res_delta = Math.min(delta, reverse_delta);
            int cur_res = res_delta + dfs(ss, tt, index, t_start+1, m);
            res = Math.min(res, cur_res);
        }

        memo[s_start][target-'a'] = res;

        return res;




    }

}