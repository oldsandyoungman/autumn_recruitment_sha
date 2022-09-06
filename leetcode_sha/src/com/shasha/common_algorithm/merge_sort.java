package com.shasha.common_algorithm;

/**
 * 归并排序
 * @author ShaLuwei
 * @create 2022-08-04 19:12
 */
public class merge_sort {

    public static void main(String[] args) {

        int i =21;
        int j=-1;
        System.out.println(i&j);

        try {
            int test =merge_sort.test();
            System.out.print(test);
        }catch (Exception e){
            System.out.print(6);
        }
    }

    private static int test() {
        try{
            int i =9/0;
            return 1;
        }catch (Exception e){
            return 2;
        }finally {
            System.out.print(3);
        }
    }

//
//    @Test
//    public void test1(){
//        int[] nums = {1,5,2,3,7,4,6};
//        sort_all(nums);
//        System.out.println(Arrays.toString(nums));
//    }
//
//    int[] tmp;
//
//    public void sort_all(int[] nums){
//        int n = nums.length;
//        tmp = new int[n];
//        sort_sha(nums, 0, n-1);
//    }
//
//    public void sort_sha(int[] nums, int start, int end){
//        if(start>=end){
//            return;
//        }
//
//        int mid = start + (end - start)/2;
//
//        sort_sha(nums, start, mid);
//        sort_sha(nums, mid+1, end);
//
//        merge_sha(nums, start, mid, end);
//
//    }
//
//    private void merge_sha(int[] nums, int start, int mid, int end) {
//        if(start>=end){
//            return;
//        }
//
//        for(int i=start; i<=end; i++){
//            tmp[i] = nums[i];
//        }
//
//        int l = start;
//        int r = mid + 1;
//        int index = start;
//
//        while(l<=mid && r<=end){
//            if(tmp[l]<=tmp[r]){
//                nums[index++] = tmp[l++];
//            }else{
//                nums[index++] = tmp[r++];
//            }
//        }
//
//        if(l==mid+1){
//            while(r<=end){
//                nums[index++] = tmp[r++];
//            }
//        }else{
//            while(l<=mid) {
//                nums[index++] = tmp[l++];
//            }
//        }
//
//
//
//    }

}
