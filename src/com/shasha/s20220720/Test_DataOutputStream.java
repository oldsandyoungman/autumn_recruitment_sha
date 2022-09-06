package com.shasha.s20220720;

import java.io.*;

/**
 * @author ShaLuwei
 * @create 2022-07-20 15:31
 */
public class Test_DataOutputStream {

    public static void main(String[] args) throws IOException {

        DataOutputStream dos = new DataOutputStream(new FileOutputStream("hello.txt"));

        dos.writeUTF("123");
        dos.flush();
        dos.writeInt(123);
        dos.flush();
        dos.writeDouble(12.34);

        dos.close();


        DataInputStream dis = new DataInputStream(new FileInputStream("hello.txt"));

        String s = dis.readUTF();
        System.out.println(s);
        int i = dis.readInt();
        System.out.println(i);
        double v = dis.readDouble();
        System.out.println(v);



    }

}
