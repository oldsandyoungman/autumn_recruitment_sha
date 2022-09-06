package com.shasha.s20220720;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ShaLuwei
 * @create 2022-07-20 10:03
 */
public class Test_wildcard {

    public static void main(String[] args) {

        List<? extends Person> l1 = null;
        List<? super Person> l2 = null;

        List<Object> l3 = new ArrayList<>();
        List<Person> l4 = new ArrayList<>();
        List<Student> l5 = new ArrayList<>();


//        l1 = l3; // 报错
        l1 = l4;
        l1 = l5;

        l2 = l3;
        l2 = l4;
//        l2 = l5; // 报错

//        l1.add(new Student()); // 报错，还是只能传null
//        l1.add(new Person()); // 报错，还是只能传null
        l2.add(new Person());
        l2.add(new Student());


    }

}
class Person{

}

class Student extends Person{

}
