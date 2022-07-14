package com.shasha.s20220712;

public class Test_person_student {

    public static void main(String[] args) {
        Student s = new Student();

        // 正常的覆盖：显示"Student eat"
        s.eat();
        // 没有覆盖：显示"Person walk"
        s.person_test();

    }

}

class Person {

    public void eat() throws Exception{
        System.out.println("Person eat");
    }

    private void walk(){
        System.out.println("Person walk");
    }

    public void person_test(){
        walk();
    }

}

class Student extends Person{

    public void eat() throws RuntimeException{
        System.out.println("Student eat");
    }

    private void walk(){
        System.out.println("Student walk");
    }

}

