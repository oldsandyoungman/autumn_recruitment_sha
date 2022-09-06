package com.shasha.common_algorithm;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/**
 * @author ShaLuwei
 * @create 2022-08-06 14:50
 */
public class Hungarian {

    public static void main(String[] args) {
        HashMap<Integer, HashSet<Integer>> memo = new HashMap<>();
//        int[] A = {1,1,3};
//        int[] B = {2,2,1};
//        int S = 3;

//        int[] A = {3,2,3,1};
//        int[] B = {1,3,1,2};
//        int S = 3;

//        int[] A = {2,5,6,5};
//        int[] B = {5,4,2,2};
//        int S = 8;

        int[] A = {1,2,1,6,8,7,8};
        int[] B = {2,3,4,7,7,8,7};
        int S = 10;

        int nn = A.length;
        for (int i = 0; i < nn; i++) {
            memo.putIfAbsent(i, new HashSet<>());
            memo.get(i).add(A[i]-1);
            memo.get(i).add(B[i]-1);
        }
        int m = A.length;
        int n = S;


        Hungarian2 h = new Hungarian2(memo, m, n);

        System.out.println(h.maxMatch()==m);
    }


    int m;
    int n;
    HashMap<Integer, HashSet<Integer>> memo;
    int[] related_boys;
    boolean[] girl_occupy;

    public Hungarian(HashMap<Integer, HashSet<Integer>> memo, int m, int n){
        this.memo = memo;
        this.m = m;
        this.n = n;
        memo = new HashMap<>();
        related_boys = new int[n];
        girl_occupy = new boolean[n];
    }

    public int maxMatch(){

        int res = 0;

        Arrays.fill(related_boys, -1);

        for (int i = 0; i < m; i++) {
            Arrays.fill(girl_occupy, false);
            if(find(i)){
                res++;
            }

        }

        return res;

    }

    public boolean find(int boy){

        for(int j : memo.get(boy)){
            if(!girl_occupy[j]){
                girl_occupy[j] = true;
                if(related_boys[j]!=-1 || find(related_boys[j])){
                    related_boys[j] = boy;
                    return true;
                }
            }
        }

        return false;

    }

}
