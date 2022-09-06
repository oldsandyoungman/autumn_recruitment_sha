package com.shasha.origin;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ShaLuwei
 * @create 2022-08-09 09:47
 */
public class leetcode_0210 {

    @Test
    public void test(){
        int n = 2;
        int[][] pre = new int[][]{{1,0}};
        System.out.println(Arrays.toString(findOrder(n, pre)));

        List<Integer> l1 = new ArrayList<>();
        List<String> l2 = new ArrayList<>();
        System.out.println(l1.getClass().equals(l2.getClass()));

    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = new ArrayList[numCourses];
        for(int i=0; i<numCourses; i++){
            graph[i] = new ArrayList<>();
        }
        for(int[] tmp : prerequisites){
            int from = tmp[0];
            int to = tmp[1];
            graph[from].add(to);
        }

        visited = new boolean[numCourses];
        onPath = new boolean[numCourses];
        flag = true;
        l = new ArrayList<>();

        for(int i=0; i<numCourses; i++){
            dfs(graph, i);
        }

        if(!flag){
            return new int[0];
        }else{

            int[] res = new int[numCourses];
            for(int i=0; i<numCourses; i++){
                res[i] = l.get(numCourses-i-1);
            }

            return res;

        }

    }

    boolean[] visited;
    boolean[] onPath;
    boolean flag;
    ArrayList<Integer> l;

    // 以该节点为开始的所有路径，会不会成环
    public void dfs(List<Integer>[] graph, int cur){
        if(!flag){
            return;
        }
        if(onPath[cur]){
            flag = false;
            return;
        }

        if(visited[cur]){
            return;
        }

        onPath[cur] = true;
        visited[cur] = true;

        for(int nxt : graph[cur]){
            dfs(graph, nxt);
        }

        l.add(cur);

        onPath[cur] = false;
    }
}
