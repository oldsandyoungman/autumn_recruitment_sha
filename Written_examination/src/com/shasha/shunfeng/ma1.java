package com.shasha.shunfeng;

/**
 * @author ShaLuwei
 * @create 2022-08-31 17:10
 */
public class ma1 {

    public static void main(String[] args) {


        int n = 4;

        long res = 0;
        int cur = (int)(Math.log(n)/Math.log(2));
        int target = (int)Math.pow(2,cur);

        while(cur>=0){

            res += (long) (n - target + 1) * (cur+1);
            cur--;
            n= target-1;
            target = (int)Math.pow(2,cur);

        }

        System.out.println(res);

        System.out.println(Integer.MAX_VALUE);
        System.out.println((int) Math.pow(10,9));

    }

}
