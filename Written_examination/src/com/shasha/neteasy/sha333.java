package com.shasha.neteasy;

import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @author ShaLuwei
 * @create 2022-09-04 15:52
 */

/*
5 3 5
4 3 11 2 1

 */

public class sha333 {

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();
        int x = sc.nextInt();

//         int[] nums = new int[n+1];

//         ArrayList<Integer> a = new ArrayList<>();
//         for(int i=0; i<n; i++){
//             a.add(sc.nextInt());
//         }

//         int res = minMax(a, k, x);

//         System.out.println(res);


        PriorityQueue<Integer> q = new PriorityQueue<>((o1, o2) -> {
            return Integer.compare(o2, o1);
        });

        for(int i=0; i<n; i++){
            q.offer(sc.nextInt());
        }

        if(n==1){
            int res = q.poll() - k*x;
            System.out.println(res);
            return;
        }

        int max = q.poll();
        int max2 = 0;

        while(k>0){

            max2 = q.poll();

            int count = 1+(max - max2)/x;
            k -= count;
            if(k<0){
                int res = max - k*x;
                System.out.println(res);
                return;
            }

            max -= x*count;

            q.offer(max);
            max = max2;

        }

        System.out.println(max);

    }

}
