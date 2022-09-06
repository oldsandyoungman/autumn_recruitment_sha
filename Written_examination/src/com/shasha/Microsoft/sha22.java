package com.shasha.Microsoft;

import org.junit.Test;

import java.util.HashMap;

/**
 * @author ShaLuwei
 * @create 2022-08-13 10:35
 */
public class sha22 {

    @Test
    public void test() {
        int[] x = {1,1,2};
        int[] y = {3,2,3};

//        int[] x = {1,1,1};
//        int[] y = {2,2,2};

//        int[] x = {1,2,3,1,2,12,8,4};
//        int[] y = {5,10,15,2,4,15,10,5};

        System.out.println(solution(x, y));
    }

//    public int solution(int[] X, int[] Y){
//        int n = X.length;
//
//        HashMap<String, Integer> m = new HashMap<>();
//
//        int sum = 0;
//
//        for(int i=0; i<n; i++){
//            int son = X[i];
//            int father = Y[i];
//            if(father<son){
//                continue;
//            }
//            int other = father - son;
//            int tmp = gcd(other, father);
//            father /= tmp;
//            other /= tmp;
//            son /= tmp;
//            String key = other + "," + father;
//            sum += m.getOrDefault(key,0);
//
//            String key2 = son + "," + father;
//            m.put(key2, m.getOrDefault(key2, 0)+1);
//        }
//
//        return sum;
//
//    }
//
//    private int gcd(int b, int a) {
//        int rem = 0;
//        while (b != 0) {
//            rem= a % b;
//            a = b;
//            b = rem;
//        }
//        return a;
//    }

    public int solution(int[] X, int[] Y) {
        // write your code in Java 8 (Java SE 8)
        int n = X.length;
        HashMap<String, Integer> m = new HashMap<>();
        long sum = 0;
        for(int i=0; i<n; i++){
            int son = X[i];
            int father = Y[i];
            int tmp = gcd(father, son);
            father /= tmp;
            son /= tmp;
            int other = father - son;
            String o = other + "," + father;
            String s = son + "," + father;

            if(m.containsKey(o)){
                sum = (sum + m.get(o))%(1000000007);
            }

            m.put(s, m.getOrDefault(s, 0)+1);

        }

        return (int)sum;



    }

    public int gcd(int a, int b){
        while(b!=0){
            int tmp = a%b;
            a = b;
            b = tmp;
        }
        return a;
    }


}
