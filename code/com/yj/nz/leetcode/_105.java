package com.yj.nz.leetcode;

import java.util.HashMap;

/**
 * ClassName:_105
 * Package:com.yj.nz.leetcode
 * Description:描述
 *
 * @Date:2022/9/18 12:03
 * @Author:NieZheng
 * @Version:1.0
 */
/*
 * 105. 从前序与中序遍历序列构造二叉树
 *       给定两个整数数组 preorder 和 inorder ，其中 preorder 是二叉树的先序遍历， inorder 是同一棵树的中序遍历
 *       请构造二叉树并返回其根节点。
 * */
public class _105 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static TreeNode buildTree1(int[] pre, int[] in) {
        if (pre == null || in == null || pre.length != in.length) {
            return null;
        }
        return f(pre, 0, pre.length - 1, in, 0, in.length - 1);
    }

    // 有一棵树，先序结果是pre[L1...R1]，中序结果是in[L2...R2]
    // 请建出整棵树返回头节点
    public static TreeNode f1(int[] pre,int L1,int R1,int[] in, int L2,int R2){
        if ( L1 > R1){
            return null;
        }
        TreeNode head = new TreeNode(pre[L1]);
        if ( L1 == R1){
            return head;
        }
        int find = L2;
        while ( in[find] != pre[L1] ){
            find++;
        }
        head.left = f1(pre,L1 + 1,L1 + find - L2,in,L2,find - 1);
        head.right = f(pre,L1 + find - L2 + 1,R1,in,find + 1,R2);
        return head;
    }
    public static TreeNode f(int[] pre, int L1, int R1, int[] in, int L2, int R2) {
        if (L1 > R1) {
            return null;
        }
        TreeNode head = new TreeNode(pre[L1]);
        if (L1 == R1) {
            return head;
        }
        int find = L2;
        while (in[find] != pre[L1]) {
            find++;
        }
        head.left = f(pre, L1 + 1, L1 + find - L2, in, L2, find - 1);
        head.right = f(pre, L1 + find - L2 + 1, R1, in, find + 1, R2);
        return head;
    }


    public static TreeNode buildTree3(int[] pre,int[] in){
        if ( pre == null || in == null || pre.length != in.length ){
            return null;
        }
        HashMap<Integer,Integer> valueIndexMap = new HashMap<>();
        for (int i = 0; i < in.length; i++) {
            valueIndexMap.put(in[i],i);
        }
        return g1(pre, 0, pre.length - 1, in, 0, in.length - 1, valueIndexMap);
    }

    private static TreeNode g1(int[] pre, int L1, int R1, int[] in, int L2, int R2, HashMap<Integer, Integer> valueIndexMap) {
        if ( L1 > R1 ){
            return null;
        }
        TreeNode head = new TreeNode(pre[L1]);
        if ( L1 == R1 ){
            return head;
        }
        int find = valueIndexMap.get(pre[L1]);

         head.left = g1(pre,L1 + 1,find - L2 + L1, in,L2,find - 1,valueIndexMap);
         head.right = g1(pre,find - L2 + L1 + 1,R1,in,find + 1,R2,valueIndexMap);

        return null;
    }


    public static TreeNode buildTree2(int[] pre, int[] in) {
        if (pre == null || in == null || pre.length != in.length) {
            return null;
        }
        HashMap<Integer, Integer> valueIndexMap = new HashMap<>();
        for (int i = 0; i < in.length; i++) {
            valueIndexMap.put(in[i], i);
        }
        return g(pre, 0, pre.length - 1, in, 0, in.length - 1, valueIndexMap);
    }

    // 有一棵树，先序结果是pre[L1...R1]，中序结果是in[L2...R2]
    // 请建出整棵树返回头节点
    public static TreeNode g(int[] pre, int L1, int R1, int[] in, int L2, int R2, HashMap<Integer, Integer> valueIndexMap) {
        if (L1 > R1) {
            return null;
        }
        TreeNode head = new TreeNode(pre[L1]);
        if (L1 == R1) {
            return head;
        }
        int find = valueIndexMap.get(pre[L1]);
        head.left = g(pre, L1 + 1, L1 + find - L2, in, L2, find - 1, valueIndexMap);
        head.right = g(pre, L1 + find - L2 + 1, R1, in, find + 1, R2, valueIndexMap);
        return head;
    }
}
