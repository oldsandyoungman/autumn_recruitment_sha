package com.shasha.s20220713;

public class Test_field_method {
    public static void main(String[] args){
        Sub s = new Sub();
        System.out.println(s.a); // 2
        s.show(); // 2

        Base b = s;

        System.out.println(b==s); // true
        System.out.println(b.a); // 1
        b.show(); // 2

    }
}
class Base{
    int a = 1;
    public void show(){
        System.out.println(a);
    }
}

class Sub extends Base{
    int a = 2;
    public void show(){
        System.out.println(a);
    }
}


