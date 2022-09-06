package com.shasha.zoom;

import java.util.*;

/**
 * @author ShaLuwei
 * @create 2022-08-10 20:59
 */
public class sha2 {

    /*
5
1 alice 2
zoom apple
2 bob
2 alice
1 bob 2
apple micro
2 bob

     */

    public static void main(String[] args) {

//        short shasha = 1;

        Scanner sc = new Scanner(System.in);

        UF uf = new UF(1000);

        int index = 0;
        HashMap<String, Integer> memo = new HashMap<>();
        HashMap<String, List<Integer>> person_company = new HashMap<>();

        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {

            String tmp = sc.nextLine();

            String[] tt = tmp.split(" ");
            if(tt[0].equals("1")){

                String person = tt[1];

                String tmp2 = sc.nextLine();
                String[] tt2 = tmp2.split(" ");
                String start = tt2[0];

                if(!memo.containsKey(start)){
                    memo.put(start, index);
                    index++;
                }

                int start_index = memo.get(start);
                person_company.putIfAbsent(person, new ArrayList<>());
                person_company.get(person).add(start_index);
                for (int i1 = 1; i1 < tt2.length; i1++) {
                    if(!memo.containsKey(tt2[i1])){
                        memo.put(tt2[i1], index);
                        uf.union(start_index, index);
                        index++;
                    }
                    person_company.get(person).add(memo.get(tt2[i1]));
                }

            }else{

                String person = tt[1];
                if(person_company.containsKey(person)){
                    int ii = person_company.get(person).get(0);
                    int root = uf.find(ii);
                    int res = uf.sz[root];
                    System.out.println(res - person_company.get(person).size());
                }else{
                    System.out.println("error");
                }

            }
        }
    }
}


class UF {

    int[] parent;
    public int[] sz;
    int count;

    public UF(int n){

        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        sz = new int[n];
        Arrays.fill(sz, 1);
        count = n;

    }

    public int find(int i){
        if(parent[i]!=i){
            parent[i] = find(parent[i]);
        }
        return parent[i];
    }

    public void union(int i, int j){
        int rooti = find(i);
        int rootj = find(j);
        if(rooti==rootj){
            return;
        }
        if(sz[rooti]>sz[rootj]){
            parent[rootj] = rooti;
            sz[rooti] += sz[rootj];
        }else{
            parent[rooti] = rootj;
            sz[rootj] += sz[rooti];
        }
        count--;
    }

    public boolean connected(int i, int j){
        int rooti = find(i);
        int rootj = find(j);
        return rooti==rootj;
    }

    public int getCount(){
        return count;
    }


}



