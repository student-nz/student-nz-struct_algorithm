package com.yj.nz.demo;
import java.util.Comparator;

/**
 * ClassName:Code11_ShowComparator
 * Package:com.yj.nz.demo
 * Description:描述
 *
 * @Date:2022/9/12 20:13
 * @Author:NieZheng
 * @Version:1.0
 */

// 比较器
public class Code11_ShowComparator {

    public static class Student {
        public String name;
        public int id;
        public int age;

        public Student(String name, int id, int age) {
            this.name = name;
            this.id = id;
            this.age = age;
        }
    }

    // 谁id大，谁放前！
    public static class IdComparator implements Comparator<Student> {

        /*
        * 如果返回负数，认为第一个参数应该排在前面
        * 如果返回正数，认为第二个参数应该排在前面
        * 如果返回0，认为谁放前面无所谓
        * 记忆法则：
        *   第一个参数的值 - 第二个参数的值  -> 从小到大排序
        *   第二个参数的值 - 第一个参数的值  -> 从小到大排序
        * */
        @Override
        public int compare(Student o1, Student o2) {
            if (o1.id < o2.id) {
                return 1;
            } else if (o2.id < o1.id) {
                return -1;
            } else {
                return 0;
            }
        }
    }

    // 谁age大，谁放前！
    public static class AgeComparator implements Comparator<Student> {

        // 如果返回负数，认为第一个参数应该排在前面
        // 如果返回正数，认为第二个参数应该排在前面
        // 如果返回0，认为谁放前面无所谓
        @Override
        public int compare(Student o1, Student o2) {
            if (o1.age < o2.age) {
                return 1;
            } else if (o2.age < o1.age) {
                return -1;
            } else {
                return 0;
            }
        }
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void printStudents(Student[] students) {
        for (int i = 0; i < students.length; i++) {
            System.out.println(students[i].name + ", " + students[i].id + ", " + students[i].age);
        }
    }

}
