

package com.yj.nz.leetcode;

/*
* 给你链表的头节点 head ，每 k 个节点一组进行翻转，请你返回修改后的链表。
* k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
* 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
* */
public class _00025ReverseNodesInKGroup {

	// 不要提交这个类
	public static class ListNode {
		public int val;
		public ListNode next;
	}

	public static ListNode reverseKGroup(ListNode head, int k) {
		ListNode start = head;
		ListNode end = getKGroupEnd(start, k);
		if (end == null) {
			return head;
		}
		// 第一组凑齐了！
		head = end;
		reverse(start, end);
		// 上一组的结尾节点
		ListNode lastEnd = start;
		while (lastEnd.next != null) {
			start = lastEnd.next;
			end = getKGroupEnd(start, k);
			if (end == null) {
				return head;
			}
			reverse(start, end);
			lastEnd.next = end;
			lastEnd = start;
		}
		return head;
	}

	public static ListNode getKGroupEnd(ListNode start, int k) {
		while (--k != 0 && start != null) {
			start = start.next;
		}
		return start;
	}

	public static void reverse(ListNode start, ListNode end) {
		end = end.next;
		ListNode pre = null;
		ListNode cur = start;
		ListNode next = null;
		while (cur != end) {
			next = cur.next;
			cur.next = pre;
			pre = cur;
			cur = next;
		}
		start.next = end;
	}

}