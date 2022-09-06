package com.shasha.s20220719;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * @author ShaLuwei
 * @create 2022-07-19 11:23
 */
public class Test_TreeSet {

    public static void main(String[] args) {
        Comparator comparator = new Comparator(){
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof Stu && o2 instanceof Stu){
                    Stu stu1 = (Stu) o1;
                    Stu stu2 = (Stu) o2;
                    return Integer.compare(stu1.age, stu2.age);
                }
                throw new RuntimeException();
            }
        };

        TreeSet t = new TreeSet(comparator);

        t.add(new Stu(1));
        t.add(new Stu(5));
        t.add(new Stu(2));
        t.add(new Stu(4));
        t.add(new Stu(3));

        for (Object o : t) {
            System.out.println(o);
        }


    }
}

class Stu {
    int age;
    public Stu(int age){
        this.age = age;
    }

    @Override
    public String toString() {
        return "Stu{" +
                "age=" + age +
                '}';
    }
}
