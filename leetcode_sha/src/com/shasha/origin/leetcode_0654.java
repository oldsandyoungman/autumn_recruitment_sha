package com.shasha.origin;

import com.shasha.struct.TreeNode;
import org.junit.Test;

/**
 * @author ShaLuwei
 * @create 2022-08-03 10:31
 */
public class leetcode_0654 {

    @Test
    public void test(){
        int[] nums = {3,2,1,6,0,5};
        constructMaximumBinaryTree(nums);
    }

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        int n = nums.length;

        return dfs(nums, 0, n-1);

    }

    public TreeNode dfs(int[] nums, int start, int end){
        if(start>end){
            return null;
        }

        int max = -1;
        int index = -1;
        for(int i=start; i<end; i++){
            if(max<nums[i]){
                max = nums[i];
                index = i;
            }
        }

        TreeNode root = new TreeNode(max);
        root.left = dfs(nums, start, index-1);
        root.right = dfs(nums, index+1, end);

        return root;

    }

}
