package com.shasha.struct;

import java.util.ArrayDeque;

/**
 * @author ShaLuwei
 * @create 2022-08-03 08:51
 */
public class TreeNode {

    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int val){
        this.val = val;
    }

    public static TreeNode create_by_array(Integer[] nums){
        int n = nums.length;
        if(n==0){
            return null;
        }

        ArrayDeque<TreeNode> q = new ArrayDeque<>();

        TreeNode root = new TreeNode(nums[0]);
        q.addLast(root);

        for (int i = 1; i < n; i+=2) {
            TreeNode parent = q.removeFirst();
            if(nums[i]!=null){
                TreeNode left = new TreeNode(nums[i]);
                parent.left = left;
                q.addLast(left);
            }
            if(nums[i+1]!=null) {
                TreeNode right = new TreeNode(nums[i + 1]);
                parent.right = right;
                q.addLast(right);
            }
        }

        return root;

    }

}
