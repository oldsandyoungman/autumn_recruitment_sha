package com.shasha.ByteDance;

/**
 * @author ShaLuwei
 * @create 2022-08-21 20:13
 */
public class ma3 {


    public static void main(String[] args) {

        String pattern = "ad{sdad}afaf{y}sf{ss}s";
        char[] pp = pattern.toCharArray();
        int n = pp.length;
        int l = 0;
        int r = 0;
        StringBuilder sb = new StringBuilder();
        while(r<n){

            if(pp[r]=='{'){
                l = r;
                sb.append(pattern.substring(l, r));
            }else if(pp[r]=='}'){
                sb.append(".*");
                l = r+1;
            }
            r++;

        }

        System.out.println(sb.toString());

        String remark = "sdaasa{sss}";
        remark = remark.replaceAll("\\{.*?\\}", ".*");
        System.out.println(remark);
    }

}
