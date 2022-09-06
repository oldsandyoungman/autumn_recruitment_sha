package com.shasha.origin;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Arrays;

/**
 * @author ShaLuwei
 * @create 2022-08-26 10:42
 */
public class leetcode_0321 {


    @Test
    public void test(){
//        int[] nums1 = {3,4,6,5};
//        int[] nums2 = {9,1,2,5,8,3};
//        int k = 5;


//        int[] nums1 = {6,7};
//        int[] nums2 = {6,0,4};
//        int k = 5;

        int[] nums1 = {2,5,6,4,4,0};
        int[] nums2 = {7,3,8,0,6,5,7,6,2};
        int k = 15;


        System.out.println(Arrays.toString(maxNumber(nums1, nums2, k)));
    }


    public int[] maxNumber(int[] nums1, int[] nums2, int k) {

        int m = nums1.length;
        int n = nums2.length;

        int[] res = null;
        int sum = 0;

        for(int i=0; i<=k; i++){
            if(i>m || k-i>n || k-i<0){
                continue;
            }
            int[] max1 = getMax(nums1, i);
            int[] max2 = getMax(nums2, k-i);

            State0321 cur = getMerge(max1, max2);
            if(cur.sum>sum){
                res = cur.res;
                sum = cur.sum;
            }

        }

        return res;

    }

    public State0321 getMerge(int[] nums1, int[] nums2){
        int m = nums1.length;
        int n = nums2.length;

        int[] res = new int[m+n];
        int sum = 0;

        int i = 0;
        int j = 0;
        int k = 0;

        while(i<m && j<n){
            int cmp = compare(nums1, i, nums2, j);
            if(cmp>0){
                res[k] = nums1[i];
                sum = 10*sum + nums1[i];
                i++;
                k++;
            }else{
                res[k] = nums2[j];
                sum = 10*sum + nums2[j];
                j++;
                k++;
            }
        }

        if(i==m){
            while(j<n){
                res[k] = nums2[j];
                sum = 10*sum + nums2[j];
                j++;
                k++;
            }
        }else{
            while(i<m){
                res[k] = nums1[i];
                sum = 10*sum + nums1[i];
                i++;
                k++;
            }
        }

        return new State0321(res, sum);


    }

    public int compare(int[] nums1, int index1, int[] nums2, int index2){
        int m = nums1.length;
        int n = nums2.length;
        while(index1<m && index2<n){
            if(nums1[index1]!=nums2[index2]){
                return Integer.compare(nums1[index1], nums2[index2]);
            }
            index1++;
            index2++;
        }
        return Integer.compare(m-index1, n-index2);
    }


    public int[] getMax(int[] nums, int k){
        int n = nums.length;
        int target_len = k;
        k = n-k;
        ArrayDeque<Integer> q = new ArrayDeque<>();

        for(int i=0; i<n; i++){
            while(k>0 && !q.isEmpty() && q.getLast()<nums[i]){
                q.removeLast();
                k--;
            }
            q.addLast(nums[i]);
        }

        int[] res = new int[target_len];
        int i=0;
        while(target_len>i){
            res[i] = q.removeFirst();
            i++;
        }

        return res;

    }

}

class State0321{

    int[] res;
    int sum;

    public State0321(int[] res, int sum){
        this.res = res;
        this.sum = sum;
    }

}