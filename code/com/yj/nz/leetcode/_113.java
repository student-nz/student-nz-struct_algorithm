package com.yj.nz.leetcode;

import com.yj.nz.demo.Code23_PathSumII;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName:_113
 * Package:com.yj.nz.leetcode
 * Description:描述
 *
 * @Date:2022/9/18 11:42
 * @Author:NieZheng
 * @Version:1.0
 */
/*
* 113. 路径总和 II
*   给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。
*   叶子节点 是指没有子节点的节点。
* */
public class _113 {

    public static class TreeNode {
        public int val;
        public Code23_PathSumII.TreeNode left;
        public Code23_PathSumII.TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static List<List<Integer>> pathSum(Code23_PathSumII.TreeNode root, int sum) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        ArrayList<Integer> path = new ArrayList<>();
        process(root, path, 0, sum, ans);
        return ans;
    }

    public static void process(Code23_PathSumII.TreeNode x, List<Integer> path, int preSum, int sum, List<List<Integer>> ans) {
        if (x.left == null && x.right == null) {
            if (preSum + x.val == sum) {
                path.add(x.val);
                ans.add(copy(path));
                path.remove(path.size() - 1);
            }
            return;
        }
        // x 非叶节点
        path.add(x.val);
        preSum += x.val;
        if (x.left != null) {
            process(x.left, path, preSum, sum, ans);
        }
        if (x.right != null) {
            process(x.right, path, preSum, sum, ans);
        }
        path.remove(path.size() - 1);
    }

    public static List<Integer> copy(List<Integer> path) {
        List<Integer> ans = new ArrayList<>();
        for (Integer num : path) {
            ans.add(num);
        }
        return ans;
    }
}
