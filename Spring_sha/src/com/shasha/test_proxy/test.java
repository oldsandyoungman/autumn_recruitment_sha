package com.shasha.test_proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 *
 * https://blog.csdn.net/yaomingyang/article/details/81040390
 *
 * @author ShaLuwei
 * @create 2022-08-29 12:57
 */
public class test {

    public static void main(String[] args) {
        People people = new Student();
        InvocationHandler handler = new WorkHandler(people);

        People proxy = (People) Proxy.newProxyInstance(people.getClass().getClassLoader(), people.getClass().getInterfaces(), handler);
        People p = proxy.work("写代码");

        System.out.println();

        System.out.println("打印返回的对象");
        System.out.println(p.getClass());

        System.out.println();

        String time = proxy.time();
        System.out.println(time);



    }

}
