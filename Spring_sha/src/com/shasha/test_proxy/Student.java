package com.shasha.test_proxy;

/**
 * @author ShaLuwei
 * @create 2022-08-29 12:56
 */
public class Student implements People{

    @Override
    public People work(String workName) {
        System.out.println("工作内容是"+workName);
        return this;
    }
    @Override
    public String time() {
        return "2018-06-12";
    }
}
