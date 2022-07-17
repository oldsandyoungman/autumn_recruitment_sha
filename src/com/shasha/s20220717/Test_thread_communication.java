package com.shasha.s20220717;

/**
 * @author ShaLuwei
 * @create 2022-07-17 11:33
 */
public class Test_thread_communication {


    public static void main(String[] args) {
        MyRunnalbe r = new MyRunnalbe();
        Thread t1 = new Thread(r);
        Thread t2 = new Thread(r);

        t1.setName("甲");
        t2.setName("乙");

        t1.start();
        t2.start();

    }

}


class MyRunnalbe implements Runnable {

    private int num = 1;

    @Override
    public void run() {

        while(true){
            synchronized (this){
                notify();
                if(num<=100){
                    System.out.println(Thread.currentThread().getName() + ":" + num);

//                    try {
//                        Thread.sleep(100);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }

                    num++;

                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }else {
                    break;
                }
            }
        }



    }

    // 错误示范：while 写里面了，这样notify 只运行了 1 次，肯定卡住了

//    @Override
//    public void run() {
//
//        synchronized (this) {
//            notify();
//            while (true) {
//                if (num <= 100) {
//                    System.out.println(Thread.currentThread().getName() + ":" + num);
//
//                    //                    try {
//                    //                        Thread.sleep(100);
//                    //                    } catch (InterruptedException e) {
//                    //                        e.printStackTrace();
//                    //                    }
//
//                    num++;
//
//                    try {
//                        wait();
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//
//                } else {
//                    break;
//                }
//            }
//        }
//    }


}


