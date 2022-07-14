package com.shasha.s20220713;

public class Test_singleton_hungry {

    public static void main(String[] args){
        Bank b1 = Bank.getInstance();
        Bank b2 = Bank.getInstance();
//        Bank b3 = new Bank(); // 报错

        System.out.println(b1==b2); //true
    }

}

class Bank{

    private Bank(){

    }

    private static Bank bank = new Bank();

    public static Bank getInstance(){
        return bank;
    }

}
