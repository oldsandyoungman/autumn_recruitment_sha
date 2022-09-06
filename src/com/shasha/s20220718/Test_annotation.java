package com.shasha.s20220718;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ShaLuwei
 * @create 2022-07-18 20:53
 */


public class Test_annotation {
    // 可重复注解写法二
    @MyAnnotation("123")
    @MyAnnotation("456")
    // 可重复注解写法一
//    @MyAnnotations({@MyAnnotation("123"), @MyAnnotation("456")})
    public static void main(String[] args) {


        List<int[]> ints = Arrays.asList(new int[]{123, 456});
        System.out.println(ints.size()); // 1
        List<Integer> integers = Arrays.asList(123, 456);
        System.out.println(integers.size()); // 2

    }

}



class Generic_sha<@MyAnnotation("789") T>{

    public void show() throws @MyAnnotation("321") RuntimeException{
        ArrayList<@MyAnnotation("654") String> l = new ArrayList<>();
        int nums = (@MyAnnotation("987") int) 313L;
    }



}