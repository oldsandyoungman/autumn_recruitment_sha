package com.shasha.shunfeng;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * 写的思路有点问题，之后再改
 * 应该是：例如 0，-1，-2的树，记为nums[] =
 * 算出count[] = {2,2,1}
 * 然后根据最小的负数是-1，全体加
 *
 * @author ShaLuwei
 * @create 2022-08-31 17:52
 */
public class ma2 {

    public static void main(String[] args) {

        int n = 3;
        int[] memo = new int[]{1, 1};
        nums = new int[]{1, -1, 1};
        graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < n-1; i++) {
            graph[i+1].add(memo[i]-1);
        }

        count = new int[n];
        List<Integer> path = new ArrayList<>();
        path.add(0);
        dfs(0, path);

        int res = 0;

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            min = Math.min(min, nums[i]);
        }

        while(min<0){
            for (int i = 0; i < n; i++) {
                if(count[i]>0){
                    count[i]--;
                    nums[i] -= min;
                }
            }

            res += -min;

            min = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                min = Math.min(min, nums[i]);
            }
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            max = Math.min(max, nums[i]);
        }

        res += max;


        System.out.println(res);




    }

    static int[] count;
    static List<Integer>[] graph;
    static int[] nums;

    public static void dfs(int cur, List<Integer> path){
        if(graph[cur].isEmpty()){
            return;
        }
        if (nums[cur]<0){
            for (int node : path) {
                count[node]++;
            }
        }
        path.add(cur);
        for (int nxt : graph[cur]) {
            dfs(nxt, path);
        }
        path.remove(path.size()-1);

    }


}
