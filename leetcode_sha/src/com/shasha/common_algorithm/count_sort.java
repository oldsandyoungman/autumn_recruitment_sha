package com.shasha.common_algorithm;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author ShaLuwei
 * @create 2022-08-16 13:25
 */
public class count_sort {


    @Test
    public void test(){
        int[] nums = {1,5,2,4,3,4,5,4,2};
//        System.out.println(Arrays.toString(countingSort(nums)));
        System.out.println(Arrays.toString(sort(nums)));
    }


    public int[] sort(int[] nums){

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        int[] count = new int[max-min+1];

        for (int num : nums) {
            count[num-min]++;
        }

        for (int i = 1; i < count.length; i++) {
            count[i] += count[i-1];
        }

        int[] res = new int[nums.length];

        for (int i = nums.length - 1; i >= 0; i--) {
            int index = count[nums[i] - min] - 1;
            count[nums[i] - min]--;
            res[index] = nums[i];
        }

        return res;

    }





//    /**
//     * Gets the maximum and minimum values in the array
//     *
//     * @param arr
//     * @return
//     */
//    private static int[] getMinAndMax(int[] arr) {
//        int maxValue = arr[0];
//        int minValue = arr[0];
//        for (int i = 0; i < arr.length; i++) {
//            if (arr[i] > maxValue) {
//                maxValue = arr[i];
//            } else if (arr[i] < minValue) {
//                minValue = arr[i];
//            }
//        }
//        return new int[] { minValue, maxValue };
//    }
//
//    /**
//     * Counting Sort
//     *
//     * @param arr
//     * @return
//     */
//    public static int[] countingSort(int[] arr) {
//        if (arr.length < 2) {
//            return arr;
//        }
//        int[] extremum = getMinAndMax(arr);
//        int minValue = extremum[0];
//        int maxValue = extremum[1];
//        int[] countArr = new int[maxValue - minValue + 1];
//        int[] result = new int[arr.length];
//
//        for (int i = 0; i < arr.length; i++) {
//            countArr[arr[i] - minValue] += 1;
//        }
//        for (int i = 1; i < countArr.length; i++) {
//            countArr[i] += countArr[i - 1];
//        }
//        for (int i = arr.length - 1; i >= 0; i--) {
//            int idx = countArr[arr[i] - minValue] - 1;
//            result[idx] = arr[i];
//            countArr[arr[i] - minValue] -= 1;
//        }
//        return result;
//    }

}
