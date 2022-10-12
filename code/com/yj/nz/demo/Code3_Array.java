package com.yj.nz.demo;
import java.util.Arrays;

/**
 * ClassName:Code3_Array
 * Package:com.yj.nz.demo
 * Description:描述
 *
 * @Date:2022/9/1 12:42
 * @Author:NieZheng
 * @Version:1.0
 */

public class Code3_Array {

    /*
     * 选择排序算法思想：
     *   每次都从未排序的序列中选择一个最小的数放在已排序列的最左边，直至排序完成
     *   N个元素就需要比较 N-1次 从第一个元素开始
     * */

    public static void selectionSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        // 0 ~ N-1
        // 1~n-1
        // 2
        for (int i = 0; i < arr.length - 1; i++) { // i ~ N-1
            // 最小值在哪个位置上  i～n-1
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) { // i ~ N-1 上找最小值的下标
                minIndex = arr[j] < arr[minIndex] ? j : minIndex;
            }
            swap(arr, i, minIndex);
        }
    }

    /*
    * 冒泡排序算法思想：
    *   冒泡排序就是相邻元素进行比较，如果不符合规则就进行交换（规则就是从小到大排序或者是从大到小排序）
    * */

    public static void bubbleSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        // 0 ~ N-1
        // 0 ~ N-2
        // 0 ~ N-3
        for (int end = arr.length - 1; end > 0; end--) { // 0 ~ end
            for (int i = 0; i < end; i++) {
                if (arr[i] > arr[i + 1]) {
                    swap(arr, i, i + 1);
                }
            }
        }
    }

    /*
    * 插入排序算法思想：将一个数据插入到一个有序的数据列表，得到一个新的有序列表
    * 从第二个元素开始，把前面的元素序列当作已经有序的，然后找合适的位置插入
    * */

    // 方式一：插入排序while循环实现
    public static void insertSort1(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int end = 1; end < arr.length; end++) {
            int newNumIndex = end;
            while (newNumIndex - 1 >= 0 && arr[newNumIndex - 1] > arr[newNumIndex]) {
                swap(arr, newNumIndex - 1, newNumIndex);
                newNumIndex--;
            }
        }
    }

    // 方式二：插入排序for循环实现
    public static void insertSort2(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int end = 1; end < arr.length; end++) {
            for (int pre = end - 1; pre >= 0 && arr[pre] > arr[pre + 1]; pre--) {
                swap(arr, pre, pre + 1);
            }
        }
    }


    // 交换两数算法
    public static void swap(int[] arr, int i, int j) {
        // 定义一个临时变量tmp
        int tmp = arr[j];
        arr[j] = arr[i];
        arr[i] = tmp;
    }

    // 打印数组算法
    public static void printArray(int[] arr) {
        if (arr == null) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // 用Java内置数组工具类Arrays对数组元素进行排序,充当对数器，检验自定义排序算法是否正确
    /*
    * 何为对数器？
    *   对数器就是用来检验算法的正确性，即用一个绝对ok的方法与自定义写的算法进行对比，
    *   检验结果是否正确，结果正确，返回true，否则,返回false
    * */
    public static void comparator(int[] arr) {
        Arrays.sort(arr);
    }

    // 生成一个随机数组arr，arr长度[0,maxSize],arr中的每个值[0,maxValue]
    public static int[] generateRandomArray(int maxSize, int maxValue) {
        // Math.random() [0,1)
        // Math.random() * N [0,N)
        // (int)(Math.random() * N) [0, N-1]
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            // [-? , +?]
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
        }
        return arr;
    }

    // 生成随机数组，且相邻数不相等
    public static int[] generateRandomArray2(int maxLen, int maxValue) {
        int len = (int) (Math.random() * maxLen);
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


    // 拷贝数组算法
    public static int[] copyArray(int[] arr) {
        if (arr == null) {
            return null;
        }
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    // 判断两个数组是否相等算法
    public static boolean isEqual(int[] arr1, int[] arr2) {
        if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)) {
            return false;
        }
        if (arr1 == null && arr2 == null) {
            return true;
        }
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }


    // 判断一个数组是否有序
    public static boolean isOrderly(int[] arr) {
        if(isOrderAsc(arr) || isOrderDesc(arr)) {
            return true;
        }
        return false;
    }


    // 判断一个数组是否升序
    private static boolean isOrderAsc(int[] arr) {
        for(int i = 1;i < arr.length;i++) {
            if(arr[i-1] > arr[i]) {
                return false;
            }
        }
        return true;
    }

   // 判断一个数组是否降序
    private static boolean isOrderDesc(int[] arr) {
        for(int i = 1; i > arr.length; i++) {
            if(arr[i-1] < arr[i]) {
                return false;
            }
        }
        return true;
    }


}
