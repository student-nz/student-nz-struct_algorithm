package com.yj.nz.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * ClassName:_00023MergeKSortedLists
 * Package:com.yj.nz.demo
 * Description:描述
 *
 * @Date:2022/9/12 20:20
 * @Author:NieZheng
 * @Version:1.0
 */


/*
 * 给你一个链表数组，每个链表都已经按升序排列。
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 * */


// 合并K个有序链表: 小根堆实现 优先队列

/*
 * 优先级队列与普通队列的区别：
 * 相同之处：对优先级相同的元素和普通队列一样遵循“先进先出”的原则
 * 不同之处：在于优先级队列的出队列操作不是把队头元素出队列，而是把队列中优先级最高的数据元素出队列
 * */

public class _00023MergeKSortedLists {

    // 定义链表节点
    public static class ListNode {
        public int val;
        public ListNode next;
    }


    /**
     * 定义 ListNode 的比较器
     */
    public static class ListNodeComparator implements Comparator<ListNode> {

        @Override
        public int compare(ListNode o1, ListNode o2) {
            return o1.val - o2.val;
        }

    }

    /**
     * 单链表集合 表示有K个链表
     * @param lists
     * @return
     */

    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists == null) {
            return null;
        }
        PriorityQueue<ListNode> heap = new PriorityQueue<>(new ListNodeComparator());
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) {
                // 把每个链表的第一个元素（头节点）都加进 堆heap 去
                heap.add(lists[i]);
            }
        }
        if (heap.isEmpty()) {
            return null;
        }
        // 弹出堆中最小的元素 作为新链表的头节点
        ListNode head = heap.poll();
        ListNode pre = head;
        if (pre.next != null) {
            heap.add(pre.next);
        }
        while (!heap.isEmpty()) {
            ListNode cur = heap.poll();
            pre.next = cur;
            pre = cur;
            if (cur.next != null) {
                heap.add(cur.next);
            }
        }
        return head;
    }

}
