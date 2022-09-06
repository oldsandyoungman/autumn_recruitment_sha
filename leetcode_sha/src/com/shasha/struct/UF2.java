package com.shasha.struct;

import java.util.Arrays;

/**
 * @author ShaLuwei
 * @create 2022-08-10 21:12
 */
public class UF2 {

    int[] parent;
    int[] sz;
    int count;

    public UF2(int n){

        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        sz = new int[n];
        Arrays.fill(sz, 1);
        count = n;

    }

    public int find(int i){
        if(parent[i]!=i){
            parent[i] = find(parent[i]);
        }
        return parent[i];
    }

    public void union(int i, int j){
        int rooti = find(i);
        int rootj = find(j);
        if(rooti==rootj){
            return;
        }
        if(sz[rooti]>sz[rootj]){
            parent[rootj] = rooti;
            sz[rooti] += sz[rootj];
        }else{
            parent[rooti] = rootj;
            sz[rootj] += sz[rooti];
        }
        count--;
    }

    public boolean connected(int i, int j){
        int rooti = find(i);
        int rootj = find(j);
        return rooti==rootj;
    }

    public int getCount(){
        return count;
    }


}
