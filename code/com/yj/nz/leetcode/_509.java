package com.yj.nz.leetcode;

import java.util.Scanner;

/**
 * ClassName:_509
 * Package:com.yj.nz.leetcode
 * Description:描述
 *
 * @Date:2022/9/21 18:19
 * @Author:NieZheng
 * @Version:1.0
 */


/*
* 509.斐波那契数列
*       斐波那契数列指的是这样一个数列：1、1、2、3、5、8、13、21、34,又称兔子数列
* */
public class _509 {

    // 方式一：递归法
    //O(2^n)
    public static int fib1(int n){
        if ( n <= 1 )
            return n;
        return fib1( n - 1 ) + fib1( n - 2 );
    }

    // 方式二：迭代法
    //O(n)
    public static int fib2(int n){
        if( n <= 1 )
            return n;
        int first = 0;
        int second = 1;
        for (int i = 0; i < n - 1;i++){
            int sum = first + second;
            first = second;
            second = sum;
        }
        return second;
    }

    // 方式三：通项公式法
    //O(1)
    public static int fib3(int n){
        double c = Math.sqrt(5);
        return (int)((Math.pow((1 + c) / 2,n) - Math.pow((1 - c) / 2,n)) / c );
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(fib1(n));
        System.out.println(fib2(n));
    }

}
