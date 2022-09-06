package Huawei;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author ShaLuwei
 * @create 2022-08-15 15:33
 */
public class ma1 {

    /*
    没找到原题，

    就每个花色排序，开始连续计数，连续计数到5个就true

    nlogn + n = O(nlogn)

    不知道，想不出来，。。。。。。。给点提示。。。。。。。。

    先别写，跟他交流思路，让他给点提示


    桶排序我不会233

    ok了，两个例子都跑过，应该没啥问题




     */

    @Test
    public void test(){
        List<String> cards = new ArrayList<>();
//        cards.add("HA");
//        cards.add("S2");
//        cards.add("D3");
//        cards.add("C4");
//        cards.add("C8");
//        cards.add("H5");

        cards.add("D2");
        cards.add("D4");
        cards.add("D3");
        cards.add("C8");
        cards.add("D5");
        cards.add("D6");

//        System.out.println(getRes(cards));
//        System.out.println(getRes2(cards));
        System.out.println(getRes3(cards));
    }

    public boolean getRes(List<String> cards){

        PriorityQueue<Integer>[] queues = new PriorityQueue[4];
        for (int i = 0; i < queues.length; i++) {
            queues[i] = new PriorityQueue<>();
        }

        for (String card : cards) {
            char kind = card.charAt(0);
            int num = parseNum(card.charAt(1));
            switch (kind){
                case 'H':
                    queues[0].add(num);
                    break;
                case 'S':
                    queues[1].add(num);
                    break;
                case 'D':
                    queues[2].add(num);
                    break;
                case 'C':
                    queues[3].add(num);
                    break;
            }
        }

        for (int i = 0; i < 4; i++) {

            // 下一个数应该是几
            int nxt_res = -1;
            // 当前已经连续统计了几个数
            int count = 0;

            while(!queues[i].isEmpty()){
                int num = queues[i].poll();
                // 如果是刚开始
                if(nxt_res==-1){
                    nxt_res = num+1;
                    count = 1;
                }else{
                    // 如果当前数和前面连续
                    if(num==nxt_res){
                        count++;
                        nxt_res = num+1;
                        if(count==5){
                            return true;
                        }
                    }else{
                        // 如果不连续，重新开始计数
                        nxt_res = num+1;
                        count = 1;
                    }
                }
            }
        }

        return false;

    }

    public boolean getRes2(List<String> cards){

        boolean[][] memo = new boolean[4][13];

        for (String card : cards) {
            char kind = card.charAt(0);
            int num = parseNum(card.charAt(1)) - 1;
            switch (kind){
                case 'H':
                    memo[0][num] = true;
                    break;
                case 'S':
                    memo[1][num] = true;
                    break;
                case 'D':
                    memo[2][num] = true;
                    break;
                case 'C':
                    memo[3][num] = true;
                    break;
            }
        }

        for (int j = 0; j < 4; j++) {
            int count = 0;
            for (int i = 0; i < 17; i++) {
                if(memo[j][i%13]){
                    count++;
                    if(count==5){
                        return true;
                    }
                }else{
                    count = 0;
                }
            }
        }

        return false;

    }

    public boolean getRes3(List<String> cards){

//        boolean[][] memo = new boolean[4][13];

        HashSet<Integer>[] memo = new HashSet[4];
        for (int i = 0; i < 4; i++) {
            memo[i] = new HashSet<>();
        }

        for (String card : cards) {
            char kind = card.charAt(0);
            int num = parseNum(card.charAt(1)) - 1;
            switch (kind){
                case 'H':
                    memo[0].add(num);
                    break;
                case 'S':
                    memo[1].add(num);
                    break;
                case 'D':
                    memo[2].add(num);
                    break;
                case 'C':
                    memo[3].add(num);
                    break;
            }
        }

        for (int j = 0; j < 4; j++) {
            int count = 0;
            for (int i = 0; i < 17; i++) {
                if(memo[j].contains(i%13)){
                    count++;
                    if(count==5){
                        return true;
                    }
                }else{
                    count = 0;
                }
            }
        }

        return false;

    }



    public int parseNum(char c){
        if(c=='A'){
            return 1;
        }
        if(c=='J'){
            return 11;
        }
        if(c=='Q'){
            return 12;
        }
        if(c=='K'){
            return 13;
        }
        if(c=='1'){
            return 10;
        }
        return c-'0';
    }



}
