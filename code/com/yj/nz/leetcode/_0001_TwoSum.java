package com.yj.nz.leetcode;

import java.util.HashMap;

/*
* 1. 两数之和
* 给定一个整数数组 `nums` 和一个整数目标值 `target`，请你在该数组中找出和为目标值target 的那 两个整数，并返回它们的数组下标
* */
public class _0001_TwoSum {

	public static int[] twoSum(int[] nums, int target) {
		// key 某个之前的数   value 这个数出现的位置
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			if (map.containsKey(target - nums[i])) {
				return new int[] { map.get(target - nums[i]), i };
			}
			map.put(nums[i], i);
		}
		return new int[] { -1, -1 };
	}

}
