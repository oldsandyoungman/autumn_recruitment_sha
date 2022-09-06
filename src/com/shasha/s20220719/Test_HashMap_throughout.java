package com.shasha.s20220719;

import java.util.*;

/**
 * @author ShaLuwei
 * @create 2022-07-19 21:02
 */
public class Test_HashMap_throughout {

    public static void main(String[] args) {
        HashMap m = new HashMap();

        m.put("123", 111);
        m.put("456", 222);
        m.put("789", 333);
        m.put("000", 444);

        Set set = m.keySet();
        Iterator iterator = set.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println();

        Collection values = m.values();
        Iterator iterator1 = values.iterator();
        while(iterator1.hasNext()){
            System.out.println(iterator1.next());
        }
        System.out.println();

        Set set1 = m.entrySet();
        Iterator iterator2 = set1.iterator();
        while(iterator2.hasNext()){
            Object tmp = iterator2.next();
            Map.Entry e = (Map.Entry)tmp;
            System.out.println(e + " , " + e.getKey() + " , " + e.getValue());
        }


    }

}
