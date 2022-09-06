package com.shasha.s20220721;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * @author ShaLuwei
 * @create 2022-07-21 16:47
 */
public class Test_4_functional_interface {

    @Test
    public void test(){

        List<String> l = Arrays.asList("123","45","67","890");

        List<String> res = filterString(l, new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.contains("3");
            }
        });

        System.out.println(res);

        List<String> res2 = filterString(l, o -> o.contains("3"));

        System.out.println(res2);


    }

    public List<String> filterString(List<String> list, Predicate<String> pre){
        ArrayList<String> res = new ArrayList<>();
        for (String s : list) {
            if(pre.test(s)){
                res.add(s);
            }
        }
        return res;
    }


    @Test
    public void test2(){
        Predicate<String> predicate = new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.contains("3");
            }
        };
    }


}
