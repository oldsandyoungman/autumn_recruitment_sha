package com.shasha.struct;

/**
 * @author ShaLuwei
 * @create 2022-08-10 10:20
 */
public class UF {


//    @Test
//    public void test(){
//
//        parent = new int[5];
//        parent[0] = 0;
//        parent[1] = 0;
//        parent[2] = 1;
//        parent[3] = 2;
//        parent[4] = 3;
//
//        System.out.println(find(4));
//
//    }

    int[] parent;
    int count;

    public UF(int n){
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        count = n;
    }

//    public int find(int i){
//        while(parent[i]!=i){
//            parent[i] = find(parent[i]);
//        }
//        return parent[i];
//    }


    public int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    public void union(int i, int j){
        int rooti = find(i);
        int rootj = find(j);

        if(rooti==rootj){
            return;
        }
        parent[rooti] = rootj;
        count--;
    }

    public boolean connected(int i, int j){
        int rooti = find(i);
        int rootj = find(j);

        return rooti == rootj;
    }

    public int getCount(){
        return count;
    }

}
