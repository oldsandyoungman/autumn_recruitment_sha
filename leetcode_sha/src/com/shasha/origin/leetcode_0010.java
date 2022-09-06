package com.shasha.origin;

import org.junit.Test;

/**
 * @author ShaLuwei
 * @create 2022-08-22 14:07
 */
public class leetcode_0010 {

    @Test
    public void test(){

        String s = "aab";
        String p = "c*a*b";
        System.out.println(isMatch(s,p));

    }

    public boolean isMatch(String s, String p) {
        char[] ss = s.toCharArray();
        char[] pp = p.toCharArray();
        int m = ss.length;
        int n = ss.length;
        // 多创建，并不是ss[0]对应memo[1]，而是memo[m]也得记录，进一步减少时间
        memo = new int[m+1][n+1];

        return dp(ss,0,pp,0);

    }

    // 0: 没遍历过；
    // 1: true;
    // -1: false

    int[][] memo;

    // dfs(i, j): ss[i...] pp[j...]是否能匹配
    public boolean dp(char[] ss, int i, char[] pp, int j){

        if(j>=pp.length){
            if(i==ss.length){
                memo[i][j] = 1;
                return true;
            }
            memo[i][j] = -1;
            return false;
        }

        int memo_val = memo[i][j];
        if(memo_val!=0){
            return memo_val==1?true:false;
        }

        if(i==ss.length){
            if((pp.length-j)%2==1){
                memo[i][j] = -1;
                return false;
            }
            for(int k=j; k<pp.length; k+=2){
                if(pp[k+1]!='*'){
                    memo[i][j] = -1;
                    return false;
                }
            }
            memo[i][j] = 1;
            return true;
        }

        if(ss[i]==pp[j] || pp[j]=='.'){
            if(j<pp.length-1 && pp[j+1]=='*'){
                boolean val = dp(ss,i,pp,j+2) || dp(ss,i+1,pp,j);
                memo[i][j] = val?1:-1;
                return val;
            }else{
                boolean val = dp(ss,i+1,pp,j+1);
                memo[i][j] = val?1:-1;
                return val;
            }
        }else{
            if(j<pp.length-1 && pp[j+1]=='*'){
                boolean val = dp(ss,i,pp,j+2);
                memo[i][j] = val?1:-1;
                return val;
            }else{
                memo[i][j] = -1;
                return false;
            }

        }

    }

}
