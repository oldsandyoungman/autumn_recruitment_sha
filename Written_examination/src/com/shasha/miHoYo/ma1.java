package com.shasha.miHoYo;

/**
 * @author ShaLuwei
 * @create 2022-07-29 17:40
 */
public class ma1 {

    public static void main(String[] args) {




    }

    public String mul(String s1, String s2){
        int sign = 1;
        if (s1.charAt(0)=='-'){
            sign *= -1;
            s1 = s1.substring(1);
        }
        if (s2.charAt(0)=='-') {
            sign *= -1;
            s2 = s2.substring(1);
        }
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        int n1 = c1.length;
        int n2 = c2.length;
        int[] res = new int[n1+n2];
        for(int i=n1-1; i>=0; i--){
            for(int j=n2-1; j>=0; j--){
                int a = c1[i] - '0';
                int b = c2[j] - '0';

                int tmp = a*b + res[i+j+1];
                res[i+j+1] = tmp%10;
                res[i+j] += tmp/10;

            }
        }

        int i = 0;
        while(i<n1+n2 && res[i]==0){
            i++;
        }

        StringBuilder sb = new StringBuilder();
        if (sign==-1){
            sb.append("-");
        }
        for(; i<n1+n2; i++){
            sb.append(res[i]);
        }

        return sb.toString();



    }


}
