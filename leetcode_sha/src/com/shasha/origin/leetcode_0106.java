package com.shasha.origin;

import com.shasha.struct.TreeNode;
import org.junit.Test;

/**
 * @author ShaLuwei
 * @create 2022-08-03 09:03
 */
public class leetcode_0106 {

    @Test
    public void test(){
        int[] in = {9,3,15,20,7};
        int[] post = {9,15,7,20,3};
        buildTree(in, post);
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = inorder.length;
        return dfs(inorder, 0, n-1, postorder, 0, n-1);
    }

    public TreeNode dfs(int[] inorder, int istart, int iend, int[] postorder, int pstart, int pend){
        if(pstart>pend){
            return null;
        }
        int root_val = postorder[pend];
        TreeNode root = new TreeNode(root_val);
        int index = istart;
        for(;index<=iend; index++){
            if(inorder[index]==root_val){
                break;
            }
        }
        int len = index - istart;
        root.left = dfs(inorder, istart, index-1, postorder, pstart, pstart+len-1);
        root.right = dfs(inorder, index+1, iend, postorder, pstart+len, pend-1);
        return root;
    }

}
