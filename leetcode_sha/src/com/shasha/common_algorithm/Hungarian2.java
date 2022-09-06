package com.shasha.common_algorithm;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/**
 * @author ShaLuwei
 * @create 2022-08-06 14:50
 */
public class Hungarian2 {

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
    int[] related_boy;
    boolean[] girl_occupy;
    HashMap<Integer, HashSet<Integer>> memo;

    public Hungarian2(HashMap<Integer, HashSet<Integer>> memo, int m, int n){
        this.m = m;
        this.n = n;
        this.memo = memo;
        related_boy = new int[n];
        girl_occupy = new boolean[n];
    }

    public int maxMatch(){
        Arrays.fill(related_boy, -1);
        int sum = 0;
        for (int i = 0; i < m; i++) {
            Arrays.fill(girl_occupy, false);
            if (find(i)){
                sum++;
            }
        }
        return sum;
    }

    public boolean find(int boy){

        for (int girl : memo.get(boy)) {
            if(!girl_occupy[girl]) {
                girl_occupy[girl] = true;
                if(related_boy[girl]==-1 || find(related_boy[girl])){
                    related_boy[girl] = boy;
                    return true;
                }
            }
        }

        return false;

    }

}
