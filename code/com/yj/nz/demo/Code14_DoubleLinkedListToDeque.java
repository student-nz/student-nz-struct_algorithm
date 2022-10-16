package com.yj.nz.demo;

// 双向链表实现双端队列
public class Code14_DoubleLinkedListToDeque {

	// 双链表节点
	public static class Node<V> {
		public V value;
		public Node<V> last;
		public Node<V> next;

		public Node(V v) {
			value = v;
			last = null;
			next = null;
		}
	}

	// 我的双端队列
	public static class MyDeque<V> {
		private Node<V> head;
		private Node<V> tail;
		private int size;

		public MyDeque() {
			head = null;
			tail = null;
			size = 0;
		}

		// 双端队列是否为空
		public boolean isEmpty() {
			return size == 0;
		}

		// 双端队列长度
		public int size() {
			return size;
		}

		// 队头进
		public void pushHead(V value) {
			Node<V> cur = new Node<>(value);
			if (head == null) {
				head = cur;
				tail = cur;
			} else {
				cur.next = head;
				head.last = cur;
				head = cur;
			}
			size++;
		}

		// 队尾进
		public void pushTail(V value) {
			Node<V> cur = new Node<>(value);
			if (head == null) {
				head = cur;
				tail = cur;
			} else {
				tail.next = cur;
				cur.last = tail;
				tail = cur;
			}
			size++;
		}

		// 队头出
		public V pollHead() {
			V ans = null;
			if (head == null) {
				return ans;
			}
			size--;
			ans = head.value;
			if (head == tail) {
				head = null;
				tail = null;
			} else {
				head = head.next;
				head.last = null;
			}
			return ans;
		}

		// 队尾出
		public V pollTail() {
			V ans = null;
			if (head == null) {
				return ans;
			}
			size--;
			ans = tail.value;
			if (head == tail) {
				head = null;
				tail = null;
			} else {
				tail = tail.last;
				tail.next = null;
			}
			return ans;
		}

		// 获取队头元素
		public V peekHead() {
			V ans = null;
			if (head != null) {
				ans = head.value;
			}
			return ans;
		}

		// 获取队尾元素
		public V peekTail() {
			V ans = null;
			if (tail != null) {
				ans = tail.value;
			}
			return ans;
		}

	}

}
