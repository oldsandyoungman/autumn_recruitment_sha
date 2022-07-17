package com.shasha.s20220717;

/**
 * 生产者 - 消费者问题
 * @author ShaLuwei
 * @create 2022-07-17 12:29
 */
public class Test_producer_customer {

    public static void main(String[] args) {
        Clerk c  = new Clerk();
        Producer p1 = new Producer(c);
        Customer c1 = new Customer(c);

        Thread pp1 = new Thread(p1);
        Thread cc1 = new Thread(c1);

        pp1.start();
        cc1.start();

    }

}


class Clerk{

    private int count = 0;

    public synchronized void produce(){

        if(count<20){
            count++;
            System.out.println(Thread.currentThread().getName() + "正在生产第 " + count + "个产品");
            notify();
        }else{
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public synchronized void consume(){

        if(count>0){
            System.out.println(Thread.currentThread().getName() + "正在消费第 " + count + "个产品");
            count--;
            notify();
        }else{
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

}


class Producer implements Runnable{

    Clerk c;

    public Producer(Clerk c){
        this.c = c;
    }

    @Override
    public void run() {

        while (true){
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            c.produce();
        }

    }
}


class Customer implements Runnable{

    Clerk c;

    public Customer(Clerk c){
        this.c = c;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            c.consume();
        }
    }
}

