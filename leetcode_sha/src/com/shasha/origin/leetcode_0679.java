package com.shasha.origin;

import org.junit.Test;

import java.util.ArrayList;

/**
 * @author ShaLuwei
 * @create 2022-07-29 19:29
 */
public class leetcode_0679 {

    public static void main(String[] args) {

    }

    @Test
    public void test(){
        int[] cards = {4, 1, 8, 7};
        System.out.println(judgePoint24(cards));
    }

    public boolean judgePoint24(int[] cards) {
        res = false;
        ArrayList<Double> can = new ArrayList<>();

        can.add((double)cards[0]);
        can.add((double)cards[1]);
        can.add((double)cards[2]);
        can.add((double)cards[3]);

        backtrack(can);

        return res;

    }

    public boolean res;

    public void backtrack(ArrayList<Double> can){
        if(res){
            return;
        }

        if(can.size()==1){
            if(can.get(0) - 24.0 < 0.0000001){
//            if(can.get(0).equals(24.0)){
                res = true;
                return;
            }
        }

        // 实时变化的候选列表
        ArrayList<Double> tmp = new ArrayList<>(can);

        for(int i=0; i<can.size(); i++){
            for(int j=0; j<can.size(); j++){

                if(i!=j){

                    double num1 = tmp.get(i);
                    double num2 = tmp.get(j);

                    if(i>j){
                        tmp.remove(i);
                        tmp.remove(j);
                    }else{
                        tmp.remove(j);
                        tmp.remove(i);
                    }

                    double cur;

                    // 加法
                    cur = num1 + num2;
                    tmp.add(cur);
                    backtrack(tmp);
                    if(res){
                        return;
                    }
                    tmp.remove(tmp.size()-1);

                    // 减法
                    cur = num1 - num2;
                    tmp.add(cur);
                    backtrack(tmp);
                    if(res){
                        return;
                    }
                    tmp.remove(tmp.size()-1);

                    // 乘法
                    cur = num1 * num2;
                    tmp.add(cur);
                    backtrack(tmp);
                    if(res){
                        return;
                    }
                    tmp.remove(tmp.size()-1);

                    // 除法
                    cur = num1 / num2;
                    tmp.add(cur);
                    backtrack(tmp);
                    if(res){
                        return;
                    }
                    tmp.remove(tmp.size()-1);

                    tmp = new ArrayList<>(can);

                }






            }
        }

    }

}