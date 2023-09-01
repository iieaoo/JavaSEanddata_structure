package day04;

import java.util.Scanner;

/**
 * ClassName: Method
 * Package: day04
 * Description:
 *
 * @Author 全家乐
 * @Create 2023/4/21 16:27
 * Version 1.0
 */
public class Method {
    public static boolean isLeapYear(int year) {
        if (year % 400 == 0 || year % 100 != 0 && year % 4 == 0) {
            //System.out.println(year + "年是闰年");
            return true;
        }else {
            //System.out.println(year + "年不是闰年");
            return false;
        }
    }

    public static int add(int a,int b) {    //形参
        return a+b;
    }

    public static int facNum(int num) { //阶乘和
        int sum = 0;
        for (int i = 1; i <= num; i++){
            int ret = fac(i);
            sum += ret;
        }
        return sum;
    }

    public static int fac(int n) {  //求阶乘
        int ret = 1;
        for (int j = 1; j <= n; j++) {
            ret *= j;
        }
        return ret;
    }
    public static double fun() {
        //计算1/1-1/2+1/3-1/4+1/5 …… + 1/99 - 1/100 的值
        double sum = 0;
        int flag = 1;
        for (int i = 1; i <= 100; i++) {
            sum = sum + 1.0/i * flag;
            flag = -flag;
        }
        return sum;
    }
    public static void fun2(int n) {
        //输出一个整数的每一位，如：123的每一位是3，2，1
        while (n!=0) {
            System.out.print(n % 10 + ", ");
            n /= 10;
        }
    }
    public static void login() {
        //编写代码模拟三次密码输入的场景。 最多能输入三次密码，密码正确，提示“登录成功”,密码错误,可以重新输入,最多输入三次。三次均错，则提示退出程序
        int count = 3;
        Scanner sc = new Scanner(System.in);
        while (count!=0) {
            System.out.println("请输入你的密码");
            String passWord = sc.nextLine();
            //if(passWord == "123456") {
            if(passWord.equals("123456")) {
                System.out.println("登陆成功");
                break;
            }else {
                count--;
                System.out.println("你还有"+count+"次机会！");
            }
        }
    }
    public  static  int max2(int a,int b) {
       /* 创建方法求两个数的最大值max2，随后再写一个求3个数的最大值的函数max3。
        要求：在max3这个函数中，调用max2函数，来实现3个数的最大值计算*/
        return a > b ? a : b;
    }
    public  static  int max3(int a,int b,int c) {
        int temp = max2(a,b);
        return max2(temp,c);
    }

    public static void main(String[] args) {
        System.out.println(max2(2,6));
        System.out.println(max3(3,6,1));

        /*System.out.println(fun());
        //isLeapYear(2022); //没有用到返回值
        boolean flg = isLeapYear(2020); //要用到返回值，用同样的boolean类型接收它
        System.out.println(flg);
        add(2,3);   //实参*/

    /*    System.out.println(fac(5));
        int ret = facNum(5);
        System.out.println(ret);*/

        //fun2(123);
        //login();
    }
}
