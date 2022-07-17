package com.shasha.s20220714;

public class Test_interface_static_method {

    public static void main(String[] args) {

        BB bb = new BB();
//        bb.method1();
//        BB.method1();
        AA.method1();


    }

}

interface AA{

    public static void method1(){

    }
    public default void method2(){

    }

}


class BB implements AA{



}

interface sha{

}

