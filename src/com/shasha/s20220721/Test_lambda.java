package com.shasha.s20220721;

import java.util.Comparator;

/**
 * @author ShaLuwei
 * @create 2022-07-21 16:12
 */
public class Test_lambda {

    public static void main(String[] args) {

        Comparator<Integer> comparator1 = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1, o2);
            }
        };

        int res1 = comparator1.compare(1,2);
        System.out.println(res1);

        System.out.println("*********************");

        Comparator<Integer> comparator2 = ((o1, o2) -> Integer.compare(o1, o2));
        int res2 = comparator2.compare(1,2);
        System.out.println(res2);

        System.out.println("*********************");

        Comparator<Integer> comparator3 = Integer ::compare;
        int res3 = comparator3.compare(1,2);
        System.out.println(res3);





    }

}
