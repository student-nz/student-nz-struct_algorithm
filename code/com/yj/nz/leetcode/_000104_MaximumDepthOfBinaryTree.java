package com.yj.nz.leetcode;

/**
 * ClassName:_000104_MaximumDepthOfBinaryTree
 * Package:com.yj.nz.demo
 * Description:描述
 *
 * @Date:2022/9/12 20:43
 * @Author:NieZheng
 * @Version:1.0
 */


// 104. 二叉树最大深度
// 二叉树最大深度：二叉树最大深度为根节点到最远叶子节点的最长路径上的节点数
// 二叉树高度：两种定义
//      1. 从根节点到最深节点的最长路径的节点数
//      2. 从根到最深节点的最长路径的边数。
// 高度与深度区别：深度是从根节点数到它的叶节点，高度是从叶节点数到它的根节点
public class _000104_MaximumDepthOfBinaryTree {

    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;
    }

    // 以root为头的树，最大高度是多少返回！
    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

}
