package com.shasha.s20220717;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author ShaLuwei
 * @create 2022-07-17 11:01
 */
public class Test_lock {

    public static void main(String[] args) {
        Window w = new Window();
        Thread t1 = new Thread(w);
        Thread t2 = new Thread(w);
        Thread t3 = new Thread(w);

        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");

        t1.start();
        t2.start();
        t3.start();

    }

}

class Window implements Runnable{

    ReentrantLock lock = new ReentrantLock();

    private int tickets = 100;


    @Override
    public void run() {

        try {

            lock.lock();

            while(true){
                if(tickets>0){
                    System.out.println(Thread.currentThread().getName() + "卖了第 " + tickets + " 张票");
                    tickets--;
                }else{
                    break;
                }
            }


        }finally {
            lock.unlock();
        }


    }
}