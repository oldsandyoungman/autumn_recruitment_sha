package com.shasha.s20220716;

import java.util.PriorityQueue;

/**
 * @author ShaLuwei
 * @create 2022-07-16 16:09
 */
public class Test_leetcode_23 {
}


class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dum = new ListNode(0);

        PriorityQueue<ListNode> pq = new PriorityQueue<>((o1, o2) -> {
            return Integer.compare(o1.val, o2.val);
        });

        for(ListNode tmp : lists){
            if(tmp!=null){
                pq.add(tmp);
            }
        }

        ListNode cur = dum;

        while(!pq.isEmpty()){
            ListNode tmp = pq.poll();
            cur.next = tmp;
            if(tmp.next!=null){
                pq.add(tmp);
            }
            cur = cur.next;
        }

        return dum.next;

    }
}