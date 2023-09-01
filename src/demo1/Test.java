package demo1;

import jdk.nashorn.internal.ir.Flags;

import java.sql.SQLOutput;
import java.util.LinkedList;

/**
 * ClassName: Test
 * Package: demo1
 * Description:
 *  时间复杂度：（一般指最坏情况下 ）
 *      1、用常数1取代运行时间中的所有加法常数
 *      2、在修改后的运行次数函数中，只保留最高项
 *      3、如果最高阶项存在且不是1，则去除与这个项目相乘的常数。得到的结果就是大O阶。
 * @Author 全家乐
 * @Create 2023/5/7 11:03
 * Version 1.0
 */
public class Test {
    public static void bubbleSort(int[] array){
        //时间复杂度：    (n-1)+(n-2)+(n-3)+...+1      O（N^2）
        for (int i = 0; i < array.length; i++) {
            boolean flag = false;
            for (int j = 0; j < array.length-1-i; j++) {
                if(array[j] > array[j+1]) {
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                    flag = true;
                }
            }
            if (flag == true) {
                return;
            }
        }
    }
    public int binarySearch(int[] array,int val) {
        //二分查找
        //时间复杂度：  O（lgN）   N/2^x = 1    x=lgN
        int begin = 0;
        int end = array.length-1;
        while (begin <= end) {
            int mid = begin + ((end - begin)/2);
            if (array[mid] < val) {
                begin = mid+1;
            }else if (array[mid] < val) {
                end = mid-1;
            }else {
                return mid;
            }
        }
        return -1;
    }
    public long factorial(int N) {//递归
        //时间复杂度 递归-》 递归的次数*每次递归后所执行的次数  O（N）
        //空间复杂度  O（N）
        return N < 2 ? N : factorial(N-1)*N;
    }
    public int fibonacci(int N) {//斐波那契数列
        //  时间复杂度  树  1+2+4+8+。。。2^（n-1） 等比数列       O(2^n)
        //空间复杂度  O（N）
        return N  < 2 ? N : fibonacci(N-1) + fibonacci(N-2);
    }
    private static void testMethod() {
        System.out.println("testMethod");//静态方法不依赖于对象
    }
    public static void main(String[] args) {
        ((Test) null).testMethod();

        //LinkedList<String> linkedList = new LinkedList<>();//尖括号里放数据类型
        LinkedList<Integer> linkedList = new LinkedList<>(); //包装类  Integer基本数据类型 所对应的类类型
        //linkedList.add("hello");
        linkedList.add(10);
    }
}
