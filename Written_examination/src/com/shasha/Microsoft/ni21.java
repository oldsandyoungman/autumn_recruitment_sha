package com.shasha.Microsoft;

/**
 * @author ShaLuwei
 * @create 2022-08-25 20:07
 */
public class ni21 {

    public static void main(String[] args) {



    }

    public int getMax(int N){
        String num = String.valueOf(N);
        int len = num.length();
        int ans = -999995;
        for (int i = 0; i < len; i++) {
            if (num.charAt(i) == '5') {
                int temp = Integer.parseInt(num.substring(0, i) + num.substring(i+1));
                ans = Math.max(temp, ans);
            }

        }
        return ans;
    }

}
