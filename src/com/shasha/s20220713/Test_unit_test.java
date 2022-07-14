package com.shasha.s20220713;

import org.hamcrest.Condition;
import org.junit.Test;

public class Test_unit_test {

    @Test
    public void test_equals(){
        String a = "AA";
        String b = "AA";
        String c = new String("AA");

        System.out.println(a==b);
        System.out.println(c==b);


    }




}
