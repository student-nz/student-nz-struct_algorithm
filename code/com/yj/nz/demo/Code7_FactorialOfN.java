package com.yj.nz.demo;

import java.util.Scanner;

/**
 * ClassName:Code7_FactorialOfN
 * Package:com.yj.nz.need
 * Description:描述
 *
 * @Date:2022/9/21 17:03
 * @Author:NieZheng
 * @Version:1.0
 */
// 求n阶乘
public class Code7_FactorialOfN {

    // 递归法
    public static int factorial(int n){
        if ( n == 1 ){
            return 1;
        }
        return n * factorial(n-1);
    }

    public static int test(){
        System.out.println("请输入n：");
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        return factorial(num);
    }

    public static void main(String[] args) {
        System.out.println(test());
    }
}
