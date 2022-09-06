package com.shasha.common_algorithm;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author ShaLuwei
 * @create 2022-08-16 19:05
 */
public class heap_sort {

    @Test
    public void test(){
        int[] nums = new int[]{1,5,2,7,8};
        sort(nums);
//        heapSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    private int heaplen;

    public void sort(int[] nums){
        int n = nums.length;
        heaplen = n;
        build(nums);
        for (int i = n-1; i > 0; i--) {

            swap(nums, 0, i);
            heaplen--;
            heapify(nums, 0);

        }

    }

    private void build(int[] nums) {

        int n = nums.length;
        for (int i = n/2-1; i >= 0; i--) {
            heapify(nums, i);
        }

    }



    // 个人觉得，就是下沉
    private void heapify(int[] nums, int i){
        int n = nums.length;
        int left = 2*i + 1;
        int right = 2*i + 2;

        int max = i;
        if(left<heaplen && nums[max]<nums[left]){
            max = left;
        }
        if(right<heaplen && nums[max]<nums[right]){
            max = right;
        }

        if(max!=i){
            swap(nums, max, i);
            heapify(nums, max);
        }

    }

    private void swap(int[] nums, int max, int i) {
        int tmp = nums[max];
        nums[max] = nums[i];
        nums[i] = tmp;
    }


//    // Global variable that records the length of an array;
//    static int heapLen;
//
//    /**
//     * Swap the two elements of an array
//     * @param arr
//     * @param i
//     * @param j
//     */
//    private static void swap(int[] arr, int i, int j) {
//        int tmp = arr[i];
//        arr[i] = arr[j];
//        arr[j] = tmp;
//    }
//
//    /**
//     * Build Max Heap
//     * @param arr
//     */
//    private static void buildMaxHeap(int[] arr) {
//        for (int i = arr.length / 2 - 1; i >= 0; i--) {
//            heapify(arr, i);
//        }
//    }
//
//    /**
//     * Adjust it to the maximum heap
//     * @param arr
//     * @param i
//     */
//    private static void heapify(int[] arr, int i) {
//        int left = 2 * i + 1;
//        int right = 2 * i + 2;
//        int largest = i;
//        if (right < heapLen && arr[right] > arr[largest]) {
//            largest = right;
//        }
//        if (left < heapLen && arr[left] > arr[largest]) {
//            largest = left;
//        }
//        if (largest != i) {
//            swap(arr, largest, i);
//            heapify(arr, largest);
//        }
//    }
//
//    /**
//     * Heap Sort
//     * @param arr
//     * @return
//     */
//    public static int[] heapSort(int[] arr) {
//        // index at the end of the heap
//        heapLen = arr.length;
//        // build MaxHeap
//        buildMaxHeap(arr);
//        for (int i = arr.length - 1; i > 0; i--) {
//            // Move the top of the heap to the tail of the heap in turn
//            swap(arr, 0, i);
//            heapLen -= 1;
//            heapify(arr, 0);
//        }
//        return arr;
//    }


}
