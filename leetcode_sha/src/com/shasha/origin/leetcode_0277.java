package com.shasha.origin;

/**
 * @author ShaLuwei
 * @create 2022-08-12 12:06
 */
public class leetcode_0277 {


    // 可以直接调用，能够返回 i 是否认识 j
    boolean knows(int i, int j){

        return true;

    }

    // 请你实现：返回「名人」的编号
    int findCelebrity(int n) {

        int can = 0;
        int cur = 1;
        while(cur<n){

            if(knows(can, cur)){
                if(knows(cur, can)){
                    can = cur+1;
                }else {
                    can = cur;
                }
            }else{
                if(knows(cur, can)){

                }else {
                    can = cur+1;
                }
            }

            cur++;

        }

        for (int i = 0; i < n; i++) {
            if(i==can){
                continue;
            }
            if(knows(can, i) || !knows(i, can)){
                return -1;
            }
        }

        return can;

    }

}
