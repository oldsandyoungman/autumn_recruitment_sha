package com.shasha.Microsoft;

import org.junit.Test;

import java.util.PriorityQueue;

/**
 * @author ShaLuwei
 * @create 2022-08-13 11:44
 */
public class sha21 {

    @Test
    public void test(){
//        int[] A = {5,19,8,1};
//        int[] A = {10, 10};
        int[] A = {3,0,5};
        System.out.println(solution(A));
    }

    public int solution(int[] A) {
        // write your code in Java 8 (Java SE 8)
        PriorityQueue<Double> q = new PriorityQueue<>((o1, o2) -> Double.compare(o2, o1));
        double sum = 0;
        for(int c : A){
            q.offer((double) c);
            sum += c;
        }
        double target = sum/2;
        int res = 0;
        while(sum>target){
            double cur = q.poll();
            double tmp = cur/2;
            sum -= tmp;
            res++;
            q.offer(tmp);
        }

        return res;

    }

}
