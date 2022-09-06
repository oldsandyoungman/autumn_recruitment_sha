package com.shasha.s20220717;

/**
 * @author ShaLuwei
 * @create 2022-07-17 17:19
 */
public class Test_String {


    final char value[] = new char[3];

    public static void main(String[] args) {

        Test_String tt = new Test_String();
        tt.value[0] = 'a';
        tt.value[1] = 'b';
        tt.value[2] = 'c';
        System.out.println(tt.value);

        String a = "abc";
        String b = "abc";
        System.out.println(a==b);
        String c = b.replace('a', 'm');
        System.out.println(b==c);

        String d = "a" + "b" + "c";
        System.out.println(a==d);
        String e = "ab";
        String f = e+"c";
        System.out.println(a==f);

        StringBuffer sb = new StringBuffer();
        StringBuffer a1 = sb.append('a');
        System.out.println(a1==sb);


    }

}
