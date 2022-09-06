package com.shasha.origin;

import com.shasha.struct.Prim;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ShaLuwei
 * @create 2022-08-11 23:57
 */
public class leetcode_1584 {

    public static void main(String[] args) {

        int[][] nums = new int[][]{{0,0},{1,1},{1,0},{-1,1}};
        System.out.println(minCostConnectPoints(nums));


    }

    public static int minCostConnectPoints(int[][] points) {
        int n = points.length;
        List<int[]>[] graph = new ArrayList[n];
        for(int i=0; i<n; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                int dx = Math.abs(points[i][0] - points[j][0]);
                int dy = Math.abs(points[i][1] - points[j][1]);
                int dis = dx + dy;
                graph[i].add(new int[]{i, j, dis});
                graph[j].add(new int[]{j, i, dis});
            }
        }

        Prim p = new Prim(graph);

        if(p.isFull()){
            return p.getSum();
        }

        return -1;

    }

}
