package com.shasha.s20220719;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author ShaLuwei
 * @create 2022-07-19 23:48
 */
public class Test_generic_class_function {

    public static void main(String[] args) {
        SubOrder1 s1 = new SubOrder1(1);
        SubOrder2<Integer> s2 = new SubOrder2<>(1);

        List<Object> o = new ArrayList<>();
        List<String> s = new ArrayList<>();
        print(o);
        print(s);

    }

    // 泛型方法可以是静态的
    public static <E> E show(E e){
        return e;
    }

    public static void print(List<?> cur){
        Iterator<?> iterator = cur.iterator();
        while (iterator.hasNext()){
            Object o = iterator.next();
            System.out.println(o);
        }
    }

}


class Order<T>{

    T order;

    public Order(T order) {
        this.order = order;
    }

    public static void show(){
        // 静态方法使用泛型会报错
//        T tt = new T();
        System.out.println();
    }

}

class SubOrder1 extends Order<Integer>{
    public SubOrder1(Integer order) {
        super(order);
    }
}

class SubOrder2<T> extends Order<T>{

    public SubOrder2(T order) {
        super(order);
    }
}
