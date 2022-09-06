package com.shasha.s20220720;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

/**
 * @author ShaLuwei
 * @create 2022-07-20 15:17
 */
public class Test_printStream {

    public static void main(String[] args) {

        PrintStream ps = null;
        try {
            File f = new File("hello.txt");
            FileOutputStream fos = new FileOutputStream(f);

            ps = new PrintStream(fos, true);
            if (ps!=null){
                System.setOut(ps);
            }

            System.out.println("123");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if(ps!=null){
                ps.close();
            }
        }

    }

}
