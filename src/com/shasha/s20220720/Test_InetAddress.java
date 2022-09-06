package com.shasha.s20220720;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author ShaLuwei
 * @create 2022-07-20 17:33
 */
public class Test_InetAddress {

    public static void main(String[] args) throws UnknownHostException {

        InetAddress inet1 = InetAddress.getByName("www.baidu.com");
        System.out.println(inet1);
        System.out.println(inet1.getHostName());
        System.out.println(inet1.getHostAddress());

        System.out.println();

        InetAddress inet2 = InetAddress.getByName("127.0.0.1");
        System.out.println(inet2);

        InetAddress localHost = InetAddress.getLocalHost();
        System.out.println(localHost);


    }

}
