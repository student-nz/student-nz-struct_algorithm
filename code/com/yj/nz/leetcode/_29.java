package com.yj.nz.leetcode;

//
/*
* 29. 两数相除
* 	给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
* 	返回被除数 dividend 除以除数 divisor 得到的商。
* 	整数除法的结果应当截去（truncate）其小数部分，例如：truncate(8.345) = 8 以及 truncate(-2.7335) = -2
* 	测试链接：https://leetcode.com/problems/divide-two-integers
* */
//	位运算加减乘除
public class _29 {
	/*
	 * 加法
	 * 总体思路：
	 *  1、两个数相加，得先算出 无进位相加信息 + 进位相加信息
	 *  2、然后一直遍历相加，直到 进位信息为0，则此时相加完毕
	 *  3、 (^: 无进位相加信息);  (先 & 后 << 1： 进位信息)
	 */

	public static int add(int a, int b) {
		int sum = a;
		while (b != 0) {
			sum = a ^ b;
			b = (a & b) << 1;
			a = sum;
		}
		return sum;
	}

	public static int negNum(int n) {
		return add(~n, 1);
	}

	/*
	 * 减法
	 * 总体思路：
	 *  1、减法其实就相当于 加上当前数的相反数
	 *  2、而在二进制中，相反数也等于 (~num + 1)
	 *  3、所以减法直接调用函数即可
	 */


	public static int minus(int a, int b) {
		return add(a, negNum(b));
	}

	/*
	 * 乘法
	 * 总体思路：
	 *  1、使用二进制的乘法，如 a:0100 * b:1100
	 *  2、转化为:
	 *      0100
	 *     *1100
	 *   -----------
	 *      0000
	 *     00000
	 *    010000
	 *   0100000
	 *  然后将乘出来的东西都相加即可
	 *  3、其实就可以看成 a不断往左移1位数 + b 不断往右移1位数，直至b为0
	 */


	public static int multi(int a, int b) {
		int res = 0;
		while (b != 0) {
			if ((b & 1) != 0) {
				res = add(res, a);
			}
			a <<= 1;
			b >>>= 1;
		}
		return res;
	}

	public static boolean isNeg(int n) {
		return n < 0;
	}

	/*
	 * 除法
	 * 总体思路：
	 *  1、除法的总体思路相当于一个猜测法则，如 a/b = c，就猜出 c的值，思路为 c * b = a
	 *  2、如先将 b 左移到与a的1最左侧位置，然后判断一下 a 是否大于 移动后的b，如果大于，则说明当前这个位置的 2的平方次肯定是有的
	 *  3、然后就是一直循环遍历这种操作，直至将c猜出来，a为0
	 */

	public static int div(int a, int b) {
		int x = isNeg(a) ? negNum(a) : a;
		int y = isNeg(b) ? negNum(b) : b;
		int res = 0;
		for (int i = 30; i >= 0; i = minus(i, 1)) {
			if ((x >> i) >= y) {
				res |= (1 << i);
				x = minus(x, y << i);
			}
		}
		return isNeg(a) ^ isNeg(b) ? negNum(res) : res;
	}

	/*
	* 特殊情况: 系统最小值的绝对值比系统最大值的绝对值大1
	* Integer.MIN_VALUE--->无法转成正数，但是我们可以先将Integer.MIN_VALUE+1，这样就可以转成正数，
	* 同时我们算出来的余数在加上1，再进行一次除法计算，将两次得到结果相加就是我们特殊情况的处理
	* */

	public static int divide(int a, int b) {
		if (a == Integer.MIN_VALUE && b == Integer.MIN_VALUE) {
			return 1;
		} else if (b == Integer.MIN_VALUE) {
			return 0;
		} else if (a == Integer.MIN_VALUE) {
			if (b == negNum(1)) {
				return Integer.MAX_VALUE;
			} else {
				int c = div(add(a, 1), b); //最小值加一取反后除的值
				return add(c, div(minus(a, multi(c, b)), b));//对上面的值还原，找出原数与上面的数之间的差值除以b，将除以b的值加上原数add的值得到最后值
			}
		} else {
			return div(a, b);
		}
	}

}
