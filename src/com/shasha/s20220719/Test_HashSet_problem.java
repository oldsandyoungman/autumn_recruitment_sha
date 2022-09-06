package com.shasha.s20220719;

import org.junit.Test;

import java.util.HashSet;
import java.util.Objects;

/**
 * @author ShaLuwei
 * @create 2022-07-19 12:32
 */
public class Test_HashSet_problem {

    @Test
    public void test(){

        HashSet s = new HashSet();
        Person p1 = new Person(1001,"AA");
        Person p2 = new Person(1002,"BB");

        s.add(p1);
        s.add(p2);
        System.out.println(s); // 2个
        System.out.println("********************");

        p1.name = "CC";
        s.remove(p1);// 先算hashCode，发现对应数组位置上没有内容，所以觉得要删的对象不存在
        System.out.println(s); // 2个
        System.out.println("********************");

        s.add(new Person(1001, "CC")); // 同样计算hashCode，发现对应数组位置上没有内容，所以直接加
        System.out.println(s); // 3个
        System.out.println("********************");

        s.add(new Person(1001, "AA")); // 同样计算hashCode，发现对应数组位置上有内容Person(1001, "CC")，再equals运算，发现不一样，添加
        System.out.println(s); // 4个
        System.out.println("********************");



    }

}


class Person{

    int id;
    String name;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return id == person.id && Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
