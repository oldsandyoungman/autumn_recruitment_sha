package com.shasha.s20220720;

import org.junit.Test;

import java.io.IOException;
import java.net.*;

/**
 * @author ShaLuwei
 * @create 2022-07-20 20:37
 */
public class Test_socket_udp {

    @Test
    public void client() throws IOException {

        DatagramSocket ds = new DatagramSocket();
        byte[] bytes = "UDP就是我~~".getBytes();
        DatagramPacket dp = new DatagramPacket(bytes,0,bytes.length, InetAddress.getLocalHost(),8889);

        ds.send(dp);



    }


    @Test
    public void server() throws IOException{
        DatagramSocket ds = new DatagramSocket(8889);
        byte[] buf = new byte[100];
        DatagramPacket dp = new DatagramPacket(buf,0,buf.length);

        ds.receive(dp);

        System.out.println(new String(dp.getData(),0,dp.getLength()));

    }

}
