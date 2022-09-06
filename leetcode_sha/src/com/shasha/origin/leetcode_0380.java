package com.shasha.origin;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

/**
 * @author ShaLuwei
 * @create 2022-08-01 00:08
 */
public class leetcode_0380 {

    @Test
    public void test(){

        RandomizedSet rs = new RandomizedSet();


//        rs.insert(0);
//        rs.insert(1);
//        rs.remove(0);
//        rs.insert(2);
//        rs.remove(1);

        rs.insert(0);
        rs.remove(0);
        rs.insert(0);


    }

}

class RandomizedSet {

    ArrayList<Integer> l;
    int count;
    HashMap<Integer, Integer> memo;
    Random r;

    public RandomizedSet() {
        l = new ArrayList<>();
        count = 0;
        memo = new HashMap<>();
        r = new Random();
    }

    public boolean insert(int val) {
        if(memo.containsKey(val)){
            return false;
        }
        l.add(val);
        memo.put(val, count);
        count++;
        return true;
    }

    public boolean remove(int val) {
        if(!memo.containsKey(val)){
            return false;
        }
        int i = memo.get(val);
        int v = l.get(count-1);
        l.set(i, v);
        l.remove(count-1);
        memo.put(v, i);
        memo.remove(val);
        count--;
        return true;
    }

    public int getRandom() {
        int num = r.nextInt(count);
        return l.get(num);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */