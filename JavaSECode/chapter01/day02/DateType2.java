package day02;

/**
 * ClassName: DateType2
 * Package: day02
 * Description:
 *
 * @Author 全家乐
 * @Create 2023/4/19 19:06
 * Version 1.0
 */
public class DateType2 {
    public static void main1(String[] args) {
        //String不是基本数据类型
        String str = "hello";
        System.out.println(str);
    }

    public static void main2(String[] args) {
        String str1 = "hello";
        String str2 = "world";
        System.out.println(str1+str2);
        int a = 10;
        int b = 20;
        System.out.println("a="+a);
        System.out.println("b="+b);
        System.out.println("a+b="+a+b);//字符串+其他类型-》字符串
        System.out.println(a+b+"是a+b的和");
        System.out.println("a+b" + (a+b));
    }

    public static void main3(String[] args) {
        int a = 12345;
        String ret =String.valueOf(a);
        System.out.println(ret);
    }

    public static void main(String[] args) {
        String str = "12345";
        int ret = Integer.valueOf(str);
        int ret2 = Integer.parseInt(str);
        System.out.println(ret);
        System.out.println(ret2);
        System.out.println(ret + 1);
        String str2 = "1.25";
        double d = Double.valueOf(str2);
        System.out.println(d);
    }
}
