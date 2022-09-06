package com.shasha.s20220721;

import java.lang.reflect.Method;

/**
 * @author ShaLuwei
 * @create 2022-07-21 13:30
 */
public class Test_reflect {

    public static void main(String[] args) throws Exception {

        Class<?> clazz = Class.forName("com.shasha.s20220721.Person");

        Person person = (Person) clazz.newInstance();

        Method show = clazz.getMethod("show");
        show.setAccessible(true);
        Object res = show.invoke(person);
        System.out.println(res);

        Method sayHello = clazz.getMethod("sayHello", String.class);
        sayHello.setAccessible(true);
        sayHello.invoke(person, "yes");

        Method yep = clazz.getMethod("yep");
        yep.setAccessible(true);
        // 静态方法，调用方法1
        yep.invoke(null);
        // 静态方法，调用方法2
        yep.invoke(clazz);

    }

}

class Person{

    public String show(){
        return "123";
    }

    public void sayHello(String name){
        System.out.println(name);
    }

    public static void yep(){

    }

}
