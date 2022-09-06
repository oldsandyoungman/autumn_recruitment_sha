package com.shasha.neteasy;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author ShaLuwei
 * @create 2022-09-04 15:44
 */
public class sha33 {

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();
        int x = sc.nextInt();

        int[] nums = new int[n+1];

        ArrayList<Integer> a = new ArrayList<>();
        for(int i=0; i<n; i++){
            a.add(sc.nextInt());
        }

        int res = minMax(a, k, x);

        System.out.println(res);


//         PriorityQueue<Integer> q = new PriorityQueue<>((o1, o2) -> {
//             return Integer.compare(o2, o1);
//         });

//         for(int i=0; i<n; i++){
//             q.offer(sc.nextInt());
//         }

//         if(n==1){
//             int res = q.poll() - k*x;
//             System.out.println(res);
//             return;
//         }

//         int max = q.poll();
//         int max2 = 0;
//         for(int i=0; i<k; ){
//             max2 = q.poll();
//             max -= x;
//             i++;
//             while(max>max2){
//                 max -= x;
//                 i++;
//                 if(i>=k){
//                     break;
//                 }
//             }
//             q.offer(max);
//         }

//         System.out.println(Math.max(max, max2));

    }

    public static int minMax(ArrayList<Integer> a, int k, int x){

        ArrayList<Integer> list = new ArrayList<>();
        list.add(0);
        list.addAll(a);

        for(int i=list.size()/2; i>0; i--){
            heapify(list, i, list.size());
        }

        for(int j=k; j>0; j--){
            list.set(1, list.get(1)-x);
            heapify(list, 1, list.size());
        }

        return list.get(1);
    }


    public static void heapify(ArrayList<Integer> list, int k, int len){
        list.set(0, list.get(k));
        for(int i=2*k; i<len; i*=2){
            if(i+1<len && list.get(i)<list.get(i+1)){
                i++;
            }
            if(list.get(0)>=list.get(i)){
                break;
            }else{
                list.set(k, list.get(i));
                k = i;
            }
        }

        list.set(k, list.get(0));
    }


}
