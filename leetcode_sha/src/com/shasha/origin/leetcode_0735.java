package com.shasha.origin;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author ShaLuwei
 * @create 2022-07-31 21:30
 */
public class leetcode_0735 {

    public static void main(String[] args) {

    }

    @Test
    public void test(){
        int[] nums = {5,10,-5};
        System.out.println(Arrays.toString(asteroidCollision(nums)));

//        ArrayList<Integer> l = new ArrayList<>();
//        l.add(1);
//        l.add(2);
//        l.

    }

    public int[] asteroidCollision(int[] asteroids) {
        // 栈里存的一定是往右的
        ArrayDeque<Integer> l = new ArrayDeque<>();
        ArrayList<Integer> res = new ArrayList<>();
        for(int cur : asteroids){
            if(cur>0){
                l.addLast(cur);
                continue;
            }

            boolean alive = true;
            while(!l.isEmpty()){
                if( l.getLast() == -cur){
                    alive = false;
                    l.removeLast();
                    break;
                }else if(l.getLast() > -cur){
                    alive = false;
                    break;
                }else{
                    l.removeLast();
                }
            }

            if(alive){
                res.add(cur);
            }

        }

        while(!l.isEmpty()){
            res.add(l.removeFirst());
        }

        int n = res.size();
        int[] result = new int[n];
        for(int i=0; i<n; i++){
            result[i] = res.get(i);
        }

        return result;

    }

//    public int[] asteroidCollision(int[] asteroids) {
//
//        res = new ArrayDeque<>();
//
//        ArrayDeque<Integer> l = new ArrayDeque<>();
//        for(int num : asteroids){
//            l.addLast(num);
//        }
//
//        dfs(l);
//
//        while(!l.isEmpty()){
//            res.addFirst(l.removeLast());
//        }
//
//        int n = res.size();
//
//        int[] result = new int[n];
//
//        for(int i=0; i<n; i++){
//            result[i] = res.removeFirst();
//        }
//
//        return result;
//
//    }
//
//    ArrayDeque<Integer> res;
//
//    public void dfs(ArrayDeque<Integer> l){
//        if(l.size()==1){
//            int cur = l.removeLast();
//            if(cur>0){
//                res.addFirst(cur);
//            }else{
//                l.addFirst(cur);
//            }
//            return;
//        }
//
//        int cur = l.removeFirst();
//
//        dfs(l);
//
//        if(cur<0){
//            l.addFirst(cur);
//            return;
//        }
//
//        while(!l.isEmpty()){
//            int tmp = l.removeFirst();
//            if(Math.abs(tmp)>Math.abs(cur)){
//                l.addFirst(tmp);
//                return;
//            }
//            if(Math.abs(tmp)==Math.abs(cur)){
//                return;
//            }
//        }
//
//        res.addFirst(cur);
//
//    }

}
