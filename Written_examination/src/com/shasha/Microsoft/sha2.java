package com.shasha.Microsoft;

import org.junit.Test;

import java.util.ArrayList;

/**
 * @author ShaLuwei
 * @create 2022-08-06 08:58
 */
public class sha2 {

    @Test
    public void test(){
//        String s = "WRRWWR";
        String s = "WWRWRWRWR";
//        String s = "WWRWWWRWR";
//        String s = "WWW";
//        StringBuilder sb = new StringBuilder();
//        for(int i=0; i<100000; i++){
//            sb.append("RW");
//        }
//        String s = sb.toString();
        System.out.println(solution(s));
    }

    public int solution(String S) {
        // write your code in Java 8 (Java SE 8)

        char[] ss = S.toCharArray();

        int n = ss.length;

        ArrayList<Integer> memo = new ArrayList<>();

        for(int i=0; i<n; i++){
            if(ss[i]=='R'){
                memo.add(i);
            }
        }

        int sum = 0;

        int nn = memo.size();

        if(nn==0){
            return 0;
        }

        if(nn%2==1){
            int l = 0;
            int r = nn-1;
            int mid = nn/2;
            int bound_l = memo.get(mid)-1;
            int bound_r = memo.get(mid)+1;
            while(l<r){
                // 左边界的更新
                sum += bound_l-memo.get(l);
                bound_l--;
                if(sum>1000000000){
                    return -1;
                }
                // 右边界的更新
                sum += memo.get(r)-bound_r;
                bound_r++;
                if(sum>1000000000){
                    return -1;
                }
                l++;
                r--;
            }
        }else{
            int l = 1;
            int r = nn-1;
            int mid = nn/2;
            int bound_l = memo.get(mid)-1;
            int bound_r = memo.get(mid)+1;
            while(l<r){
                // 左边界的更新
                sum += bound_l-memo.get(l);
                bound_l--;
                if(sum>1000000000){
                    return -1;
                }
                // 右边界的更新
                sum += memo.get(r)-bound_r;
                bound_r++;
                if(sum>1000000000){
                    return -1;
                }
                l++;
                r--;
            }

            sum += bound_l-memo.get(0);
            if(sum>1000000000){
                return -1;
            }

        }

        return sum;

    }

}
