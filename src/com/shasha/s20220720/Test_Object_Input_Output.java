package com.shasha.s20220720;

import java.io.*;

/**
 * @author ShaLuwei
 * @create 2022-07-20 16:18
 */
public class Test_Object_Input_Output {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("hello.txt"));

        oos.writeObject(new Sha("沙1"));
        oos.flush();
        oos.writeObject(new Sha("沙2"));
        oos.flush();
        oos.writeObject(new Sha("沙3"));
        oos.flush();

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("hello.txt"));

        Object o1 = ois.readObject();
        System.out.println(o1);
        Object o2 = ois.readObject();
        System.out.println(o2);
        Object o3 = ois.readObject();
        System.out.println(o3);


    }

}

class Sha implements Serializable {

    public static final long serialVersionUID = 4212412412414131L;

    String name;

    public Sha(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Sha{" +
                "name='" + name + '\'' +
                '}';
    }
}