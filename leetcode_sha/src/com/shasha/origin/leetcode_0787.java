package com.shasha.origin;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ShaLuwei
 * @create 2022-08-21 23:06
 */
public class leetcode_0787 {
    @Test
    public void test(){
        int n = 3;
        int[][] edges = {{0,1,100},{1,2,100},{0,2,500}};
        int src = 0, dst = 2, k = 1;
        System.out.println(findCheapestPrice(n,edges,src,dst,k));
    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        List<int[]>[] graph = new ArrayList[n];

        for(int i=0; i<n; i++){
            graph[i] = new ArrayList<>();
        }

        for(int[] tmp : flights){
            int from = tmp[0];
            int to = tmp[1];
            int cost = tmp[2];
            graph[from].add(new int[]{to, cost});
        }
        k++;
        memo = new int[n][k+1];
        res = Integer.MAX_VALUE;


        return dfs(graph, src, dst, k);

    }

    int[][] memo;

    int res;

    public int dfs(List<int[]>[] graph, int cur, int dst, int k){
        if(k<0){
            return -1;
        }
        if(cur==dst){
            return 0;
        }
        if(memo[cur][k]!=0){
            return memo[cur][k];
        }

        int cur_res = Integer.MAX_VALUE;

        for(int[] info : graph[cur]){
            int nxt = info[0];
            int nxt2end_cost = dfs(graph, nxt, dst, k-1);
            if(nxt2end_cost==-1){
                continue;
            }
            cur_res = Math.min(cur_res, nxt2end_cost + info[1]);
        }
        cur_res = cur_res==Integer.MAX_VALUE?-1:cur_res;

        memo[cur][k] = cur_res;

        return cur_res;

    }
}
