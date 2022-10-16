package com.yj.nz.leetcode;

/*
* 给定两个大小分别为 m和 n的正序（从小到大）数组 `nums1` 和 `nums2`。
* 请你找出并返回这两个正序数组的中位数
* 算法的时间复杂度应该为 O(log (m+n))
* */

public class _0004_MedianOfTwoSortedArrays {

	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int totalLen = nums1.length + nums2.length;
		//中位数位置
		int k = (int) (totalLen + 1) / 2 ;
		//偶数
		if(totalLen % 2 == 0) {
			double mid = (getMinK(nums1, nums2, k) + getMinK(nums1, nums2, k + 1)) / 2;
			return mid;
		} else {
			//奇数
			double mid = getMinK(nums1, nums2, k);
			return mid;
		}
	}

	private double getMinK(int[] nums1, int[] nums2, int k){

		int len1 = nums1.length, len2 = nums2.length;
		int index1 = 0, index2 = 0;

		while(true){
			//边界情况
			//若A数组已经遍历完了，则当前指向B数组的指针再往后移k-1步，就是所求
			if(index1 == len1){
				return nums2[index2 + k - 1];
			}

			if(index2 == len2){
				return nums1[index1 + k - 1];
			}

			if(k == 1){
				return Math.min(nums1[index1], nums2[index2]);
			}

			int mid = k / 2;
			int newIndex1 = Math.min(len1, index1 + mid) - 1;
			int newIndex2 = Math.min(len2, index2 + mid) - 1;
			int p1 = nums1[newIndex1], p2 = nums2[newIndex2];
			if(p1 <= p2){
				k -= (newIndex1 - index1 + 1);
				index1 = newIndex1 + 1;
			} else {
				k -= (newIndex2 - index2 + 1);
				index2 = newIndex2 + 1;
			}
		}
	}
}
