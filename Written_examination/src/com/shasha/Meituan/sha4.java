package com.shasha.Meituan;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/**
 * @author ShaLuwei
 * @create 2022-08-13 17:04
 */
public class sha4 {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] nums = new int[n];

        HashMap<Integer, List<Integer>> m = new HashMap<>();

        for(int i=0; i<n; i++){
            int cur = sc.nextInt();
            nums[i] = cur;
            m.putIfAbsent(cur, new ArrayList<>());
            m.get(cur).add(i);
        }

        long res = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {

                int k = 3*nums[j] - nums[i];

                if(m.containsKey(k)){
                    continue;
                }

                List<Integer> l = m.get(k);

                int left = 0;
                int right = l.size()-1;

                while(left<=right){
                    int mid = left + (right-left)/2;
                    if(l.get(mid)>k){
                        right = mid - 1;
                    }else{
                        left = mid + 1;
                    }
                }
                if(left==l.size()){
                    continue;
                }
                res += l.size()-left;
            }
        }
        System.out.println(res);

    }
}
