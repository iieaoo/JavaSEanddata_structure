package day04;

/**
 * ClassName: MethOverLoading
 * Package: day04
 * Description:
 *
 * @Author 全家乐
 * @Create 2023/4/21 17:53
 * Version 1.0
 */
public class MethOverLoading {
    public static int sum(int a,int b) {
        return a+b;
    }
    public static int sum(int a,int b,int c) {
        return a+b+c;
    }
    public static double sum(double a,double b) {
        return a+b;
    }

    public static void main(String[] args) {
    /*    方法重载：
            1、方法名相同
            2、方法的参数列表不同（顺序，个数，类型）
            3、和返回值没有关系*/
        int a = 20;
        int b = 10;
        int c = 2;
        double d1 = 1.2;
        double d2 = 2.3;
        System.out.println(sum(a,b));
        System.out.println(sum(a, b, c));
        System.out.println(sum(d1, d2));
    }
}
