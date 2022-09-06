package com.shasha.s20220719;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * @author ShaLuwei
 * @create 2022-07-19 21:15
 */
public class Test_properties {

    public static void main(String[] args) {
        FileInputStream fi = null;
        try {
            Properties pro = new Properties();
            fi = new FileInputStream("test_properties.properties");
            pro.load(fi);

            String name = pro.getProperty("name");
            String age = pro.getProperty("age");

            System.out.println(name);
            System.out.println(age);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fi!=null){
                try {
                    fi.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }



    }

}
