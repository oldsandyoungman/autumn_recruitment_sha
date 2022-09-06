package com.shasha.s20220720;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author ShaLuwei
 * @create 2022-07-20 17:58
 */
public class Test_socket {



    @Test
    public void client() {

        OutputStream outputStream = null;
        Socket s = null;
        try {
            InetAddress inet = InetAddress.getLocalHost();
            s = new Socket(inet, 8889);

            outputStream = s.getOutputStream();

            outputStream.write("沙哥牛逼~~123".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(outputStream!=null){
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (s!=null){
                try {
                    s.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }







    }

    @Test
    public void server(){
        ServerSocket ss = null;
        Socket accept = null;
        InputStream inputStream = null;
        InputStreamReader isr = null;
        try {
            ss = new ServerSocket(8889);
            accept = ss.accept();

            inputStream = accept.getInputStream();

            isr = new InputStreamReader(inputStream);

            char[] buffer = new char[5];
            int len = 0;
            while((len = isr.read(buffer))!=-1){
                System.out.print(new String(buffer,0,len));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(isr!=null){
                try {
                    isr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(inputStream!=null){
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(accept!=null){
                try {
                    accept.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(ss!=null){
                try {
                    ss.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }





    }


}
