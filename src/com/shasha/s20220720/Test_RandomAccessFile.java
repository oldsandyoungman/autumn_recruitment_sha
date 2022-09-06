package com.shasha.s20220720;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * @author ShaLuwei
 * @create 2022-07-20 16:56
 */
public class Test_RandomAccessFile {

    public static void main(String[] args) throws IOException {

        RandomAccessFile raf = new RandomAccessFile("hello.txt", "rw");
        RandomAccessFile raf2 = new RandomAccessFile("hello.txt", "r");


        // 第一次写
        raf.write("abcdefghijklmn".getBytes());

        // 第一次读
        int len = 0;
        byte[] buffer = new byte[10];
        while((len = raf2.read(buffer))!=-1){
            System.out.print(new String(buffer,0,len));
        }

        // 第二次写
        raf.seek(3);
        raf.write("xyz".getBytes());

        // 第二次读
        System.out.println();
        raf2.seek(0);
        while((len = raf2.read(buffer))!=-1){
            System.out.print(new String(buffer,0,len));
        }

        raf.close();
        raf2.close();


    }

}
