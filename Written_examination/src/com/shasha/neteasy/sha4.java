package com.shasha.neteasy;

import org.junit.Test;

import java.util.*;

/**
 * @author ShaLuwei
 * @create 2022-09-04 16:17
 */

/*
3
1 2 3
1 2
1 3
 */
public class sha4 {

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

//         memo = getSu(100001); // 有 9592 个素数

        mm = new HashMap<>();

        graph = new ArrayList[n+1];
        for(int i=1; i<=n; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i=0; i<n; i++){
            int num = sc.nextInt();
            int[] count = getCount(num);
            Node_sha cur = new Node_sha(count);
            mm.put(i+1, cur);
        }

        for(int i=0; i<n-1; i++){
            int node1 = sc.nextInt();
            int node2 = sc.nextInt();
            graph[node1].add(node2);
            graph[node2].add(node1);
        }

        res = 0;
        visited = new boolean[n+1];
        dfs(1);

        System.out.println(res);

    }

    static HashMap<Integer, Node_sha> mm;
    static long res;
    static List<Integer>[] graph;
    static boolean[] visited;

    public static int[] dfs(int cur){
        boolean isTail = true;
        for(int nxt : graph[cur]){
            if(!visited[nxt]){
                isTail = false;
                break;
            }
        }
        if(isTail){
            int[] sum = mm.get(cur).count;
            res += getMul(sum);
            return sum;
        }

        visited[cur] = true;

        Node_sha cur_node = mm.get(cur);
        int[] sum = cur_node.count;

        for(int nxt : graph[cur]){
            if(!visited[nxt]){
                int[] nxt_count = dfs(nxt);
                getSum(sum, nxt_count);
            }
        }

        res += getMul(sum);

        res = res % (1000000007);

        return sum;

    }

    public static long getMul(int[] sum){
        int incre = 1;
        for(int i=2; i<=100000; i++){
            incre *= (1+sum[i]);
        }
        incre = incre % (1000000007);
        return incre;
    }

    public static void getSum(int[] a, int[] b){
        for(int i=2; i<=100000; i++){
            a[i] += b[i];
        }
    }

    public static ArrayList<Integer> getSu(int n){

        boolean[] isPrime = new boolean[n];
        ArrayList<Integer> res = new ArrayList<>();
        int count = 0;
        for(int i=2; i<n; i++){
            if(!isPrime[i]){
                count++;
                res.add(i);
                for(int j=2*i; j<n; j+=i){
                    isPrime[j] = true;
                }
            }
        }
        return res;
    }

    public static ArrayList<Integer> memo;

    public static int[] getCount(int n){
        int[] count = new int[100001];
        int target = (int)Math.sqrt(n);
        for(int i=2; i<=target; i++){
            while(n%i==0){
                n /= i;
                count[i]++;
            }
        }
        if(n>1){
            count[n]++;
        }

        return count;
    }

    public void printSS(int n) {
        int target = (int)Math.sqrt(n);
        for(int i=2; i<=target; i++){
            while(n%i==0){
                n /= i;
                System.out.print(i+" ");
            }
        }
        if(n>1){
            System.out.print(n);
        }
        System.out.println();

    }

    @Test
    public void test(){
//        System.out.println(Arrays.toString(getCount(2)));
//        System.out.println(Arrays.toString(getCount(3)));
//        System.out.println(Arrays.toString(getCount(4)));
//        System.out.println(Arrays.toString(getCount(7)));

        printSS(2);
        printSS(3);
        printSS(4);
        printSS(5);
    }


}


class Node_sha{

    public int[] count;

    public Node_sha(int[] count){
        this.count = count;
    }


}
