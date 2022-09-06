package com.shasha.origin;

import org.junit.Test;

import java.util.ArrayDeque;

/**
 * @author ShaLuwei
 * @create 2022-08-02 00:54
 */
public class leetcode_1081 {

    @Test
    public void test(){
//        String s = "cbaacabcaaccaacababa";
//        String s = "abcacb";
        String s = "bcbcaba";
        System.out.println(smallestSubsequence(s));
    }

    public String smallestSubsequence(String s) {
        char[] ss = s.toCharArray();
        int n = ss.length;
        int[] memo = new int[26];
        boolean[] exists = new boolean[26];

        for(char c : ss){
            memo[c-'a']++;
        }

        ArrayDeque<Character> q = new ArrayDeque<>();

        for(char c : ss){

            memo[c-'a']--;

            if(exists[c-'a']){
                continue;
            }

            while(!q.isEmpty() && q.getLast()>c && memo[q.getLast()-'a']>0){
                exists[q.removeLast()-'a'] = false;
            }

            q.addLast(c);
            exists[c-'a'] = true;




        }

        StringBuilder sb = new StringBuilder();
        while(!q.isEmpty()){
            sb.append(q.removeFirst());
        }

        return sb.toString();

    }

}
