package com.shasha.s20220715;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Test_read_file {


    public static void main(String[] args) {

        FileInputStream fi = null;

        try{
            File file = new File("hello.txt");
            fi = new FileInputStream(file);

            int data = fi.read();

            while(data!=-1){

                System.out.print((char)data);
                data = fi.read();

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if(fi!=null){
                    fi.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        String s = new Scanner(System.in).nextLine();
        switch (s){
            case "22":
                System.out.println(123);
                break;
            case "44":
        }


    }


}
