package com.shasha.Huatai;

import java.util.*;

/**
 * @author ShaLuwei
 * @create 2022-08-28 22:25
 */
public class sha1 {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int test_num = 0;

        int from = sc.nextInt();
        int to = sc.nextInt();
        while(from!=-1 && to!=-1){
            test_num++;
            HashMap<Integer, List<Integer>> relations = new HashMap<>();
            HashMap<Integer, Integer> count_in = new HashMap<>();
            HashSet<Integer> s = new HashSet<>();
            boolean flag0 = true;
            while(from!=0 && to!=0){
                if(from==to){
                    flag0 = false;
                }
                relations.putIfAbsent(from, new ArrayList<>());
                relations.get(from).add(to);
                count_in.put(to, count_in.getOrDefault(to, 0)+1);
                s.add(from);
                s.add(to);

                from = sc.nextInt();
                to = sc.nextInt();
            }

            // 是否有自连
            if(!flag0){
                System.out.println("Case " + test_num + " is not a tree.");
                from = sc.nextInt();
                to = sc.nextInt();
                continue;
            }

            // 是否有根节点
            int root = -1;
            boolean flag1 = true;
            for(int cur : relations.keySet()){
                if(!count_in.containsKey(cur)){
                    if(root==-1){
                        root = cur;
                    }else{
                        flag1 = false;
                        break;
                    }
                }
            }
            if(!flag1 || root==-1){
                System.out.println("Case " + test_num + " is not a tree.");
                from = sc.nextInt();
                to = sc.nextInt();
                continue;
            }

            // 是否入度大于等于2
            boolean flag = true;
            for(int cur : count_in.keySet()){
                if(count_in.get(cur)>=2){
                    flag = false;
                    break;
                }
            }
            if(!flag){
                System.out.println("Case " + test_num + " is not a tree.");
                from = sc.nextInt();
                to = sc.nextInt();
                continue;
            }

            // 是否全部遍历到
            int visited_count = 1;
            int target = s.size();
            ArrayDeque<Integer> q = new ArrayDeque<>();
            q.add(root);
            while(!q.isEmpty()){
                int cur = q.removeFirst();
                visited_count++;
                if(!relations.containsKey(cur)){
                    continue;
                }
                for(int nxt : relations.get(cur)){
                    q.addLast(nxt);
                }
            }

            if(visited_count==target){
                System.out.println("Case " + test_num + " is not a tree.");
                from = sc.nextInt();
                to = sc.nextInt();
            }else{
                System.out.println("Case " + test_num + " is a tree.");
                from = sc.nextInt();
                to = sc.nextInt();
            }

        }

    }


}