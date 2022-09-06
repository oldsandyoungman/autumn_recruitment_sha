package com.shasha.s20220720;

import org.junit.Test;

import java.io.*;

/**
 * @author ShaLuwei
 * @create 2022-07-20 12:08
 */
public class Test_file_read {

    public static void main(String[] args) {

        FileInputStream fi = null;

        try {
            File f = new File("hello.txt");
            fi = new FileInputStream(f);

            // 读取方法1，中文一定会乱码
            int res;
            while((res = fi.read())!=-1){
                System.out.print((char)res);
            }

            // 读取方法2，中文会乱码(没有被截断)
//            byte[] buffer = new byte[5];
//            int len;
//            while((len=fi.read(buffer))!=-1){
//                System.out.print(new String(buffer, 0, len));
//            }
        } catch (IOException e) {
            if (fi != null) {
                try {
                    fi.close();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        }


    }

    @Test
    public void test(){
        BufferedReader bf = null;
        BufferedWriter bw = null;
        try {
            File f = new File("hello.txt");
            File f2 = new File("hello2.txt");
            FileReader fr = new FileReader(f);
            FileWriter fw = new FileWriter(f2);
            bf = new BufferedReader(fr);
            bw = new BufferedWriter(fw);

            // 读写方法1
            String res;
            while ((res = bf.readLine())!=null) {
                bw.write(res);
            }
            // 读写方法2
//            int len = 0;
//            char[] buffer = new char[1024];
//            while((len = bf.read(buffer))!=-1){
//                bw.write(buffer, 0, len);
//            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (bf!=null) {
                try {
                    bf.close();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        }
    }


}
