package com.shasha.MorganStanley;

import org.junit.Test;

/**
 * @author ShaLuwei
 * @create 2022-08-26 21:11
 */
public class ce1 {

    @Test
    public void test(){
        String s = "0101101";
        int k = 3;
        System.out.println(getMin(s, k));
    }

    public String getMin(String s, int k){

        char[] ss = s.toCharArray();
        int n = ss.length;
        int l = 0;
        int r = 0;
        int count = 0;
        String res = "";
        int res_len = n+1;

        while(r<n){
            char cur = ss[r];
            if(cur=='1'){
                count++;
            }
            r++;

            while(count==k){
                if(res_len>r-l || (res_len==r-l && s.substring(l, r).compareTo(res)<0) ){
                    res_len = r-l;
                    res = s.substring(l, r);
                }
                cur = ss[l];
                if(cur=='1'){
                    count--;
                }
                l++;
            }

        }

        return res;

    }

}
