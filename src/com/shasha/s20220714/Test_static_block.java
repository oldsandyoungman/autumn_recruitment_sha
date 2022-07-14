package com.shasha.s20220714;

public class Test_static_block extends A{

    static {
        System.out.println("B..static");
    }
    {
        System.out.println("B..no-static");
    }

    public static void main(String[] args) {

        System.out.println("B..main");
        System.out.println("************");
        new Test_static_block();
        System.out.println("************");
        new A();
    }



}

class A{
    static{
        System.out.println("A..static");
    }
    {
        System.out.println("A..no-static");
    }
}
