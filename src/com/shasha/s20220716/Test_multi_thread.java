package com.shasha.s20220716;

/**
 * @author ShaLuwei
 * @create 2022-07-16 09:59
 */
public class Test_multi_thread {

    public static void main(String[] args) {

        // 方式一：
        MyThread t = new MyThread();
        t.start();

        // 方式二：
        MyRunnable r = new MyRunnable();
        Thread t2 = new Thread(r);
        t2.start();

    }


}


class MyThread extends Thread{

    @Override
    public void run() {

        try {
            sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("123");
    }
}

class MyRunnable implements Runnable{

    @Override
    public void run() {
        try {
            System.out.println("666");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
