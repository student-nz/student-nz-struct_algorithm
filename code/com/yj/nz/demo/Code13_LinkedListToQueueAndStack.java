package com.yj.nz.demo;

// 单链表实现队列和栈
public class Code13_LinkedListToQueueAndStack {

	// 单链表节点
	public static class Node<V> {
		public V value;
		public Node<V> next;

		public Node(V v) {
			value = v;
			next = null;
		}
	}

	// 我的队列：队尾进，队头出
	public static class MyQueue<V> {
		private Node<V> head;
		private Node<V> tail;
		private int size;

		public MyQueue() {
			head = null;
			tail = null;
			size = 0;
		}


		// 队列是否为空
		public boolean isEmpty() {
			return size == 0;
		}


		// 队列长度
		public int size() {
			return size;
		}


		// 队尾进
		public void offer(V value) {
			Node<V> cur = new Node<V>(value);
			if (tail == null) {
				head = cur;
				tail = cur;
			} else {
				tail.next = cur;
				tail = cur;
			}
			size++;
		}

		// 队头出
		public V poll() {
			V ans = null;
			if (head != null) {
				ans = head.value;
				head = head.next;
				size--;
			}
			if (head == null) {
				tail = null;
			}
			return ans;
		}



		// 获取队头元素
		public V peek() {
			V ans = null;
			if (head != null) {
				ans = head.value;
			}
			return ans;
		}

	}

	// 我的栈
	public static class MyStack<V> {
		private Node<V> head;
		private int size;

		public MyStack() {
			head = null;
			size = 0;
		}

		// 栈是否为空
		public boolean isEmpty() {
			return size == 0;
		}

		// 栈长度
		public int size() {
			return size;
		}

		// 进栈
		public void push(V value) {
			Node<V> cur = new Node<>(value);
			if (head == null) {
				head = cur;
			} else {
				cur.next = head;
				head = cur;
			}
			size++;
		}

		// 出栈
		public V pop() {
			V ans = null;
			if (head != null) {
				ans = head.value;
				head = head.next;
				size--;
			}
			return ans;
		}

		// 获取栈顶元素
		public V peek() {
			return head != null ? head.value : null;
		}

	}
}
