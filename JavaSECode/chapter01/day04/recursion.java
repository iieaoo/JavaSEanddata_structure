package day04;

/**
 * ClassName: recursion
 * Package: day04
 * Description:
 *1、自己调用自己
 * 2、有一个终止条件
 * 3、确定递归公式
 * @Author 全家乐
 * @Create 2023/4/21 20:24
 * Version 1.0
 */
public class recursion {
    public static int fac(int n){
        if(n == 1) {
            return 1;
        }
        int temp = n * fac(n-1);
        return temp;
    }
    public static void fac2(int n){
        //按顺序打印一个数字的每一位(例如 1234 打印出 1 2 3 4)    （递归）
        if(n > 9) {
            fac2(n / 10);
        }
        System.out.print(n%10 + " ");
    }
    public static int sum(int num) {
        //输入一个非负整数，返回组成它的数字之和
        if (num < 10) {
            return num;
        }
        return num%10 + sum(num/10);
    }
    public static int sum2(int i) {
        //递归求 1 + 2 + 3 + ... + 10
        if(i == 1) {
            return 1;
        }
        return i+sum2(i-1);
    }
    public static int rec(int n) {
        //递归求 N 的阶乘
        if(n == 1) {
            return 1;
        }
        return n*rec(n-1);
    }
    public  static  int fibonacci(int n) {
        //求斐波那契数列的第n项。(迭代(循环)实现)
        if (n==1 || n==2) {
            return 1;
        }
        int f1 = 1;
        int f2 = 1;
        int f3 = 0;
        for (int i=3; i <= n ; i++) {
            f3 = f1 + f2;
            f1 = f2;
            f2 = f3;
        }
        return f3;
    }
    public static int fi(int n) {
        if(n == 1 || n == 2) {  //效率低，斐波那契不适合递归
            return  1;
        }
        int temp = fi(n-1) + fi(n-2);
        return temp;
    }

    public static void hanota(int n,char pos1,char pos2,char pos3) {
        /*pos1 起始位置
        * pos2 中转位置
        * pos3 目的位置*/
        if(n == 1) {
            move(pos1,pos3);
            return;
        }
        hanota(n-1,pos1,pos3,pos2);
        move(pos1,pos3);
        hanota(n-1,pos2,pos1,pos3);
    }
    public static void move(char pos1,char pos2) {
        System.out.print(pos1 + "->" + pos2+" ");
    }

    public static int jump(int n) {
        //青蛙跳台阶：从前有一只青蛙他想跳台阶，有n级台阶，青蛙一次可以跳1级台阶，也可以跳2级台阶；问：该青蛙跳到第n级台阶一共有多少种跳法。
        if (n == 1 || n == 2) {
            return n;
        }else {
            return jump(n-1) + jump(n-2);
        }
    }
    public static int jump2(int n) {
        int a = 1;
        int b = 2;
        int res = 0;
        for (int i = 3; i <= n; i++) {
            res = a + b;
            a = b;
            b = res;
        }
        return res;
    }
    public static void main(String[] args) {
        System.out.println(jump(4));

        //System.out.println(fac(5));
        //System.out.println(sum(1729));
        //fac2(1234);
        //System.out.println(sum2(10));
        //System.out.println(rec(5));

      /*  System.out.println(fibonacci(1));
        System.out.println(fibonacci(2));
        System.out.println(fibonacci(3));
        System.out.println(fibonacci(4));
        System.out.println(fibonacci(5));

       System.out.println(fi(4));*/
        /*hanota(1,'A','B','C');
        System.out.println();
        hanota(2,'A','B','C');
        System.out.println();
        hanota(3,'A','B','C');
        System.out.println();*/
    }
}
