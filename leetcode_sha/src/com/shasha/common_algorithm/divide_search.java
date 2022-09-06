package com.shasha.common_algorithm;

/**
 * @author ShaLuwei
 * @create 2022-08-17 11:49
 */
public class divide_search {

    public static void main(String[] args) {
        int[] nums = {1,3,3,5,7};
        int target = 4;
        System.out.println(partition_search_l(nums, target));
        System.out.println(partition_search_r(nums, target));
    }

    // 对于左边界，
    // 如果存在的话，返回的就是target的左边界
    // 如果不存在的话，返回的就是从左往右，第一个比target大的index
    public static int partition_search_l(int[] nums, int target){
        int n = nums.length;
        int left = 0;
        int right = n-1;
        while (left<=right){
            int mid = left + (right-left)/2;
            if(nums[mid]<target){
                left = mid + 1;
            }else{
                right = mid -1;
            }
        }
//        if(left>=n || nums[left]!=target){
//            return -1;
//        }
        return left;
    }

    // 对于右边界，
    // 如果存在的话，返回的就是target的右边界
    // 如果不存在的话，返回的就是从右往左，第一个比target小的index
    public static int partition_search_r(int[] nums, int target){
        int n = nums.length;
        int left = 0;
        int right = n-1;
        while (left<=right){
            int mid = left + (right-left)/2;
            if(nums[mid]>target){
                right = mid -1;
            }else{
                left = mid + 1;
            }
        }
//        if(right<0 || nums[right]!=target){
//            return -1;
//        }
        return right;
    }

}
