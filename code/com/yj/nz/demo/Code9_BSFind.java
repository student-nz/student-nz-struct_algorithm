package com.yj.nz.demo;

/**
 * ClassName:Code9_BSFind
 * Package:com.yj.nz.demo
 * Description:描述
 *
 * @Date:2022/9/4 9:19
 * @Author:NieZheng
 * @Version:1.0
 */

// 二分法
public class Code9_BSFind {

    // 二分法：在一个有序数组中, 查找某个元素是否存在
    // 确保 arr 有序
    public static boolean binarySearchFind(int arr[],int num){
        if( arr == null || arr.length == 0 ){
            return false;
        }
        int left = 0;
        int right = arr.length - 1;
        while ( left <= right ){
            int mid = ( left + right ) / 2;
            if( num == arr[mid] ){
                return true;
            }else if ( num > arr[mid] ){
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }
        return false;
    }

    // 二分法：在一个有序数组中，找 >= 某个数最左侧的位置

    // arr 有序 >= num 最左
    public static int mostLeftIndex(int arr[],int num){
        if( arr == null || arr.length == 0 ){
            return -1;
        }
        int left = 0;
        int right = arr.length - 1;
        int index = -1;
        while( left <= right ){
            int mid = ( left + right ) / 2;
            if( arr[mid] >= num ){
                index = mid;
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }
        return index;
    }

    /*
     * 二分法：在一个有序数组中，找<=某个数最右侧的位置
     * */

    // 在arr上，找满足<=num的最右位置
    public static int mostRightIndex(int arr[],int num){
        if ( arr == null || arr.length == 0 ){
            return -1;
        }
        int left = 0;
        int right = arr.length - 1;
        int index = -1;
        while( left <= right ){
            int mid = left + ( ( right - left ) >> 1 );
            if(arr[mid] <= num ){
                index = mid;
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }
        return index;
    }

}
