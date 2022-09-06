package com.shasha.Microsoft;

import org.junit.Test;

import java.util.*;

/**
 * @author ShaLuwei
 * @create 2022-08-06 13:16
 */
public class sha4 {

    /**
     * 要了解匈牙利算法必须先理解下面的概念：
     *     匹配：在图论中，一个「匹配」是一个边的集合，其中任意两条边都没有公共顶点。
     *     最大匹配：一个图所有匹配中，所含匹配边数最多的匹配，称为这个图的最大匹配。
     *
     * 下面是一些补充概念：
     *     完美匹配：如果一个图的某个匹配中，所有的顶点都是匹配点，那么它就是一个完美匹配。
     *     交替路：从一个未匹配点出发，依次经过非匹配边、匹配边、非匹配边…形成的路径叫交替路。
     *     增广路：从一个未匹配点出发，走交替路，如果途径另一个未匹配点（出发的点不算），则这条交替 路称为增广路（agumenting path）。
     *
     * 匈牙利算法思路：
     *     每个点从另一个集合里挑对象，没冲突的话就先安排上，要是冲突了就用增广路径重新匹配。重复上述思路，
     *     直到所有的点都找到对象，或者找不到对象也找不到增广路。
     */

    @Test
    public void test(){
//        int[] A = {1,1,3};
//        int[] B = {2,2,1};
//        int S = 3;
//
//        int[] A = {3,2,3,1};
//        int[] B = {1,3,1,2};
//        int S = 3;

//        int[] A = {2,5,6,5};
//        int[] B = {5,4,2,2};
//        int S = 8;

        int[] A = {1,2,1,6,8,7,8};
        int[] B = {2,3,4,7,7,8,7};
        int S = 10;

        System.out.println(solution(A,B,S));
    }


    Map<Integer, Set<Integer>> graph;
    int[] match;
    boolean[] st;

    public boolean solution(int[] A, int[] B, int S) {
        int n = A.length;

        graph = new HashMap<>(S);
        match = new int[S];
        st = new boolean[S];

        if (n>S){
            return false;
        }

        for(int i = 0; i < n; i++){
            graph.putIfAbsent(i, new HashSet<>());
            graph.get(i).add(A[i]-1);
            graph.get(i).add(B[i]-1);
        }
        int cnt = 0;
        for(int i = 0; i < S; i++){
            Arrays.fill(st, false);
            if(find(i)) cnt++;
        }

//        System.out.println(cnt);

        System.out.println(Arrays.toString(match));

        return cnt==n;

    }

    public boolean find(int left){
        if(graph.get(left) == null)    return false;
        for(Integer right: graph.get(left)){
            if(st[right]) continue;
            st[right] = true;
            if(match[right] == 0 || find(match[right])){
                match[right] = left;
                return true;
            }
        }
        return false;
    }


}