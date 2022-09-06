package com.shasha.s20220720;

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author ShaLuwei
 * @create 2022-07-20 20:00
 */
public class Test_socket_file_words {


    @Test
    public void client() throws IOException {

        // 文件 输入流的定义
        FileInputStream fis = new FileInputStream("art_pig.jpg");

        // socket 输出流的定义
        InetAddress inet = InetAddress.getByName("127.0.0.1");
        Socket s = new Socket(inet, 8889);
        OutputStream os = s.getOutputStream();

        int len = 0;
        byte[] buffer = new byte[5];

        while((len = fis.read(buffer))!=-1){
            os.write(buffer, 0, len);
        }

        s.shutdownOutput();

        InputStream is = s.getInputStream();
        InputStreamReader isr = new InputStreamReader(is);
        char[] buf = new char[5];
        while((len = isr.read(buf))!=-1){
            System.out.print(new String(buf, 0, len));
        }

        isr.close();
        os.close();
        s.close();
        fis.close();

    }

    @Test
    public void server() throws IOException {
        // 文件 输出流
        FileOutputStream fos = new FileOutputStream("art_pig2.jpg");

        // socket 输入流
        ServerSocket ss = new ServerSocket(8889);
        Socket s = ss.accept();
        InputStream is = s.getInputStream();

        int len = 0;
        byte[] buffer = new byte[5];
        while((len=is.read(buffer))!=-1){
            fos.write(buffer, 0, len);
        }

        OutputStream os = s.getOutputStream();

        os.write("发送完成word沙".getBytes());


        os.close();
        is.close();
        s.close();
        ss.close();
        fos.close();

    }


}
