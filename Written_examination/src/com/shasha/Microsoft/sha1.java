package com.shasha.Microsoft;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author ShaLuwei
 * @create 2022-08-06 08:58
 */
public class sha1 {

    @Test
    public void test(){
        String s = "...xxx..x....xxx";
        int B = 7;
        System.out.println(solution(s,B));
    }

    public int solution(String S, int B) {
        // write your code in Java 8 (Java SE 8)
        char[] ss = S.toCharArray();
        int n = ss.length;

        int[] memo = new int[n];
        int left = 0;
        int i = 0;
        int j = 0;

        while(i<n){
            if(ss[i]=='x'){
                left = i;
                i++;
                while(i<n && ss[i]=='x'){
                    i++;
                }
                memo[j++] = i - left;
            }

            i++;

        }

        if(j==0){
            return 0;
        }

        int[] memo2 = Arrays.copyOf(memo, j);

        Arrays.sort(memo2);

        int res = 0;

        for(int k=j-1; k>=0; k--){
            int need = memo2[k]+1;
            if(B>=need){
                res += memo2[k];
                B -= need;
            }else if(B>=2){
                res += B-1;
                break;
            }
        }

        return res;

    }

//    int M, N;            //M, N分别表示左、右侧集合的元素数量
//    int[MAXM][MAXN] Map; //邻接矩阵存图
//    int[MAXN] p;         //记录当前右侧元素所对应的左侧元素
//    boolean[MAXN] vis;      //记录右侧元素是否已被访问过
//    boolean match(int i) {
//        for (int j = 1; j <= N; ++j)
//            if (Map[i][j] && !vis[j]) //有边且未访问
//            {
//                vis[j] = true;                 //记录状态为访问过
//                if (p[j] == 0 || match(p[j])) //如果暂无匹配，或者原来匹配的左侧元素可以找到新的匹配
//                {
//                    p[j] = i;    //当前左侧元素成为当前右侧元素的新匹配
//                    return true; //返回匹配成功
//                }
//            }
//        return false; //循环结束，仍未找到匹配，返回匹配失败
//    }
//    int Hungarian()
//    {
//        int cnt = 0;
//        for (int i = 1; i <= M; ++i)
//        {
//            memset(vis, 0, sizeof(vis)); //重置vis数组
//            if (match(i))
//                cnt++;
//        }
//        return cnt;
//    }

}
