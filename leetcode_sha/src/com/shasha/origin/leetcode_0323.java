package com.shasha.origin;

import com.shasha.struct.UF;
import org.junit.Test;

/**
 * @author ShaLuwei
 * @create 2022-08-10 11:23
 */
public class leetcode_0323 {



    /*
    给你输入一个包含 n 个节点的图，用一个整数 n 和一个数组 edges 表示，
    其中 edges[i] = [ai, bi] 表示图中节点 ai 和 bi 之间有一条边。
    请你计算这幅图的连通分量个数。

     */

    @Test
    public void test(){



    }


    public int countComponents(int n, int[][] edges){
        UF uf = new UF(n);
        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            uf.union(from, to);
        }
        return uf.getCount();
    }

}


