package com.shasha.origin;

import com.shasha.struct.TreeNode;
import org.junit.Test;

/**
 * @author ShaLuwei
 * @create 2022-08-08 10:46
 */
public class leetcode_1644 {

    /*
    给定一棵二叉树的根节点 root，返回给定节点 p 和 q 的最近公共祖先（LCA）节点。
    如果 p 或 q 之一不存在于该二叉树中，返回 null。
    树中的每个节点值都是互不相同的。
     */

    @Test
    public void test(){
        TreeNode t1 = TreeNode.create_by_array(new Integer[]{1,2,3,4,5,6,7});
        TreeNode res = lowestCommonAncestor(t1, new TreeNode(8), new TreeNode(4));
        System.out.println(res==null?-1:res.val);

    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        existP = false;
        existQ = false;

        TreeNode res = dfs(root, p.val, q.val);

        if(!existQ || !existP){
            return null;
        }

        return res;

    }

    boolean existP;
    boolean existQ;

    public TreeNode dfs(TreeNode root, int p, int q){
        if(root==null){
            return null;
        }
        TreeNode l = dfs(root.left, p, q);
        TreeNode r = dfs(root.right, p, q);

        if(l!=null && r!=null){
            return root;
        }

        if (root.val==p) {
            existP = true;
            return root;
        }
        if (root.val==q){
            existQ = true;
            return root;
        }

        if(l==null){
            return r;
        }

        return l;

    }

}
