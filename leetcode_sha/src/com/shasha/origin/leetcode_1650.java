package com.shasha.origin;

import org.junit.Test;

/**
 * @author ShaLuwei
 * @create 2022-08-08 11:07
 */
public class leetcode_1650 {

    /*
给定一棵二叉树中的两个节点 p 和 q，返回它们的最近公共祖先节点（LCA）。

每个节点都包含其父节点的引用（指针）。Node 的定义如下：

class Node {
public int val;
public Node left;
public Node right;
public Node parent;
}
根据维基百科中对最近公共祖先节点的定义：
“两个节点 p 和 q 在二叉树 T 中的最近公共祖先节点是后代节点中既包括 p 又包括 q 的最深节点
（我们允许一个节点为自身的一个后代节点）”。一个节点 x 的后代节点是节点 x 到某一叶节点间的路径中的节点 y。

     */

    @Test
    public void test(){

    }

    public Node1650 lowestCommonAncestor(Node1650 p, Node1650 q) {

        Node1650 l = p;
        Node1650 r = q;

        while(l!=r){
            if(l.parent!=null){
                l = l.parent;
            }else {
                l = q;
            }
            if(r.parent!=null){
                r = r.parent;
            }else {
                r = p;
            }
        }

        return l;

    }



}

class Node1650{

    public int val;
    public Node1650 left;
    public Node1650 right;
    public Node1650 parent;


}