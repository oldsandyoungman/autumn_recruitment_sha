package com.shasha.s20220713;

public class Test_field_method2 {
    public static void main(String[] args){
        Base1 b = new Sub1();
        b.show(1,2,3);

        Sub1 s = (Sub1)b;
        s.show(1,2,3);

    }
}

class Base1{
    public void show(int a, int... arr){
        System.out.println("base1");
    }
}

class Sub1 extends Base1{
    public void show(int a, int[] arr){
        System.out.println("sub1");
    }
    public void show(int a, int b, int c){
        System.out.println("sub2");
    }
}


