package com.shasha.trendmicro;

import org.junit.Test;

import java.util.HashMap;

/**
 * @author ShaLuwei
 * @create 2022-08-05 20:05
 */
public class ma1 {


    @Test
    public void test(){

        String s = "%FILENAME%VIRUSNAME%balabala%VIRUSNAME%FILENAME%";
        String[] keys = {"FILENAME", "VIRUSNAME"};
        String[] values = {"Myfile","ICAN"};

        System.out.println(token_replace(s, keys, values));

    }

    public String token_replace(String my_template, String[] keys, String[] values){

        StringBuilder sb = new StringBuilder();

        HashMap<String, String> memo = new HashMap<>();
        int n = keys.length;
        for (int i = 0; i < n; i++) {
            memo.put(keys[i], values[i]);
        }

        int i=0;
        int state = 0;
        int left = 0;
        int end = 0;

        while(i<my_template.length()){
            char cur = my_template.charAt(i);

            if(cur!='%'){
                i++;
                continue;
            }

            if(state==0){
                left = i;
                state = 1;
                i++;
                continue;
            }

            if (i-left==1) {
                sb.append("%");
                left = i;
                i++;
                continue;
            }

            String str = my_template.substring(left+1, i);
            if (memo.containsKey(str)) {
                sb.append(memo.get(str));
                end = i+1;
                state = 0;
            }else{
                sb.append(my_template.substring(end, i));
                left = i;
                end = i;

            }

            i++;

        }

        sb.append(my_template.substring(end));

        return sb.toString();




        


    }



}
