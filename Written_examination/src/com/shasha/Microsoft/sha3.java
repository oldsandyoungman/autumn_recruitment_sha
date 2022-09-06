package com.shasha.Microsoft;

import org.junit.Test;

/**
 * @author ShaLuwei
 * @create 2022-08-06 08:59
 */
public class sha3 {

    @Test
    public void test(){
//        int[] A = {1,1,3};
//        int[] B = {2,2,1};
//        int S = 3;

//        int[] A = {3,2,3,1};
//        int[] B = {1,3,1,2};
//        int S = 3;

        int[] A = {2,5,6,5};
        int[] B = {5,4,2,2};
        int S = 8;

//        int[] A = {1,2,1,6,8,7,8};
//        int[] B = {2,3,4,7,7,8,7};
//        int S = 10;

        System.out.println(solution(A,B,S));
    }



    public boolean solution(int[] A, int[] B, int S) {

        int n = A.length;

        if(n>S){
            return false;
        }

        int[][] graph = new int[S][S];

        for (int i = 0; i < n; i++) {
            int choice1 = A[i] - 1;
            int choice2 = B[i] - 1;
            graph[i][choice1] = 1;
            graph[i][choice2] = 1;
//            graph[choice1][i] = 1;
//            graph[choice2][i] = 1;
        }

        Hungary h = new Hungary(graph);

        int sss = h.search();

        System.out.println(sss);

        return sss==n;

    }

//    public boolean solution(int[] A, int[] B, int S) {
//        // write your code in Java 8 (Java SE 8)
//
//        int n = A.length;
//        if(n>S){
//            return false;
//        }
//        res = false;
//        boolean[] slots = new boolean[S+1];
//        backtrack(A, B, 0, slots);
//        return res;
//    }
//
//    boolean res;
//
//    public void backtrack(int[] A, int[] B, int start, boolean[] slots){
//        if(res){
//            return;
//        }
//        int n = A.length;
//        if(start==n){
//            res = true;
//            return;
//        }
//
//        int choice1 = A[start];
//        int choice2 = B[start];
//
//        // 放A的位置
//        if(!slots[choice1]){
//            slots[choice1] = true;
//            backtrack(A, B, start+1, slots);
//            if(res){
//                return;
//            }
//            slots[choice1] = false;
//        }
//
//        // 放B的位置
//        if(!slots[choice2]){
//            slots[choice2] = true;
//            backtrack(A, B, start+1, slots);
//            if(res){
//                return;
//            }
//            slots[choice1] = false;
//        }
//
//
//    }

}


class Hungary {
    int[][] graph;  //需要计算的图的邻接矩阵，注意每个顶点和它自己的连接被设置成了0。另外graph需要是n*n的矩阵
    int[] match;    //记录每个顶点的匹配顶点。假如match[0]=1，就是说顶点0和顶点1已经匹配
    int len;        //图的顶点的个数
    boolean[] used; //在从每个顶点搜索其增广路径的循环中，记录每个顶点是否已经被访问过

    public Hungary(int[][] graph) {
        this.graph = graph;
        len = graph.length;
        used = new boolean[len];

        match = new int[len];
        for (int i = 0; i < len; i++) {
            match[i] = -1;
            used[i] = false;
        }
    }

    //寻找顶点x的增广路径。如果能够寻找到则返回true，否则返回false。
    //匈牙利算法一个重要的定理：如果从一个顶点A出发，没有找到增广路径，那么无论再从别的点出发找到多少增广路径来改变现在的匹配，从A出发都永远找不到增广路径
    boolean findAugmentPath(int x) {
        for (int i = 0; i < len; i++) {
            if (graph[x][i] == 1) { //顶点x和顶点i之间有连接。需要注意的一点是我们在输入需要计算的图的邻接矩阵的时候把对角线上的元素设置为0
                if (!used[i]) {     //如果顶点i还未访问
                    used[i] = true;
                    //如果顶点i还未匹配，或者与顶点i匹配的那个顶点可以换个顶点匹配（也就是说可以把顶点i“让给”当前顶点x），则把顶点x和顶点i为对方的匹配顶点
                    //由于上一步已经将顶点i设置成used，所以findAugmentPath(match[i])不会再考虑顶点i了
                    if (match[i] == -1 || findAugmentPath(match[i])) {
                        match[x] = i;
                        match[i] = x;
                        System.out.println(x + "------>" + i);
                        return true;
                    }
                }
            }
        }
        return false;
    }

    int search() {
        int res = 0;
        //对于每个顶点都循环处理
        for (int i = 0; i < len; i++) {
            if (match[i] == -1) {   //如果当前顶点已经有匹配的顶点了，就略过此顶点
                clearUsed();    //新的一轮搜索，把used数组设置成false
                System.out.println("开始匹配顶点" + i);
                if(findAugmentPath(i)){
                    res++;
                }
            }
        }



        System.out.println();
        System.out.println();
        System.out.println();
//
        for (int i = 0; i < len; i++) {
            System.out.println(i + "------>" + match[i]);
        }

        return res;
    }

    void clearUsed() {
        for (int i = 0; i < len; i++) {
            used[i] = false;
        }
    }

    public static void main(String[] args) {
        int[][] graph = {{0, 0, 0, 0, 1, 0, 1, 0},
                {0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 0, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 1, 1},
                {1, 1, 1, 0, 0, 0, 0, 0},
                {0, 0, 1, 0, 0, 0, 0, 0},
                {1, 0, 0, 1, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 0}};
        new Hungary(graph).search();
    }
}
