package com.shasha.s20220717;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 线程池创建多线程的例子
 * @author ShaLuwei
 * @create 2022-07-17 14:19
 */
public class Test_executors_thread {

    public static void main(String[] args) {

        ExecutorService service = Executors.newFixedThreadPool(10);
        System.out.println(service.getClass());

        // 接口本身没有各种属性，是接口实现的类的对象才有，所以要强转一下
        ThreadPoolExecutor t = (ThreadPoolExecutor) service;
        t.setCorePoolSize(4);
        t.setKeepAliveTime(123, TimeUnit.DAYS);

        // Runnable 的调用方法
        service.execute(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    System.out.println(i);
                }
            }
        });

        // Callable 的调用方法
//        service.submit(new Callable() {
//            @Override
//            public Object call() throws Exception {
//                for (int i = 0; i < 100; i++) {
//                    System.out.println(i);
//                }
//                return null;
//            }
//        });

        service.shutdown();




    }

}

