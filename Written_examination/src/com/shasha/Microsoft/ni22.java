package com.shasha.Microsoft;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ShaLuwei
 * @create 2022-08-25 22:44
 */
public class ni22 {




    public int solution2(int[] A) {
        Map<Integer, Integer> dict = new HashMap<>();
        dict.put(0, 1);
        int sum = 0;
        int ans = 0;
        for (int num: A) {
            sum += num;
            int cnt = dict.getOrDefault(sum, 0);
            ans += cnt;
            if (ans > 1000000000) {
                return -1;
            }
            dict.put(sum, cnt+1);
        }
        return ans;
    }

}
