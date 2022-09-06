package com.shasha.Meituan;

import java.util.ArrayDeque;
import java.util.Scanner;

/**
 * @author ShaLuwei
 * @create 2022-08-13 16:53
 */
public class sha3 {

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] nums = new int[n];
        for(int i=0; i<n; i++){
            nums[i] = sc.nextInt();
        }

        if(n==1){
            System.out.println(nums[0]);
            return;
        }
        if(n==2){
            System.out.println(nums[0] + " " + nums[1]);
            return;
        }


        ArrayDeque<Integer> q = new ArrayDeque<>();
        q.addLast(nums[n-2]);
        q.addLast(nums[n-1]);

        int index = n-3;
        while(index>=0){
            q.addFirst(nums[index]);
            q.addFirst(q.removeLast());
            q.addFirst(q.removeLast());
            index--;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(q.removeFirst());
        for(int i=0; i<n-1; i++){
            sb.append(" ").append(q.removeFirst());
        }

        System.out.println(sb.toString());

    }
}
