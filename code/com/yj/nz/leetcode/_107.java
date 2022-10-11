package com.yj.nz.leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * ClassName:_107
 * Package:com.yj.nz.leetcode
 * Description:描述
 *
 * @Date:2022/9/17 20:51
 * @Author:NieZheng
 * @Version:1.0
 */
/*
*  107.二叉树的层序遍历 II
*       自底向上层序遍历 -> 逐层从左向右遍历
* */
public class _107 {
    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ans = new LinkedList<>();
        if (root == null) {
            // 如果为空直接返回空数组
            return ans;
        }
        // 队列存储，层序遍历
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> curAns = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode curNode = queue.poll();
                curAns.add(curNode.val);
                if (curNode.left != null) {
                    queue.add(curNode.left);
                }
                if (curNode.right != null) {
                    queue.add(curNode.right);
                }
            }
            ans.add(0, curAns);
        }
        return ans;
    }

}
