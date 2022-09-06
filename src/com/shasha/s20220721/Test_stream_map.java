package com.shasha.s20220721;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author ShaLuwei
 * @create 2022-07-21 18:39
 */
public class Test_stream_map {

    public static void main(String[] args) {
        Man m1 = new Man("1");
        Man m2 = new Man("2");
        Man m3 = new Man("3");
        Man m4 = new Man("4");
        Man m5 = new Man("5");
        Man m6 = new Man("6");
        Man m7 = new Man("7");
        List<Man> l = Arrays.asList(m1,m2,m3,m4,m5,m6,m7);

        Stream<Man> stream = l.stream();

        stream.map(Man::getName).forEach(System.out::println);


        List<String> l2 = Arrays.asList("aa","bb","cc","dd","ee");
        Stream<Stream<Character>> streamStream = l2.stream().map(Test_stream_map::string2stream);
        streamStream.forEach(s -> {
            s.forEach(System.out::println);
        });

        System.out.println();

        Stream<Character> characterStream = l2.stream().flatMap(Test_stream_map::string2stream);
        characterStream.forEach(System.out::println);


    }

    public static Stream<Character> string2stream(String s){
        ArrayList<Character> l = new ArrayList<>();
        for (char c : s.toCharArray()) {
            l.add(c);
        }
        return l.stream();
    }


}

class Man{
    public String name;

    public Man(String name) {
        this.name = name;
    }

    public String getName(){
        return name;
    }
}
