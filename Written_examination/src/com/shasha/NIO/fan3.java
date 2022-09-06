package com.shasha.NIO;

import java.util.Scanner;

/**
 * @author ShaLuwei
 * @create 2022-08-06 15:54
 */
public class fan3 {

    public static void main(String[] args)
    {

        Scanner in=new Scanner(System.in);
//
//        String s = in.nextLine();
//        String[] s1 = s.split(" ");
//        int n = s1.length;
//        int[] stations = new int[n];
//        for (int i = 0; i < n; i++) {
//            stations[i] = Integer.parseInt(s1[i]);
//        }
//
//        int extra = in.nextInt();


        int n=in.nextInt();
        int x=in.nextInt();
        String strx=String.valueOf(x);
        char cx=strx.charAt(0);//将整数变换成字符
        int total=0;
        for(int i=1;i<=n;i++)
        {
            String str=String.valueOf(i);//将整数变换为字符串

            for(int j=0;j<str.length();j++)
            {
                if(str.charAt(j)==cx) total++; //遍历字符串中的每一个字符
            }
        }
        System.out.println(total);
    }

}
