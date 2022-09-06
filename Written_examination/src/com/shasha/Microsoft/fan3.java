package com.shasha.Microsoft;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ShaLuwei
 * @create 2022-08-19 21:31
 */
public class fan3 {


    @Test
    public void test(){
        int[] A = {0,1,1};
        int[] B = {1,2,3};

//        int[] A = {1,1,1,9,9,9,9,7,8};
//        int[] B = {2,0,3,1,6,5,4,0,0};

        System.out.println(getMin(A, B));
    }

    public int getMin(int[] A, int[] B){

        int nn = A.length;
        int max = 0;
        for(int num : A){
            max = Math.max(num, max);
        }
        for(int num : B){
            max = Math.max(num, max);
        }
        int n = max;
        List<Integer>[] graph = new ArrayList[n+1];

        for(int i=0; i<=n; i++){
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < nn; i++) {
            int from = A[i];
            int to = B[i];
            graph[from].add(to);
            graph[to].add(from);
        }

        res = 0;
        visited = new boolean[n+1];

        visited[0] = true;

        for (int start : graph[0]) {
            dfs(graph, start);
        }

        return res;

    }

    int res;
    boolean[] visited;

    public int dfs(List<Integer>[] graph, int root){
        boolean flag = true;
        for (int nxt : graph[root]) {
            flag &= visited[nxt];
        }
        if(flag){
            System.out.println("第"+root+"节点的子树的个数：1");
            res += 1;
            return 1;
        }

        visited[root] = true;

        int sum = 1;

        for (int nxt : graph[root]) {
            if(visited[nxt]){
                continue;
            }
//            int tmp = dfs(graph, nxt);
//            sum += tmp;
            sum += dfs(graph, nxt);
        }

        res += 1+sum/5;
        System.out.println("第"+root+"节点的子树的个数："+sum);
        return sum;

    }


}
