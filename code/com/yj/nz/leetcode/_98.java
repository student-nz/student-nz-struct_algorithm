package com.yj.nz.leetcode;

/**
 * ClassName:_98
 * Package:com.yj.nz.leetcode
 * Description:描述
 *
 * @Date:2022/9/18 9:07
 * @Author:NieZheng
 * @Version:1.0
 */
/*
 *
 * 98. 验证二叉搜索树
 * 二叉排序树（Binary Sort Tree）或者是一棵空树；
 * 或者是具有下列性质的二叉树：
 * 	（1）若左子树不空，则左子树上所有结点的值均小于它的根结点的值；
 * 	（2）若右子树不空，则右子树上所有结点的值均大于它的根结点的值；
 * 	（3）左、右子树也分别为二叉排序树；
 * */
public class _98 {
    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static class Info {
        public boolean isBST;
        public int max;
        public int min;

        public Info(boolean is, int ma, int mi) {
            isBST = is;
            max = ma;
            min = mi;
        }
    }

    public static Info process(TreeNode x) {
        if (x == null) {
            return null;
        }
       Info leftInfo = process(x.left);
        Info rightInfo = process(x.right);
        int max = x.val;
        int min = x.val;
        if (leftInfo != null) {
            max = Math.max(leftInfo.max, max);
            min = Math.min(leftInfo.min, min);
        }
        if (rightInfo != null) {
            max = Math.max(rightInfo.max, max);
            min = Math.min(rightInfo.min, min);
        }
        boolean isBST = true;
        if (leftInfo != null && !leftInfo.isBST) {
            isBST = false;
        }
        if (rightInfo != null && !rightInfo.isBST) {
            isBST = false;
        }
        boolean leftMaxLessX = leftInfo == null ? true : (leftInfo.max < x.val);
        boolean rightMinMoreX = rightInfo == null ? true : (rightInfo.min > x.val);
        if (!(leftMaxLessX && rightMinMoreX)) {
            isBST = false;
        }
        return new Info(isBST, max, min);
    }
}
