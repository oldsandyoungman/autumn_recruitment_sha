package com.shasha.origin;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author ShaLuwei
 * @create 2022-08-07 00:13
 */
public class leetcode_1153 {
    /*


leetcode
codeleet

 */
    @Test
    public void test(){
        String s1 = "aabcc";
        String s2 = "ccdee";

        System.out.println(canConvert(s1, s2));
    }

    public boolean canConvert(String str1, String str2) {
        if (str1.equals(str2)) return true;
        HashSet<Character> set = new HashSet<>();
        HashMap<Character, Character> a = new HashMap<>();
        for (int i = 0; i < str1.length(); i++) {
            char ch1 = str1.charAt(i),  ch2 = str2.charAt(i);
            if (!a.containsKey(ch1)) a.put(ch1, ch2); //1.str1相同的字符对应的那些下标，在str2中这些下标的字符应该相同
            else if(ch2 != a.get(ch1)) return false;
            set.add(ch2);
        }
        return set.size() == 26 ? false :true; //2.str2中不同的字符数量要少于26，
    }
}