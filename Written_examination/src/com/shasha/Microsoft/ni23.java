package com.shasha.Microsoft;

/**
 * @author ShaLuwei
 * @create 2022-08-25 20:07
 */
public class ni23 {

    public int solution(int[] A) {
        // write your code in Java 8 (Java SE 8)
        int n = A.length;
        int l = 0;
        long ans = 0;
        while (l < n-2) {
            int r = l + 1;
            if ((long)A[l+2] - A[l+1] == (long)A[l+1] - A[l]) {
                r = l + 2;
                while (r < n && (long)A[r] - A[r-1] == (long)A[r-1] - A[r-2]) {
                    r ++;
                }
                int len = r - l;
                ans = ans + (long)(len - 1)*(len - 2) / 2;
                if (ans > 1000000000) {
                    return -1;
                }
                r --;
            }
            l = r;
        }
        return (int) ans;
    }

}
