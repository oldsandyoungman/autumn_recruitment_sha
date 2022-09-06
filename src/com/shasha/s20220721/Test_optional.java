package com.shasha.s20220721;

import java.util.Optional;

/**
 * @author ShaLuwei
 * @create 2022-07-21 19:28
 */
public class Test_optional {

    public static void main(String[] args) {
        String s = null;
        Optional<String> s1 = Optional.ofNullable(s);
        String s2 = s1.orElse(new String("345"));

        System.out.println(s2);

    }

}
