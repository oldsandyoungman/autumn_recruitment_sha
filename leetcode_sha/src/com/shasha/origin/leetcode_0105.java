package com.shasha.origin;


import com.shasha.struct.TreeNode;
import org.junit.Test;

/**
 * @author ShaLuwei
 * @create 2022-08-03 08:51
 */
public class leetcode_0105 {

    @Test
    public void test(){
        int[] pre = {3,9,20,15,7};
        int[] in = {9,3,15,20,7};
        buildTree(pre, in);
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        return dfs(preorder, 0, n-1, inorder, 0, n-1);
    }

    public TreeNode dfs(int[] preorder, int pstart, int pend, int[] inorder, int istart, int iend){
        if(pstart>pend){
            return null;
        }
        int root_val = preorder[pstart];
        TreeNode root = new TreeNode(root_val);
        int index = istart;
        for(;index<=iend; index++){
            if(inorder[index]==root_val){
                break;
            }
        }
        int len = index - istart;
        root.left = dfs(preorder, pstart+1, pstart+len-1, inorder, istart, index-1);
        root.right = dfs(preorder, pstart+len, pend, inorder, index+1, iend);
        return root;
    }


}
