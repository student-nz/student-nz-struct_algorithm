package com.yj.nz.demo;

/**
 * ClassName:Code5_Rand_ToRand
 * Package:com.yj.nz.demo
 * Description:描述
 *
 * @Date:2022/9/3 10:49
 * @Author:NieZheng
 * @Version:1.0
 */

// 等概率随机器
/*
    1. 给你等概率返回1～5的随机函数， 这是唯一的随机源，请做出等概率返回1～7的随机函数
    2. 给你以p概率返回0， 以1-p概率返回1的函数p， 这是唯一的随机源， 请做出等概率返回0和1的随机函数
    3. 给你等概率返回1～m的随机函数， 这是唯一的随机源。 请做出等概率返回1～n的随机函数
*/
public class Code5_Rand_ToRand {

    //原工具：生成1~5的随机器
    public static int rand1To5() {
        return (int) (Math.random() * 5) + 1;
    }

    //根据1~5的随机器构造0~1的随机器
    public static int rand0To1() {
        int res = 0;
        do {
            res = rand1To5();
        } while (res == 3);
        return (res == 1 || res == 2) ? 0 : 1;
    }

    //根据 0~1 的随机器构造 0~6 的构造器
    public static int rand0To6() {
        int res = 0;
        do {
            res = rand0To1() == 0 ? 0 : 1;
            res += rand0To1() == 0 ? 0 : 2;
//            res += rand0To1() == 0 ? 0 : 4;
            res += rand0To1() == 0 ? 0 : 3;// 优化
        } while (res == 7);
        return res;
    }

    //根据0~6的随机器生成1~7的构造器
    public static int rand1To7() {
        return rand0To6() + 1;
    }

    //原构造器，p概率生成0,1-p概率生成1
    public static int rand01p() {
        // you can change p to what you like, but it must be (0,1)
        double p = 0.83;
        return Math.random() < p ? 0 : 1;
    }

    //根据p概率01随机源构造 等概率 01随机源
    public static int rand01() {
        int res = 0;
        do {
            res = rand01p() == 0 ? 0 : 1;
            res += rand01p() == 0 ? 0 : 2;
        } while (res == 0 || res == 3);
        return res == 1 ? 0 : 1;
    }

    //原构造器，1~m 等概率随机器
    public static int rand1ToM(int m) {
        return (int) (Math.random() * m) + 1;
    }

    //根据1~m 等概率随机器，构造01等概率随机器
    public static int rand0To1(int m) {
        int res = 0;
        if ((m ^ 1) == 0) {
            do {
                res = rand1ToM(m);
            } while (res == m / 2 + 1);
            return (res < m / 2 + 1) ? 0 : 1;
        } else {
            res = rand1ToM(m);
            return (res <= m / 2) ? 0 : 1;
        }
    }

    //根据1~m 等概率随机器，构造01等概率随机器
    //然后再根据01等概率器，先生成 0~n-1等概率随机器，再构造 1~n等概率器
    public static int rand1ToN(int m, int n) {
        int cur = 1;
        int bits = 1;
        while (cur < n - 1) {
            bits++;
            cur = cur + cur * 2;
        }
        int res = 0;
        do {
            res = 0;
            int base = 1;
            while (bits > 0) {
                res += rand0To1(m) == 0 ? 0 : base;
                base *= 2;
                bits--;
            }
        } while (res > n - 1);
        return res + 1;
    }

}
