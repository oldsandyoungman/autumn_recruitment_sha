package com.shasha.origin;

import java.util.*;

/**
 * @author ShaLuwei
 * @create 2022-08-13 22:39
 */
public class leetcode_0460 {

    public static void main(String[] args) {

        LFUCache c = new LFUCache(2);
        c.put(1,1);
        c.put(2,2);
        c.get(1);
        c.put(3,3);
        System.out.println(c.get(2));


    }

}

class LFUCache {

    HashMap<Integer, Integer> key2val;
    HashMap<Integer, Integer> key2fre;
    HashMap<Integer, LinkedHashSet<Integer>> fre2key;
    int cap;
    int minfre;

    public LFUCache(int capacity) {
        key2val = new HashMap<>();
        key2fre = new HashMap<>();
        fre2key = new HashMap<>();
        cap = capacity;
        minfre = 0;
    }

    public int get(int key) {
        if(key2val.containsKey(key)){
            int fre = key2fre.get(key);
            key2fre.put(key, fre+1);
            fre2key.get(fre).remove(key);
            if(fre2key.get(fre).size()==0 && minfre==fre){
                minfre++;
            }
            fre2key.putIfAbsent(fre+1, new LinkedHashSet<>());
            fre2key.get(fre+1).add(key);
            return key2val.get(key);
        }
        return -1;
    }

    public void put(int key, int value) {
        if(key2val.containsKey(key)){
            key2val.put(key, value);
            int fre = key2fre.get(key);
            key2fre.put(key, fre+1);
            fre2key.get(fre).remove(key);
            if(fre2key.get(fre).size()==0 && minfre==fre){
                minfre++;
            }
            fre2key.putIfAbsent(fre+1, new LinkedHashSet<>());
            fre2key.get(fre+1).add(key);
            return;
        }

        if(cap==key2val.size()){
            int oldkey = fre2key.get(minfre).iterator().next();
            key2val.remove(oldkey);
            key2fre.remove(oldkey);
            fre2key.get(minfre).remove(oldkey);
            // 这个地方不需要更新minFre，因为下面反正要minfre = 1的
        }

        key2val.put(key, value);
        key2fre.put(key, 1);
        fre2key.putIfAbsent(1, new LinkedHashSet<>());
        fre2key.get(1).add(key);
        minfre = 1;

    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
