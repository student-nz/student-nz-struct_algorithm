package com.yj.nz.leetcode;
/**
 * ClassName:_110
 * Package:com.yj.nz.leetcode
 * Description:描述
 *
 * @Date:2022/9/17 21:54
 * @Author:NieZheng
 * @Version:1.0
 */

/*
*  110.平衡二叉树
*       一个二叉树每个节点的左右两个子树的高度差的绝对值不超过 1
* */
public class _110 {
    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static class Info1{
        public boolean isBanlanced;
        public int height;

        public Info1(boolean i,int h){
            isBanlanced = i;
            height = h;
        }
    }

    public static boolean isBanlanced(TreeNode root){
        return process1(root).isBanlanced;
    }

    private static Info1 process1(TreeNode root) {
        if ( root == null ){
            return new Info1(true,0);
        }
        Info leftInfo = process(root.left);
        Info rightInfo = process(root.right);
        int height = Math.max( leftInfo.height,rightInfo.height) + 1;
        boolean isBanlanced = leftInfo.isBalanced && rightInfo.isBalanced && Math.abs(leftInfo.height - rightInfo.height) < 2;
        return new Info1(isBanlanced,height);
    }

    public static class Info {
        public boolean isBalanced;
        public int height;

        public Info(boolean i, int h) {
            isBalanced = i;
            height = h;
        }
    }

    public static boolean isBalanced(TreeNode root) {
        return process(root).isBalanced;
    }

    public static Info process(TreeNode root) {
        if (root == null) {
            return new Info(true, 0);
        }
        Info leftInfo = process(root.left);
        Info rightInfo = process(root.right);
        int height = Math.max(leftInfo.height, rightInfo.height) + 1;
        boolean isBalanced = leftInfo.isBalanced && rightInfo.isBalanced
                && Math.abs(leftInfo.height - rightInfo.height) < 2;
        return new Info(isBalanced, height);
    }
}
