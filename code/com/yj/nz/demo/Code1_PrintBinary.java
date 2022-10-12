package com.yj.nz.demo;

/**
 * ClassName:Code1_PrintBinary
 * Package:com.yj.nz.demo
 * Description:描述
 *
 * @Date:2022/8/31 19:02
 * @Author:NieZheng
 * @Version:1.0
 */

// 打印整形的二进制
public class Code1_PrintBinary {

    /**
     * 打印整型的二进制
     * 实现思路：
     *      一个整型占有 4 字节 总共 32 位 信息,
     *      第一次 用 1 左移 31 位 & num
     *      以后每次移位都在上一次移位基础上减 1，直到 移位信息为 0
     * @param num
     */
    public static void PrintBinary(int num) {
        for (int i = 31; i >= 0; i--) {
            System.out.print((num & (1 << i)) == 0 ? "0" : "1");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        PrintBinary(1);
        PrintBinary(-1);
    }
}
