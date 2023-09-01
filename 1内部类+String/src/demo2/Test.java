package demo2;

import java.sql.SQLOutput;
import java.util.Locale;

/**
 * ClassName: Test
 * Package: demo2
 * Description:
 *  String两个成员变量：value 和 hash
 *  字符串的比较：
 *      1、相不相同
 *      2、大小
 * @Author 全家乐
 * @Create 2023/5/4 19:31
 * Version 1.0
 */
class Person {

}
public class Test {
    public static void main18(String[] args) {
        String str = "abcd";
        System.out.println(str);

        final int[] arr = {1,2,3,4};
        arr[0] = 9;
    }
    public static void main17(String[] args) {
        //双引号引起来的值 就存在字符串常量池当中。如果有，就不存储，直接返回字符串常量池的对象即可
        String str1 = "abcd";
        String str2 = new String("abcd");
        System.out.println(str1 == str2);//false
    }
    public static void main16(String[] args) {
        //替换左右两边所有的空格
        String str = "  hello abcd   ";
        System.out.println(str);
        String ret = str.trim();
        System.out.println(ret);
    }
    public static void main15(String[] args) {
        String str = "abcdefgh";
        //返回从2位置截取的所有字符
        String s = str.substring(2);
        System.out.println(s);
        String s1 = str.substring(2,6);//左闭右开
        System.out.println(s1);
    }
    public static void main14(String[] args) {
        //多次分割
        String str = "name=zhangsan&age=18";
        String[] arr = str.split("&");
        for (int i = 0; i < arr.length; i++) {
            //System.out.println(arr[i]);
            String[] strings = arr[i].split("=");
            for (String s : strings) {
                System.out.println(s);
            }
        }
    }
    public static void main13(String[] args) {
        //3、如果一个字符串中有多个分隔符，可以用“|”作为连字符
        String str1 = "192&168=0.1";
        String[] arr = str1.split("&|=");
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
    public static void main12(String[] args) {
        /*
        注意：1、字符”|“，”*“，”+“都得加上转义字符，前面加上”\\“
             2、如果是”\"，那么写成”\\\\",
         */
        String str1 = "192.168.0.1";
        String[] arr = str1.split("\\.");
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
    public static void main11(String[] args) {
        //拆分
        String str1 = "hello little bitter";
        String[] arr = str1.split(" ",2);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
    public static void main10(String[] args) {
        String str1 = "abcdabcdabcde";
        //产生了一个心得对象，不是在原来上修改
        String s =  str1.replace('a','b');
        System.out.println(s);

        String ret2 = str1.replace("ab","ooo");
        System.out.println(ret2);

        String ret3 = str1.replaceAll("ab","555");
        System.out.println(ret3);

        String ret4 = str1.replaceFirst("ab","999");//替换第一个ab
        System.out.println(ret4);
    }
    public static void main9(String[] args) {
        String str1 = "abcdef";
        char[] arr = str1.toCharArray();
        System.out.println(arr);
        //格式化输出
        String s = String.format("%d-%d-%d",2019,9,14);
        System.out.println(s);
    }
    public static void main8(String[] args) {
        //大小写转换
        String str1 = "abcd";
        String str2 = "ABcd";
        System.out.println(str1.toUpperCase());
        System.out.println(str2.toLowerCase());
    }
    public static void main7(String[] args) {
        //数字转成字符串
        String str2 = String.valueOf(123);
        System.out.println(str2);
        String str3 = String.valueOf(new Person());
        System.out.println(str3);
        System.out.println("===========");

        String str1 = "123";
        int data = Integer.parseInt(str1);//字符串转数字
        System.out.println(data);
        double data2 = Double.parseDouble(str1);
        System.out.println(data2);
    }
    public static void main6(String[] args) {
        String str1 = "abcabcdabcae";
        System.out.println(str1.indexOf('c',6));//从指定位置找
        System.out.println(str1.indexOf("abcd"));//这个字符串的开始位置
        System.out.println(str1.lastIndexOf('a',8));  //从后往前找
    }
    public static void main5(String[] args) {
        String str1 = "hello";
        /*char ch = str1.charAt(1);
        System.out.println(ch);//e*/
        for (int i = 0; i < str1.length(); i++) {
            System.out.println(str1.charAt(i));
        }
    }
    public static void main4(String[] args) {
        String str1 = new String("hello");
        String str2 = new String("Hello");
        //str1和str2进行比较
        System.out.println(str1.compareTo(str2));
        System.out.println(str1.compareToIgnoreCase(str2));//忽略大小写
    }
    public static void main3(String[] args) {
       /* String str1 = "hello";
        String str2 = "hello";*/
        String str1 = new String("hello");
        String str2 = new String("hello");
        //比较两个引用 所指的对象当中的内容是否一致
        System.out.println(str1 == str2);//保存地址不同
        System.out.println(str1.equals(str2));
    }
    public static void main2(String[] args) {
        String str1 = "hello";
        System.out.println(str1.length());//方法
        int[] arr = {1,2,3,4};
        System.out.println(arr.length);//属性

        String str2 = "";
        System.out.println(str2.length());
        System.out.println(str2.isEmpty());//指向对象没有任何字符
        String str3 = null;//指不指向任何对象
    }
    public static void main1(String[] args) {
        String str1 = "hello";
        String str2 = new String("hello");
        System.out.println(str1);
        System.out.println(str2);
        char[] values = {'a','b','c','d'};
        String str3 = new String(values);   //把字符数组构成一个字符串
        System.out.println(str3);
    }
}
