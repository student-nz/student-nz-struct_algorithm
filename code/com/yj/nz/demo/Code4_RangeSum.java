package com.yj.nz.demo;

/**
 * ClassName:Code4_RangeSum
 * Package:com.yj.nz.demo
 * Description:描述
 *
 * @Date:2022/9/2 19:25
 * @Author:NieZheng
 * @Version:1.0
 */

// 前缀和
public class Code4_RangeSum {

    // 需求：求数组指定范围内元素

    // 方式一：普通方法
    public static int RangeSum(int array[], int left, int right) {
        if (left >= array.length || right >= array.length) {
            throw new IllegalArgumentException("范围越界");
        }
        int sum = 0;
        for (int i = left; i <= right; i++) {
            sum += array[i];
        }
        return sum;
    }

    // 方式二：前缀和求法
    public static int RangeSum2(int array[], int left, int right) {
        int[] preSum = new int[array.length];
        preSum[0] = array[0];
        if (left >= array.length || right >= array.length) {
            throw new IllegalArgumentException("范围越界");
        }
        for (int i = 1; i < array.length; i++) {
            preSum[i] = preSum[i - 1] + array[i];
        }
        return left == 0 ? preSum[right] : preSum[right] - preSum[left - 1];
    }

    public static void main(String[] args) {
        int arr[] = {1, 6, 9, 0, 2, 1};
        System.out.println(RangeSum(arr, 1, 4));
        System.out.println(RangeSum2(arr, 1, 4));
    }

}
