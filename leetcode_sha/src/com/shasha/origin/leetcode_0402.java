package com.shasha.origin;

import org.junit.Test;

import java.util.ArrayDeque;

/**
 * @author ShaLuwei
 * @create 2022-08-26 00:00
 */
public class leetcode_0402 {

    @Test
    public void test(){
        String num = "10001";
        int k = 4;
        System.out.println(removeKdigits(num, k));
    }

    public String removeKdigits(String num, int k) {

        char[] cc = num.toCharArray();
        int n = cc.length;
        ArrayDeque<Character> q = new ArrayDeque<>();
        int i=0;
        for(; i<n; i++){

            while(!q.isEmpty() && q.getLast()>cc[i]){
                q.removeLast();
                k--;
                if(k==0){
                    boolean zero = true;
                    StringBuilder sb = new StringBuilder();
                    while(!q.isEmpty()){
                        char tmp = q.removeFirst();
                        if(zero && tmp=='0'){
                            continue;
                        }
                        zero = false;
                        sb.append(tmp);
                    }
                    while(i<n){
                        if(zero && cc[i]=='0'){
                            i++;
                            continue;
                        }
                        zero = false;
                        sb.append(cc[i]);
                        i++;
                    }
                    if(sb.length()==0){
                        return "0";
                    }
                    return sb.toString();
                }
            }

            q.addLast(cc[i]);

        }
        boolean zero = true;
        StringBuilder sb = new StringBuilder();
        while(!q.isEmpty() && sb.length()<n-k){
            char tmp = q.removeFirst();
            if(zero && tmp=='0'){
                continue;
            }
            zero = false;
            sb.append(tmp);
        }
        if(sb.length()==0){
            return "0";
        }
        return sb.toString();


    }
}