package com.yj.nz.demo;

/**
 * ClassName:Code2_SumOfFactorial
 * Package:com.yj.nz.demo
 * Description:描述
 *
 * @Date:2022/8/31 19:51
 * @Author:NieZheng
 * @Version:1.0
 */

// 求1! + 2! + 3! + 4! + . . .的和
public class Code2_SumOfFactorial {

    // 方式一：加乘分开法
    public static long f1(int N) {
        long sum = 0;
        for (int i = 1; i <= N; i++) {
            sum += factorial(i);
        }
        return sum;
    }

    public static long factorial(int N) {
        long res = 1;
        for (int i = 1; i <= N; i++) {
            res *= i;
        }
        return res;
    }

    // 方式二：乘加结合法
    public static long f2(int N) {
        long sum = 0;
        long cur = 1;
        for (int i = 1; i <= N; i++) {
            cur = cur * i;
            sum += cur;
        }
        return sum;
    }

    public static void main(String[] args) {
        int N = 2;
        System.out.println(f1(N));
        System.out.println(f2(N));
    }
}
