package com.shasha.s20220717;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * callable 方法调用线程
 *
 * @author ShaLuwei
 * @create 2022-07-17 13:57
 */
public class Test_callable_thread {

    public static void main(String[] args) {

        MyCallable m = new MyCallable();

        FutureTask f = new FutureTask(m);

        Thread t = new Thread(f);

        t.start();

        try {
            Object o = f.get();
            System.out.println(o);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }

}


class MyCallable implements Callable {


    @Override
    public Object call() throws Exception {

        int sum = 0;

        for (int i = 0; i < 100; i++) {
            sum += i;
        }

        return sum;
    }
}
