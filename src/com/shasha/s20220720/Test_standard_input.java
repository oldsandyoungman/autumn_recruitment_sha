package com.shasha.s20220720;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author ShaLuwei
 * @create 2022-07-20 15:05
 */
public class Test_standard_input {

    public static void main(String[] args) {

        BufferedReader br = null;
        try {
            InputStreamReader isr = new InputStreamReader(System.in);
            br = new BufferedReader(isr);

            String res = null;
            while((res = br.readLine())!=null){
                if("e".equalsIgnoreCase(res)){
                    break;
                }
                String uppercase = res.toUpperCase();
                System.out.println(uppercase);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(br!=null){
                try {
                    br.close();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        }



    }

}
