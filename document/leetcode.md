# 1. 两数之和

## 	问题：

​			给定一个整数数组 `nums` 和一个整数目标值 `target`，请你在该数组中找出和为目标值target 的那 两个整数，

​			并返回它们的数组下标

## 	解决思路：

​			依题意可知

​			给定条件：

​					1）整数数组nums 

​					2）整数目标值target

​			求结果：

​					在该数组中找出和为目标值target的那两个整数

​			本题采用哈希表实现：

​			为什么采用哈希表实现？

​					因为哈希表在数据的存储和查询上几乎可以看做常数时间, 效率就得到了极大的提升

## 	实现思路：

​					首先我们采用的是哈希表实现，就需要借助Java中的HashMap数据结构

​					我的设计思路就是用key保存迭代的数组元素

​					用目标值减去迭代的数组元素，判断该目标值减去迭代的数组元素是否存在于HashMap的key中，

​					如果存在，直接以数组形式返回HashMap的key对应的value和当前迭代元素索引，

​					即找到在该数组中找出和为目标值target的那两个整数

​	

# 	2. 两数相加

## 		问题：

​					给你两个非空的链表, 表示两个非负的整数

​					它们每位数字都是按照 逆序的方式存储的, 并且每个节点只能存储 一位数字

​					请你将两个数相加, 并以相同形式返回一个表示和的链表

## 		解决思路：

​					依题意可知：

​					给定条件：

​						1）两个非空的链表，表示两个非负的整数

​						2）每位数字按照 逆序方式存储，并且每个节点只能存储 一位数字

​					求结果：

​						两个数相加并以相同形式返回一个表示和的链表

## 		实现思路：

​						首先我们需要先准备8个标识符ca、n1和n2、n、c1、c2、node、pre

​						分别进行记录进位值，两个结点当前数字，两个头结点的值之和与进位值相加之和，两个头结点，新建结点，上一个结点

​						如果两个头结点其中一个不为空，获取两个头结点的值，再将两个头结点的值之和与进位值相加赋值给n

​						新建结点, 存取 n % 10 取模后的值,新建结点的下一个结点指向上一个结点，求进位值, 判断c1、c2是否为空，

​						不为空，指向下一个结点，继续下一次循环判断，直到c1和c2都为空 ，此时循环结束，如果进位值还保存了个1，

​						则pre变为老的node，新建一个节点重新赋值给node，即得到新的node，此时两链表相加完毕到一个标识和的链中，

​						但是此时链表是因为两链表数字是逆序方式存储且相加的，此时，我们就需要反转标识和的链表进行返回给我们调用者

​						这样我们就能得到我们相应的结果

​						反转链表思路：	

​							由于该题解决方案是采用单链表解决方案，反转单链链表就是上一个结点和下一个结点互换方向

​							此时我们就需要两个标识符pre和next分别标记上一个结点和下一个结点，如果头结点不为空，

​							先用next记录当前头结点下一个结点，以便作为下一次反转的头结点

​							然后再将当前头结点的下一个结点指向上一个结点，

​							当前头结点就变为了上一个结点，头结点就变为了当前结点的下一个结点

​							即next已经记录好的那个头结点的下一个结点

​								