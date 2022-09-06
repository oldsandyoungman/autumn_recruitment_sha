package com.shasha.oppo;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author ShaLuwei
 * @create 2022-09-02 19:24
 */
public class ma1 {

    public static void main(String[] args) {

//        StringBuilder sb = new StringBuilder("123");
//        System.out.println(sb.reverse().toString());

        ArrayList<ArrayList<Integer>> s = new ArrayList<>();
        ArrayList<Integer> s1 = new ArrayList<>();
        s1.add(1234);
        s1.add(1235);
        ArrayList<Integer> s2 = new ArrayList<>();
        s2.add(1236);
        s2.add(1238);
        s.add(s1);
        s.add(s2);

//        ArrayList<ArrayList<Integer>> s = new ArrayList<>();
//        ArrayList<Integer> s1 = new ArrayList<>();
//        s1.add(1234);
//        s1.add(1240);
//        ArrayList<Integer> s2 = new ArrayList<>();
//        s2.add(1236);
//        s2.add(1238);
//        s2.add(1245);
//        s2.add(1250);
//        s.add(s1);
//        s.add(s2);

        System.out.println(getRes(s));




    }

    public static ArrayList<Integer> getRes(ArrayList<ArrayList<Integer>> wakeLock){

        int n = 0;
        for (ArrayList<Integer> integers : wakeLock) {
            n += integers.size()/2;
        }
        int[] begin = new int[n];
        int[] end = new int[n];
        int[] all = new int[2*n];

        int index = 0;
        int index2 = 0;
        for (ArrayList<Integer> integers : wakeLock) {
            for (int i = 0; i < integers.size(); i+=2) {
                begin[index] = integers.get(i);
                end[index] = integers.get(i+1);
                all[index2++] = integers.get(i);
                all[index2++] = integers.get(i+1);
                index++;
            }
        }

//        System.out.println("111111");

        Arrays.sort(begin);
        Arrays.sort(end);
        Arrays.sort(all);

        int[] val = new int[2*n-1];
        int index3 = 0;

        // 扫描过程中的计数器
        int count = 0;
        // 双指针技巧
        int i = 0, j = 0;
        while (i < n && j < n) {
            if (begin[i] < end[j]) {
                // 扫描到一个红点
                count++;

                val[index3++] = count;

                i++;
            } else {
                // 扫描到一个绿点
                count--;

                val[index3++] = count;

                j++;
            }
        }

//        System.out.println("111111");

        ArrayList<Integer> result = new ArrayList<>();

        for (ArrayList<Integer> intvs : wakeLock) {
            int nn = intvs.size();

            int tmp = 0;

            for(int k=0; k<nn; k+=2){

                int[] target = new int[2];
                target[0] = intvs.get(k);
                target[1] = intvs.get(k+1);

                int[] res_index = new int[2];

                for (int l = 0; l < 2; l++) {
                    int left = 0;
                    int right = 2*n - 1;
                    while(left<=right){
                        int mid = left + (right-left)/2;
                        if(all[mid]>target[l]){
                            right = mid - 1;
                        }else if(all[mid]<target[l]){
                            left = mid + 1;
                        }else{
                            res_index[l] = mid;
                            break;
                        }
                    }
                }

//                int index1 = res_index[0];
//                int index2 = res_index[1];



                for(int m=res_index[0]; m<res_index[1]; m++){

                    tmp += (all[m+1]-all[m])/val[m];

                }



            }

            result.add(tmp);



        }

        return result;


    }



}
