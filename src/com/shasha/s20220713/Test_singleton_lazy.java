package com.shasha.s20220713;

import java.util.HashSet;

public class Test_singleton_lazy {
    public static void main(String[] args){
        Order b1 = Order.getInstance();
        Order b2 = Order.getInstance();

        System.out.println(b1==b2); //true



    }
}

class Order{

    private Order(){

    }

    private static Order order = null;

    public static Order getInstance(){
        if(order==null){
            order = new Order();
        }
        return order;
    }

}
