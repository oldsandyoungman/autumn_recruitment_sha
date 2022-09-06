package com.shasha.neteasy;

import java.util.Scanner;

/**
 * @author ShaLuwei
 * @create 2022-09-04 15:39
 */
public class sha3 {

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();
        int x = sc.nextInt();

        int[] nums = new int[n+1];

        nums[0] = 0;
        for(int i=1; i<=n; i++){
//             list.add(sc.nextInt());
            nums[i] = sc.nextInt();
        }

        for(int i=(n+1)/2; i>0; i--){
            heapify(nums, i, n+1);
        }

        for(int j=k; j>0; j--){
            nums[1] -= x;
//             list.set(1, list.get(1)-x);
            heapify(nums, 1, n+1);
        }

        System.out.println(nums[1]);



//         ArrayList<Integer> list = new ArrayList<>();
//         list.add(0);
//         for(int i=0; i<n; i++){
//             list.add(sc.nextInt());
//         }

//         for(int i=list.size()/2; i>0; i--){
//             heapify(list, i, list.size());
//         }

//         for(int j=k; j>0; j--){
//             list.set(1, list.get(1)-x);
//             heapify(list, 1, list.size());
//         }

//         System.out.println(list.get(1));




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



    public static void heapify(int[] nums, int k, int len){
        nums[0] = nums[k];
        for(int i=2*k; i<len; i*=2){
            if(i+1<len && nums[i]<nums[i+1]){
                i++;
            }
            if(nums[0]>nums[i]){
                break;
            }else{
                nums[k] = nums[i];
                k = i;
            }
        }

        nums[k] = nums[0];
    }
}
