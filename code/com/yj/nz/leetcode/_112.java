package com.yj.nz.leetcode;

import com.yj.nz.demo.Code22_PathSum;

/**
 * ClassName:_112
 * Package:com.yj.nz.leetcode
 * Description:描述
 *
 * @Date:2022/9/18 9:25
 * @Author:NieZheng
 * @Version:1.0
 */

/*
*   112. 路径总和
*       给你二叉树的根节点 root 和一个表示目标和的整数 targetSum 。判断该树中是否存在 根节点到叶子节点 的路径，这条
*       路径上所有节点值相加等于目标和 targetSum 。如果存在，返回 true ；否则，返回 false
*       叶子节点 是指没有子节点的节点。
* */
public class _112 {

    public static class TreeNode {
        public int val;
        public Code22_PathSum.TreeNode left;
        public Code22_PathSum.TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static boolean isSum = false;

    public static boolean hasPathSum(Code22_PathSum.TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        isSum = false;
        process(root, 0, sum);
        return isSum;
    }

    public static void process(Code22_PathSum.TreeNode x, int preSum, int sum) {
        if (x.left == null && x.right == null) {
            if (x.val + preSum == sum) {
                isSum = true;
            }
            return;
        }
        // x是非叶节点
        preSum += x.val;
        if (x.left != null) {
            process(x.left, preSum, sum);
        }
        if (x.right != null) {
            process(x.right, preSum, sum);
        }
    }
}
