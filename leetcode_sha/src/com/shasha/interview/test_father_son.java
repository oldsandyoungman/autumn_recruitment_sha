package com.shasha.interview;

/**
 * @author ShaLuwei
 * @create 2022-08-10 15:19
 */
public class test_father_son {

    public static void main(String[] args) {
//        Child child = new Child();

        Integer a = 100;
        Integer b = 100;

        System.out.println(a==b);
        System.out.println(a.equals(b));


        Integer aa = 1000;
        Integer bb = 1000;

        System.out.println(aa==bb);
        System.out.println(aa.equals(bb));


//        -128 ~ 127
//        a==b 不对
//        a.equals b 对的，比较值


//        可以两个对象 hashcode 相等

//        不可以，hashcode 一般计算方法都是拿



//        可以


//        差不多了吧，说得太全了




    }

}



class Parent {
    static {
        System.out.println("Parent static block");
    }

    {
        System.out.println("Parent non static block");
    }

    final static Value i = new Value("Parent static value");

    Value j = new Value("Parent non static value");

    Parent() {
        System.out.println("Parent Constructor");
    }
}


class Child extends Parent {
    static {
        System.out.println("Child static block");
    }

    final static Value i = new Value("Child static value");

    {
        System.out.println("Child non static block");
    }

    Value j = new Value("Child non static value");

    Child() {
        System.out.println("Child Constructor");
    }
}

class Value {
    public Value(String value) {
        System.out.println(value);
    }
}