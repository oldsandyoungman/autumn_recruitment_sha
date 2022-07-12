package com.shasha.s20220712;

import java.util.ArrayList;
import java.util.List;

public class Test_multi_father {

    public static void main(String[] args) {
        C c = new C();
        System.out.println(c.getRes());

    }

}


class A{
    int a = 1;
}

class B extends A{
    int a = 2;
}

class C  extends B{
    int a = 3;

    public int getRes(){
        return super.a;
    }

}
