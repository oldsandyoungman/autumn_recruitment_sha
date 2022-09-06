package com.shasha.s20220717;

/**
 * @author ShaLuwei
 * @create 2022-07-17 23:23
 */
public class Test_max_same_substring {

    public static void main(String[] args) {
        String a = "sdaasda";
        String b = "aas";

        System.out.println(maxSameSubstring(a, b));
    }

    public static String maxSameSubstring(String a, String b){
        String max = (a.length()>b.length())?a:b;
        String min = (a.length()<b.length())?a:b;

        for(int i=0; i<min.length(); i++){
            for(int x=0, y=min.length()-i; y<=min.length(); x++, y++){
                if(max.contains(min.substring(x, y))){
                    return min.substring(x, y);
                }
            }
        }

        return "";

    }

}
