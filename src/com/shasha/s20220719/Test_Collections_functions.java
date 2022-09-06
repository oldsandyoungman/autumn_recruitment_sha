package com.shasha.s20220719;

import java.util.*;

/**
 * @author ShaLuwei
 * @create 2022-07-19 21:31
 */
public class Test_Collections_functions {

    public static void main(String[] args) {

        ArrayList<Integer> l = new ArrayList<>();
        l.add(1);
        l.add(5);
        l.add(2);
        l.add(4);
        l.add(3);

        Collections.sort(l, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o2, o1);
            }
        });

        System.out.println(l);


        Integer[] nums = {1,5,2,4,3};
        Arrays.sort(nums, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o2, o1);
            }
        });

        System.out.println(Arrays.toString(nums));


        List l2 = Arrays.asList(new Object[l.size()]);
        Collections.copy(l2, l);
        System.out.println(l2);

        List<Integer> integers = Collections.synchronizedList(l);


    }

}
