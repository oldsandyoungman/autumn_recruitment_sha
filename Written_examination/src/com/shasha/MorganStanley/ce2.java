package com.shasha.MorganStanley;

import org.junit.Test;

import java.util.ArrayDeque;

/**
 * @author ShaLuwei
 * @create 2022-08-26 21:11
 */
public class ce2 {


    @Test
    public void test(){

        int x1 = 1;
        int y1 = 4;
        int x2 = 5;
        int y2 = 9;

        System.out.println(isAvailable(x1,y1,x2,y2));

    }


    public boolean isAvailable(int x1, int y1, int x2, int y2){

        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.addLast(new int[]{x1, y1});

        while (!q.isEmpty()){

            int[] cur = q.removeFirst();

            if(cur[0]==x2 && cur[1]==y2){
                return true;
            }

            // 右走
            int next1_x = cur[0] + cur[1];
            int next1_y = cur[1];

            if(next1_x<=x2 && next1_y<=y2){
                q.addLast(new int[]{next1_x, next1_y});
            }

            // 上走
            int next2_x = cur[0];
            int next2_y = cur[1] + cur[0];

            if(next2_x<=x2 && next2_y<=y2){
                q.addLast(new int[]{next2_x, next2_y});
            }

        }

        return false;

    }

}
