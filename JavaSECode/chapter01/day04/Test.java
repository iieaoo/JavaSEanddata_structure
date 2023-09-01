package day04;

import java.util.Scanner;

/**
 * ClassName: Test
 * Package: day04
 * Description:
 *
 * @Author 全家乐
 * @Create 2023/4/21 13:56
 * Version 1.0
 */
public class Test {
    //输出乘法口诀表
    public static void main1(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(i + "*" + j + "=" + i * j + " ");
            }
            System.out.println();
        }
    }

    //最大公约数
    public static void main2(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = a % b;
        int x = a;
        int y = b;
        while (c != 0) {
            a = b;
            b = c;
            c = a % b;
        }
        System.out.println("最大公约数是" + b);
        System.out.println("最大公倍数是" + x * y / b);
    }

    public static void main3(String[] args) {
        //最大公约数，暴力穷举法；效率低
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int i = a < b ? a : b;
        for (; i > 0; i--) {
            if (a % i == 0 && b % i == 0) {
                System.out.println(i);
                break;
            }
        }
    }

    //水仙花数 153 = 1^3+5^3+3^3
    public static void main4(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i <= n; i++) {
            int count = 0;  //判断几位数
            int temp = i;
            while (temp != 0) {
                count++;
                temp = temp / 10;
            }
            temp = i;
            int sum = 0;
            while (temp != 0) {
                sum += Math.pow(temp % 10, count);//最后一位的count次方
                temp /= 10;
            }
            if (sum == i) {
                System.out.print(i + " ");
            }
        }
    }

    //写一个函数，返回参数二进制中1的个数
    public static void main5(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int count = 0;
        for (int i = 0; i < 32; i++) {
            if (((n >>> i) & 1) != 0) {
                count++;
            }
        }
        System.out.println(count);
    }

    public static void main6(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int count = 0;
        while (n != 0) {    //如果有一次相与为0；不用进行其他几次
            if ((n & 1) != 0) {
                count++;
            }
            n >>>= 1;
        }
        System.out.println(count);
    }

    public static void main7(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int count = 0;
        while (n != 0) {
            n = n & (n - 1);
            count++;
        }
        System.out.println(count);
    }

    //获取一个数二进制序列中所有的偶数位和奇数位，分别输出二进制序列
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        //求奇数位
        for (int i = 30; i >= 0; i -= 2) {
            System.out.print(((n >> i) & 1) + " ");
        }
        System.out.println();
        //求偶数
        for (int i = 31; i >= 1; i -= 2) {
            System.out.print(+((n >> i) & 1) + " ");
        }
    }
}