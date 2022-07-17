package com.shasha.s20220714;

public class Test_inner_class {

    public static void main(String[] args) {

        Person.Dog d = new Person.Dog();
        d.show();

        Person p = new Person();
        Person.Bird b = p.new Bird();
        b.sing();

        b.display("33");

    }

}

class Person{

    String name = "11";

    public void eat(){
        System.out.println("吃吃吃");
    }

    static class Dog{

        public void show(){
            System.out.println("是修狗");
        }

    }

    class Bird{

        public String name = "22";

        public Bird(){

        }

        public void sing(){
            System.out.println("叽叽喳喳");
            Person.this.eat();
        }

        public void display(String name){
            System.out.println(name);
            System.out.println(this.name);
            System.out.println(Person.this.name);
        }

    }




}
