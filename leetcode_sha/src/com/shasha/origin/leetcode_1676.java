package com.shasha.origin;

import com.shasha.struct.TreeNode;

import java.util.HashSet;

/**
 * @author ShaLuwei
 * @create 2022-08-08 11:12
 */
public class leetcode_1676 {

    /*
给定一棵二叉树的根节点 root 和 TreeNode 类对象的数组（列表） nodes，返回 nodes 中所有节点的最近公共祖先（LCA）。
数组（列表）中所有节点都存在于该二叉树中，且二叉树中所有节点的值都是互不相同的。

我们扩展二叉树的最近公共祖先节点在维基百科上的定义：“对于任意合理的 i 值， n 个节点 p1 、 p2、…、 pn 在二叉树 T 中的最近公共祖先节点是后代中包含所有节点 pi 的最深节点（我们允许一个节点是其自身的后代）”。

一个节点 x 的后代节点是节点 x 到某一叶节点间的路径中的节点 y。

     */

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode[] nodes) {
        HashSet<Integer> s = new HashSet<>();
        for (TreeNode node : nodes) {
            s.add(node.val);
        }
        return dfs(root, s);
    }
    // 返回，当前节点为根节点的子树中，最深的公共节点
    public TreeNode dfs(TreeNode root, HashSet<Integer> s){
        if(root==null){
            return null;
        }

        if(s.contains(root.val)){
            return root;
        }

        TreeNode l = dfs(root.left, s);
        TreeNode r = dfs(root.right, s);

        if(l!=null && r!=null){
            return root;
        }

        if (l==null){
            return r;
        }

        return l;

    }

}
