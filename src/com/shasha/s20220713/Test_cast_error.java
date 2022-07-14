package com.shasha.s20220713;

public class Test_cast_error {

    public static void main(String[] args) {

        // 报错版本
//        Person p = new Man();
//        Man m = (Man) p; // 本质上堆中是Man，所以Man转Man没啥问题
//        Women w = (Women) p; // 本质上堆中是Man，所以Man转Woman，肯定有问题

        // 正确版本
//        Person p2 = new Man();
//        if(p2 instanceof Man){
//            Man m2 = (Man) p2;
//            System.out.println("转型成功");
//        }else{
//            System.out.println("转型失败");
//        }
//        Person p3 = new Person();
//        if(p3 instanceof Man){
//            Man m3 = (Man) p3;
//            System.out.println("转型成功");
//        }else{
//            System.out.println("转型失败");
//        }
//        Man m4 = new Man();
//        if(m4 instanceof Person){
//            Person p4 = (Person) m4;
//            System.out.println("转型成功");
//        }else{
//            System.out.println("转型失败");
//        }

        // 两次转换是否损失精度
        Man m = new Man();
        System.out.println(m.mm);
        Person p = (Person)m;
        System.out.println(p.pp);
        Man mm = (Man)p;
        System.out.println(mm.mm);

    }

}

class Person{
    public int pp = 1;
}

class Man extends Person{
    public int mm = 2;
}

class Women extends Person{
    public int nn = 3;
}