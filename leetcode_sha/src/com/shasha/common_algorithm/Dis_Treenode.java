package com.shasha.common_algorithm;

import com.shasha.struct.TreeNode;
import org.junit.Test;

/**
 * 
 * @author ShaLuwei
 * @create 2022-08-04 19:41
 */
public class Dis_Treenode {

    @Test
    public void test(){
        TreeNode a = new TreeNode(3);
        TreeNode b = new TreeNode(5);
        TreeNode c = new TreeNode(1);
        TreeNode d = new TreeNode(6);

        a.left = b;
        a.right = c;
        b.left = d;

        System.out.println(lowestCommonAncestor(a, d, c));


    }

    public int lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        result_dis = 0;
        Res r = dfs(root, p, q);
        return r.dis;
    }

    int result_dis;

    public Res dfs(TreeNode root, TreeNode p, TreeNode q){
        if(root==null){
            return new Res(null, 0);
        }

        if(root==p || root==q){
            return new Res(root, 1);
        }

        Res l = dfs(root.left, p, q);
        Res r = dfs(root.right, p, q);

        if(l.a!=null && r.a!=null){
            result_dis = l.dis+r.dis;
            return new Res(root, result_dis);
        }

        if(l.a==null){
            return new Res(r.a, r.dis+1);
        }

        // if(r==null){
        //     return l;
        // }
        return new Res(l.a, l.dis+1);

    }


}

class Res{

    TreeNode a;

    int dis;

    public Res(TreeNode a, int dis){
        this.a = a;
        this.dis = dis;
    }

}
