package com.shasha.struct;

import java.util.List;
import java.util.PriorityQueue;

/**
 * @author ShaLuwei
 * @create 2022-08-11 20:46
 */
public class Prim {

    List<int[]>[] graph;

    PriorityQueue<int[]> q;

    boolean[] visited;

    int count;

    int sum;

    public Prim(List<int[]>[] graph){
        int n = graph.length;
        this.graph = graph;
        q = new PriorityQueue<>((o1, o2) -> Integer.compare(o1[2], o2[2]));
        visited = new boolean[n];
        count = 0;
        sum = 0;

        cut(0);
        count++;
        visited[0] = true;

        while (!q.isEmpty()){

            int[] cur = q.poll();
            int nxt = cur[1];

            if(!visited[nxt]){
                count++;
                visited[nxt] = true;
                sum += cur[2];
                cut(nxt);

            }

        }

    }

    public void cut(int i){

        for (int[] ints : graph[i]) {
            int to = ints[1];
            if(!visited[to]){
                q.add(ints);
            }
        }

    }

    public int getSum(){
        return sum;
    }

    public boolean isFull(){
        return count==graph.length;
    }



}
