package com.yj.nz.leetcode;

/**
 * ClassName:_101
 * Package:com.yj.nz.demo
 * Description:描述
 *
 * @Date:2022/9/12 20:40
 * @Author:NieZheng
 * @Version:1.0
 */

/*
* 101. 对称二叉树
*           给你一个二叉树的根节点 root ， 检查它是否轴对称
* 测试链接：https://leetcode.com/problems/symmetric-tree
* */
    
public class _101 {

    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;
    }

    // 是否为对称树
    public static boolean isSymmetric(TreeNode root) {
        return isMirror(root, root);
    }

    public static boolean isMirror(TreeNode h1, TreeNode h2) {
        if (h1 == null ^ h2 == null) {
            return false;
        }
        if (h1 == null && h2 == null) {
            return true;
        }
        return h1.val == h2.val && isMirror(h1.left, h2.right) && isMirror(h1.right, h2.left);
    }

}
