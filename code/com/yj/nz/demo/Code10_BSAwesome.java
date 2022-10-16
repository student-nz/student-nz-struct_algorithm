package com.yj.nz.demo;

/**
 * ClassName:Code10_BSAwesome
 * Package:com.yj.nz.demo
 * Description:描述
 *
 * @Date:2022/9/4 11:20
 * @Author:NieZheng
 * @Version:1.0
 */

// 局部最小值问题
public class Code10_BSAwesome {

    // 局部最小值问题:局部最小值是指在一个数组中，假如一个元素比它的左右相邻元素（如果存在）都小，那么这个元素就是局部最小值
    // 给定一个不包含相同元素的整数数组，求一个局部最小值所在索引位置
    // arr整体无序 相邻的数不相等
    public static int oneMinIndex(int[] arr){
        if( arr == null || arr.length == 0 ){
            return -1;
        }
        int n = arr.length;
        if ( n == 1 ){
            return 0;
        }
        if ( arr[0] < arr[1]){
            return 0;
        }
        if ( arr[n-1] < arr[n-2]){
            return n - 1;
        }
        int left = 0;
        int right = n - 1;
        while (left < right - 1) {
            int mid = (left + right) / 2;
            if (arr[mid] < arr[mid - 1] && arr[mid] < arr[mid + 1]) {
                return mid;
            } else {
                if (arr[mid] > arr[mid - 1]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }
        return arr[left] < arr[right] ? left : right;
    }

    // 生成随机数组，且相邻数不相等
    public static int[] generateRandomArray2(int maxSize, int maxValue) {
        int len = (int) (Math.random() * maxSize);
        int[] arr = new int[len];
        if (len > 0) {
            arr[0] = (int) (Math.random() * maxValue);
            for (int i = 1; i < len; i++) {
                do {
                    arr[i] = (int) (Math.random() * maxValue);
                } while (arr[i] == arr[i - 1]);
            }
        }
        return arr;
    }

}
